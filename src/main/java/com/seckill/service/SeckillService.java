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
	 * @Description: 查询所有秒杀记录
	 * @return List<Seckill> 返回类型
	 */
	List<Seckill> getSeckillList();

	/**
	 * @Title: getById
	 * @Description:查询单个秒杀记录
	 * @param @param
	 *            seckillId
	 * @return Seckill 返回类型
	 */
	Seckill getById(long seckillId);

	/**
	 * @Title: exportSeckillUrl
	 * @Description: 秒杀开始时输出秒杀接口地址，否则输出系统时间和秒杀时间
	 * @return Exposer 返回类型
	 */
	Exposer exportSeckillUrl(long seckillId);

	/**
	 * 
	 * @Title: executeSeckill 
	 * @Description: 执行秒杀操作
	 * @param @param seckillId
	 * @param @param userPhone
	 * @return SeckillExecution    返回类型 
	 */
	SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
			throws SeckillException,RepeatKillException,SeckillCloseException;

	SeckillExecution executeSeckillProcedure(long seckillId, long userPhone, String md5)
			throws SeckillException,RepeatKillException,SeckillCloseException;
	
}
