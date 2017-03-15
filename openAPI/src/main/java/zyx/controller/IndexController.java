package zyx.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import zyx.feign.Client;

/**
 * Created by zhangyuanxin on 2017/3/13.
 */
@RestController
public class IndexController {
    @Autowired
    private Client client;
    @Autowired
    private EurekaClient eurekaClient;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello() {
        return client.hello();
    }

    @RequestMapping(value = "hello2", method = RequestMethod.GET)
    public String hello2() {
        Application application = eurekaClient.getApplication("client");
        InstanceInfo instanceInfo = application.getInstances().get(0);
        String results = restTemplate.getForObject("client/hello", String.class);
        return results;
    }
}
