package com.seckill.service;

import java.util.List;

import com.seckill.dto.Exposer;
import com.seckill.dto.SeckillExecution;
import com.seckill.entity.Seckill;
import com.seckill.exception.RepeatKillException;
import com.seckill.exception.SeckillCloseException;
import com.seckill.exception.SeckillException;

public interface SeckillService {

	/**
	 * @Title: getSeckillList
	 * @Description: ��ѯ������ɱ��¼
	 * @return List<Seckill> ��������
	 */
	List<Seckill> getSeckillList();

	/**
	 * @Title: getById
	 * @Description:��ѯ������ɱ��¼
	 * @param @param
	 *            seckillId
	 * @return Seckill ��������
	 */
	Seckill getById(long seckillId);

	/**
	 * @Title: exportSeckillUrl
	 * @Description: ��ɱ��ʼʱ�����ɱ�ӿڵ�ַ���������ϵͳʱ�����ɱʱ��
	 * @return Exposer ��������
	 */
	Exposer exportSeckillUrl(long seckillId);

	/**
	 * 
	 * @Title: executeSeckill 
	 * @Description: ִ����ɱ����
	 * @param @param seckillId
	 * @param @param userPhone
	 * @return SeckillExecution    �������� 
	 */
	SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
			throws SeckillException,RepeatKillException,SeckillCloseException;

	SeckillExecution executeSeckillProcedure(long seckillId, long userPhone, String md5)
			throws SeckillException,RepeatKillException,SeckillCloseException;
	
}
