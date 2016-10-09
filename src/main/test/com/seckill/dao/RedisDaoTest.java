package com.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.seckill.cache.RedisDao;
import com.seckill.entity.Seckill;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class RedisDaoTest {

	@Autowired
	private RedisDao redisdao;
	@Autowired
	private SeckillDao seckillDao;
	
	@Test
	public void seckillTest(){
		Seckill seckill = redisdao.getSeckill(1);
		if (seckill==null) {
			Seckill s = seckillDao.queryById(1);
			if (s!=null) {
				String result = redisdao.putSeckill(s);
				System.out.println(result);
				Seckill s1 = redisdao.getSeckill(1);
				System.out.println(s1);
			}
		}
	}
	
	
}
