package com.seckill.exception;

/**
 * @ClassName: RepeatKillException 
 * @Description: �ظ���ɱ�쳣(�������쳣)
 * @author handx 908716835@qq.com 
 * @date 2016��9��17�� ����6:01:20 
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
