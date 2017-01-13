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
public class Service4Controller {

    @RequestMapping("tar")
    public Map<String,String> tar() throws InterruptedException, IOException { //service4 method
        Random random = new Random();
        int sleep= random.nextInt(1000);
        TimeUnit.MILLISECONDS.sleep(sleep);
        Map<String,String> values = new HashMap<String,String>();
        values.put("desc", "service4 sleep " + sleep+" ms");

        return values;
    }

}
