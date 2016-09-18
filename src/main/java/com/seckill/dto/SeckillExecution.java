package com.seckill.dto;

import com.seckill.entity.SuccessKilled;
import com.seckill.enums.SeckillStateEnum;

/**
 * @ClassName: SeckillExecution
 * @Description: ��ɱִ�к�Ľ��
 * @author handx 908716835@qq.com
 * @date 2016��9��17�� ����5:57:30
 *
 */
public class SeckillExecution {

	private long seckillId;
	private int state;// ��ɱ״̬
	private String stateInfo;// ״̬����˵��
	private SuccessKilled successKilled;

	public SeckillExecution(long seckillId, SeckillStateEnum stateEnum, SuccessKilled successKilled) {
		super();
		this.seckillId = seckillId;
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.successKilled = successKilled;
	}

	public SeckillExecution(long seckillId,SeckillStateEnum stateEnum) {
		super();
		this.seckillId = seckillId;
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}

	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public SuccessKilled getSuccessKilled() {
		return successKilled;
	}

	public void setSuccessKilled(SuccessKilled successKilled) {
		this.successKilled = successKilled;
	}

}