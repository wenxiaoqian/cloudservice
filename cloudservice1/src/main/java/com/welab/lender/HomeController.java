package com.welab.lender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/")
public class HomeController {

    private Random random = new Random();

    @Autowired
    @Qualifier("httpRemoteService")
    RemoteService remoteService;

    @RequestMapping("start")
    public String start() throws Exception {

        int sleep = random.nextInt(100);
        TimeUnit.MILLISECONDS.sleep(sleep);

        LinkedMultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        Map<String, Object> response = remoteService.get("http://localhost:9090/service2", params, Map.class);
        return " [service1 sleep " + sleep + " ms]" + response.toString();
    }

}