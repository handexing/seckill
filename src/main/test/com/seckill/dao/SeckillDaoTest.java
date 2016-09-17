package com.seckill.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.seckill.entity.Seckill;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {
	
	@Resource
	SeckillDao seckillDao;

	@Test
	public void testQueryById() {
		Seckill seckill = seckillDao.queryById(1);
		System.out.println(seckill);
	}
	
	@Test
	public void queryAll() {
		List<Seckill> list = seckillDao.queryAll(0, 100);
		for (Seckill s : list) {
			System.out.println(s.toString());
		}
	}
	
	@Test
	public void reduceNumber() {
		int number = seckillDao.reduceNumber(1,new Date());
		System.out.println(number+"======");
	}

}
