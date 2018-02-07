package com.springboot.batch.batchdemo;

import com.springboot.batch.job.Processor;
import com.springboot.batch.job.Reader;
import com.springboot.batch.job.Writer;
import com.springboot.batch.listener.JobCompletionListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableBatchProcessing
@ComponentScan (basePackages = "com.springboot.batch.controller")
public class BatchDemoApplication {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;


    public static void main (String[] args) {
        SpringApplication.run (BatchDemoApplication.class, args);
    }


    @Bean
    public Job processJob () {
        return jobBuilderFactory.get ("processJob")
                         .incrementer (new RunIdIncrementer ()).listener (listener ())
                         .flow (orderStep1 ()).end ().build ();
    }

    @Bean
    public Step orderStep1 () {
        return stepBuilderFactory.get ("orderStep1").<String, String>chunk (1)
                         .reader (new Reader ()).processor (new Processor ())
                         .writer (new Writer ()).build ();
    }


    @Bean
    public JobExecutionListener listener () {
        return new JobCompletionListener ();
    }


}
