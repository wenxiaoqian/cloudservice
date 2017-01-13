package com.welab.lender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.LinkedMultiValueMap;
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
public class Service2Controller {

    @Autowired
    @Qualifier("httpRemoteService")
    RemoteService remoteService;

    @RequestMapping("service2")
    public Map<String, String> foo() throws Exception {
        Random random = new Random();
        int sleep= random.nextInt(100);
        TimeUnit.MILLISECONDS.sleep(sleep);

        Map<String, String> response1 = remoteService.get("http://localhost:9091/bar", Map.class);

        Map<String, String> response2 = remoteService.get("http://localhost:9092/tar", Map.class);

        //String result = response1.toString() + response2.toString();
        Map<String,String> values = new HashMap<String,String>();
        values.put("desc", "service2 sleep " + sleep+" ms");

        return values;
    }

}
