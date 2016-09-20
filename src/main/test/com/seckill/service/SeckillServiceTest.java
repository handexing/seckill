package com.seckill.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.seckill.dto.Exposer;
import com.seckill.dto.SeckillExecution;
import com.seckill.entity.Seckill;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml", })
public class SeckillServiceTest {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	SeckillService seckillService;
	
	@Test
	public void getSeckillList(){
		List<Seckill> seckillList = seckillService.getSeckillList();
		log.info("seckillList={}", seckillList);
	}
	
	@Test
	public void getById(){
		Seckill seckill = seckillService.getById(1);
		log.info("seckill={}", seckill);
	}
	
	
	@Test
	public void exportSeckillUrl(){
		Exposer exposer = seckillService.exportSeckillUrl(1);
		log.info("exposer={}", exposer);
	}
	
	
	@Test
	public void executeSeckill(){
		Exposer exposer = seckillService.exportSeckillUrl(1);
		SeckillExecution seckillExecution = seckillService.executeSeckill(1,15618243357l,exposer.getMd5());
		log.info("seckillExecution={}", seckillExecution);
	}
	
	

}
