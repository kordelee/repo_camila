package com.junefw.infra.scheduler;

import org.springframework.stereotype.Repository;

import com.junefw.common.base.BaseDao;

@Repository
public interface SchedulerDao extends BaseDao {

	public int maleInsert();

}
