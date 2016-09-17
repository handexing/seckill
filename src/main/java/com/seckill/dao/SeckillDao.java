package com.seckill.dao;

import java.util.Date;
import java.util.List;

import com.seckill.entity.Seckill;

public interface SeckillDao {

	/**
	 * @Title: reduceNumber 
	 * @Description: �����
	 * @param @param seckillId
	 * @param @param killTime
	 * @return int  ���Ӱ������>1����ʾ���µļ�¼����
	 */
	int reduceNumber (long seckillId,Date killTime);
	
	/**
	 * @Title: queryById 
	 * @Description: ����id��ѯ��ɱ����
	 * @param @param seckillId
	 * @return Seckill    �������� 
	 */
	Seckill queryById(long seckillId);
	
	/**
	 * @Title: queryAll 
	 * @Description: ����ƫ������ѯ��ɱ�б�
	 * @param @param offet
	 * @param @param limit
	 * @return List<Seckill>    �������� 
	 */
	List<Seckill> queryAll(int offet,int limit);
}
