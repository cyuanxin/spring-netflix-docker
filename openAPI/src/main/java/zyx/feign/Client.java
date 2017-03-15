package zyx.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zhangyuanxin on 2017/3/13.
 */
@FeignClient(name = "client")
public interface Client {

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    String hello();
}

