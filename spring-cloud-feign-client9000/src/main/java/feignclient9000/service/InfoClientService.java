package feignclient9000.service;

import feignclient9000.service.hystrix.InfoFallBackImpl;
import feignclient9000.config.MyFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

//1.name为被调用的服务应用名称.
//2.InfoFallBack作为熔断实现，当请求cloud-provider失败时调用其中的方法.
//3.feign配置.
@FeignClient(name = "microservicecloud-config-provider-client", fallback = InfoFallBackImpl.class, configuration = MyFeignConfig.class)
public interface InfoClientService {
    //被请求微服务的地址
    @RequestMapping("/info")
    String info();
}
