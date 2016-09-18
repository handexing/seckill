package com.seckill.enums;

/**
 * @ClassName: SeckillStateEnum
 * @Description: 使用枚举表述常量数据字段
 * @author handx 908716835@qq.com
 * @date 2016年9月18日 下午9:51:56
 */
public enum SeckillStateEnum {
	SUCCESS(1, "秒杀成功"), NED(0, "秒杀结束"), REPEAT_KILL(-1, "重复秒杀"), INNER_ERROR(-2, "系统异常"), DATA_REWRITE(-3, "数据改写");

	private int state;
	private String stateInfo;

	private SeckillStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
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

	public static SeckillStateEnum stateOf(int index) {
		for (SeckillStateEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}

}
