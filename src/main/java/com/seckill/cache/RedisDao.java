package com.seckill.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.seckill.entity.Seckill;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisDao {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	private JedisPool jedisPool;
	
	public RedisDao(String ip,int port){
		jedisPool = new JedisPool(ip, port);
	}
	
	//序列化
	private RuntimeSchema<Seckill> schema = RuntimeSchema.createFrom(Seckill.class);
	
	
	public Seckill getSeckill(long seckillId){
		try {
			Jedis jedis = jedisPool.getResource();
			try {
				String key ="seckill:"+seckillId;
				byte[] bs = jedis.get(key.getBytes());
				//缓存获取到了
				if (bs!=null) {
					//空对象
					Seckill seckill = schema.newMessage();
					ProtostuffIOUtil.mergeFrom(bs, seckill, schema);
					return seckill;
				}
			} finally {
				jedis.close();
			}
			
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		return null;
	}
	
	public String putSeckill(Seckill seckill){
		try {
			Jedis jedis = jedisPool.getResource();
			try{
				String key ="seckill:"+seckill.getSeckillId();
				byte[] byteArray = ProtostuffIOUtil.toByteArray(seckill, schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
				//超市缓存
				int timeout =60*60;//超市缓存
				String result = jedis.setex(key.getBytes(), timeout, byteArray);
				return result;
			}finally{
				jedis.close();
			}
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		return null;
	}
	
}
