package com.seckill.dao;

import java.util.Date;
import java.util.List;

import com.seckill.entity.Seckill;

public interface SeckillDao {

	/**
	 * @Title: reduceNumber 
	 * @Description: 减库存
	 * @param @param seckillId
	 * @param @param killTime
	 * @return int  如果影响行数>1，表示更新的记录行数
	 */
	int reduceNumber (long seckillId,Date killTime);
	
	/**
	 * @Title: queryById 
	 * @Description: 根据id查询秒杀对象
	 * @param @param seckillId
	 * @return Seckill    返回类型 
	 */
	Seckill queryById(long seckillId);
	
	/**
	 * @Title: queryAll 
	 * @Description: 根据偏移量查询秒杀列表
	 * @param @param offet
	 * @param @param limit
	 * @return List<Seckill>    返回类型 
	 */
	List<Seckill> queryAll(int offet,int limit);
}
