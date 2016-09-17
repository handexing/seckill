package com.seckill.dao;

import com.seckill.entity.SuccessKilled;

public interface SuccessKilledDao {

	/**
	 * @Title: insertSuccessKilled 
	 * @Description:���빺����ϸ���ɹ����ظ���
	 * @param @param seckillId
	 * @param @param userPhone
	 * @return int ���������
	 */
	int insertSuccessKilled(long seckillId,long userPhone);
	
	/**
	 * 
	 * @Title: queryById 
	 * @Description: ����id��ѯsuccesskilled��Я����ɱ��Ʒ����
	 * @param @param seckillId
	 * @param @return    �趨�ļ� 
	 * @return SuccessKilled    �������� 
	 * @throws
	 */
	SuccessKilled queryByIdWithSecKill(long seckillId);
}
