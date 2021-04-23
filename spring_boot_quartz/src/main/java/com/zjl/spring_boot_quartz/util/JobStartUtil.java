package com.zjl.spring_boot_quartz.util;

import com.zjl.commons.util.log.ErrorLogUtil;
import com.zjl.spring_boot_quartz.dao.SelfJobDao;
import com.zjl.spring_boot_quartz.model.SelfJobPO;
import com.zjl.spring_boot_quartz.quartz.QuartzUtil;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhou
 * @version 1.0
 * @className JobStartUtil
 * @description
 * @date 2021/04/20 10:27
 **/
@Component
public class JobStartUtil {

    @Autowired
    private SelfJobDao selfJobDao;
    @Resource
    private Scheduler scheduler;


    @PostConstruct
    public void init(){
        List<SelfJobPO> selfJobPOList =  selfJobDao.getAllJob();
        for (SelfJobPO selfJobPO : selfJobPOList) {
            try {
                Trigger jobTrigger = QuartzUtil.getJobTrigger(scheduler, selfJobPO.getJobId(), selfJobPO.getGroupName());
                if (null == jobTrigger){
                    QuartzUtil.createJob(scheduler,selfJobPO);
                }else {
                    QuartzUtil.updateJob(scheduler,selfJobPO);
                }
            } catch (SchedulerException e) {
                ErrorLogUtil.errorLog(e);
            }
        }
    }
}
