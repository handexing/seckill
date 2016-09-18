package com.seckill.exception;

/**
 * @ClassName: SeckillException 
 * @Description:秒杀相关业务异常
 * @author handx 908716835@qq.com 
 * @date 2016年9月17日 下午6:05:24 
 *
 */
public class SeckillException extends RuntimeException {

	public SeckillException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public SeckillException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
}
