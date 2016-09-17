package com.seckill.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.seckill.entity.Seckill;

public interface SeckillDao {

	/**
	 * @Title: reduceNumber 
	 * @Description: �����
	 * @param @param seckillId
	 * @param @param killTime
	 * @return int  ���Ӱ������>1����ʾ���µļ�¼����
	 */
	int reduceNumber (@Param("seckillId")long seckillId,@Param("killTime")Date killTime);
	
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
	List<Seckill> queryAll(@Param("offset")int offset,@Param("limit")int limit);
}
