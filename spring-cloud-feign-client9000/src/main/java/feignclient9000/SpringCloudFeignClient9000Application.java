package feignclient9000;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableHystrixDashboard
@EnableFeignClients //调用者启动时，打开Feign开关
@EnableDiscoveryClient
public class SpringCloudFeignClient9000Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudFeignClient9000Application.class, args);
    }

}
