package com.seckill.dto;

/**
 * @ClassName: SeckillResult
 * @Description: 封装json结果,所有ajax请求返回的类型
 * @author handx 908716835@qq.com
 * @date 2016年9月22日 下午10:07:24
 * 
 * @param <T>
 */
public class SeckillResult<T> {

	private boolean success;

	private T data;
	private String erroe;

	public SeckillResult(boolean success, String erroe) {
		super();
		this.success = success;
		this.erroe = erroe;
	}

	public SeckillResult(boolean success, T data) {
		super();
		this.success = success;
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getErroe() {
		return erroe;
	}

	public void setErroe(String erroe) {
		this.erroe = erroe;
	}

}
