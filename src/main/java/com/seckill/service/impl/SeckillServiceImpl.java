package com.seckill.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import com.seckill.dao.SeckillDao;
import com.seckill.dao.SuccessKilledDao;
import com.seckill.dto.Exposer;
import com.seckill.dto.SeckillExecution;
import com.seckill.entity.Seckill;
import com.seckill.entity.SuccessKilled;
import com.seckill.enums.SeckillStateEnum;
import com.seckill.exception.RepeatKillException;
import com.seckill.exception.SeckillCloseException;
import com.seckill.exception.SeckillException;
import com.seckill.service.SeckillService;

@Service
public class SeckillServiceImpl implements SeckillService {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SeckillDao seckillDao;
	
	@Autowired
	private SuccessKilledDao successKilledDao;

	// �û�����md5
	private final String slat = "sdshgjfg124332rtewrru#^$#%^*5uyhdfBHMLOIPI{";

	public List<Seckill> getSeckillList() {
		return seckillDao.queryAll(0, 4);
	}

	public Seckill getById(long seckillId) {
		return seckillDao.queryById(seckillId);
	}

	public Exposer exportSeckillUrl(long seckillId) {
		Seckill seckill = seckillDao.queryById(seckillId);
		if (seckill == null) {
			return new Exposer(false, seckillId);
		}

		Date startTime = seckill.getStartTime();
		Date endTime = seckill.getEndTime();
		Date nowTime = new Date();

		if (nowTime.getTime() < startTime.getTime() || nowTime.getTime() > endTime.getTime()) {
			return new Exposer(false, seckillId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
		}
		String md5 = getMd5(seckillId);
		return new Exposer(true, md5, seckillId);
	}

	private String getMd5(long seckillId) {
		String base = seckillId + "/" + slat;
		String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
		return md5;
	}

	@Transactional
	public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
			throws SeckillException, RepeatKillException, SeckillCloseException {

		if (md5 == null || !md5.equals(getMd5(seckillId))) {
			throw new SeckillException("��ɱ�����ݱ�������");
		}

		Date killTime = new Date();

		try {
			// �����
			int updateCount = seckillDao.reduceNumber(seckillId, killTime);
			if (updateCount <= 0) {
				// û�и��¼�¼,��ɱ����
				throw new SeckillCloseException("��ɱ����");
			} else {
				// ��¼��ɱ����
				int insertCount = successKilledDao.insertSuccessKilled(seckillId, userPhone);
				if (insertCount <= 0) {
					// �ظ���ɱ�����ݿ�ignore����i
					throw new RepeatKillException("�ظ���ɱ");
				} else {
					// ��ɱ�ɹ�
					SuccessKilled successKilled = successKilledDao.queryByIdWithSecKill(seckillId, userPhone);
					return new SeckillExecution(seckillId, SeckillStateEnum.SUCCESS, successKilled);
				}
			}
		} catch (SeckillCloseException e1) {
			throw e1;
		} catch (RepeatKillException e2) {
			throw e2;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			// ���б����쳣��ת���������쳣
			throw new SeckillException("seckill inner error:" + e.getMessage());
		}
	}

}
