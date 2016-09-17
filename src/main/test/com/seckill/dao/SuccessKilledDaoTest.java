package com.seckill.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.seckill.entity.SuccessKilled;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml" })
public class SuccessKilledDaoTest {

	@Resource
	SuccessKilledDao successKilledDao;

	@Test
	public void insertSuccessKilled() {
		int counts = successKilledDao.insertSuccessKilled(1, 15618243357L);
		System.out.println(counts);
	}

	@Test
	public void queryByIdWithSecKill() {
		SuccessKilled killed = successKilledDao.queryByIdWithSecKill(1, 15618243357L);
		System.out.println(killed);
	}
}
