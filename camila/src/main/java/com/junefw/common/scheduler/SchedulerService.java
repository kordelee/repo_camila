package com.junefw.common.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.junefw.common.base.BaseService;

@Service
public class SchedulerService extends BaseService{

	@Autowired
	SchedulerDao dao;
//	*******
//	초분시일월주년
//	@Scheduled(cron = "*/20 * * * * *") // 10초마다 실행
//	@Scheduled(cron = "0 0 0/1 * * *") //1시간마다
//	@Scheduled(cron = "0 0 0 * * *") //매일자정
//	@Scheduled(cron = "0 30 0 * * *") //새벽12시반
//	@Scheduled(cron = "0 0 1 * * *") //새벽1시
//	@Scheduled(cron = "0 0 2 * * *") //새벽2시
//	@Scheduled(cron = "0 0 3 * * *") //새벽3시
	public void run1() {
		dao.maleInsert();
	}
}
