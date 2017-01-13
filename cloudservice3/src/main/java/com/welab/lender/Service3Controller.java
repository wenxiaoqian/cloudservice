package com.welab.lender;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by WXQ on 2016/9/18.
 */
@RestController
public class Service3Controller {

    @RequestMapping("bar")
    public Map<String,String> bar() throws InterruptedException, IOException {  //service3 method
        Random random = new Random();
        int sleep= random.nextInt(100);
        TimeUnit.MILLISECONDS.sleep(sleep);
        Map<String,String> values = new HashMap<String,String>();
        values.put("desc", "service3 sleep " + sleep+" ms");
        return values;
    }

}
