package com.seckill.exception;

/**
 * @ClassName: RepeatKillException 
 * @Description: 重复秒杀异常(运行期异常)
 * @author handx 908716835@qq.com 
 * @date 2016年9月17日 下午6:01:20 
 *
 */
public class RepeatKillException extends SeckillException {

	public RepeatKillException(String message, Throwable cause) {
		super(message, cause);
	}

	public RepeatKillException(String message) {
		super(message);
	}


}
