package com.seckill.exception;

/**
 * @ClassName: SeckillCloseException
 * @Description: 秒杀关闭异常
 * @author handx 908716835@qq.com
 * @date 2016年9月17日 下午6:04:29
 *
 */
public class SeckillCloseException extends SeckillException {

	public SeckillCloseException(String message, Throwable cause) {
		super(message, cause);
	}

	public SeckillCloseException(String message) {
		super(message);
	}

}
