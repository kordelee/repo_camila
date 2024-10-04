package com.junefw.infra.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.junefw.common.base.BaseService;

@Service
public class SchedulerService extends BaseService{

	@Autowired
	SchedulerDao dao;
	
	
//	@Scheduled(cron = "*/20 * * * * *") // 10초마다 실행
//	@Scheduled(cron = "0 0 0/1 * * *") //1시간마다
	@Scheduled(cron = "0 0 0 * * *") //매일자정
	public void run1() {
		dao.maleInsert();
	}
}
