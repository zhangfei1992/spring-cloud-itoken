package providerclient8001;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableHystrixDashboard
@MapperScan(basePackages = {"providerclient8001.dao"})//扫描接口
public class SpringCloudProviderClient8001Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProviderClient8001Application.class, args);
    }

}
