package com.springboot.batch.job;

import org.springframework.batch.item.ItemProcessor;

public class Processor implements ItemProcessor<String, String> {

    @Override
    public String process (String o) throws Exception {
        return o.toUpperCase ();
    }
}
