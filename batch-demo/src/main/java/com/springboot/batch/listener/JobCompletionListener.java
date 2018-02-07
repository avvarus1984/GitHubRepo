package com.springboot.batch.listener;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class JobCompletionListener implements JobExecutionListener {
    @Override
    public void beforeJob (JobExecution jobExecution) {

        if (jobExecution.getStatus () == BatchStatus.COMPLETED)
            System.out.println ("BATCH JOB COMPLETED");

    }

    @Override
    public void afterJob (JobExecution jobExecution) {


    }
}
