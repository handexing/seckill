package com.seckill.dao;

import org.apache.ibatis.annotations.Param;

import com.seckill.entity.SuccessKilled;

public interface SuccessKilledDao {

	/**
	 * @Title: insertSuccessKilled 
	 * @Description:插入购买明细（可过滤重复）
	 * @param @param seckillId
	 * @param @param userPhone
	 * @return int 插入的行数
	 */
	int insertSuccessKilled(@Param("seckillId")long seckillId,@Param("userPhone")long userPhone);
	
	/**
	 * 
	 * @Title: queryById 
	 * @Description: 根据id查询successkilled并携带秒杀商品对象
	 * @param @param seckillId
	 * @param @return    设定文件 
	 * @return SuccessKilled    返回类型 
	 * @throws
	 */
	SuccessKilled queryByIdWithSecKill(@Param("seckillId")long seckillId,@Param("userPhone")long userPhone);
}
