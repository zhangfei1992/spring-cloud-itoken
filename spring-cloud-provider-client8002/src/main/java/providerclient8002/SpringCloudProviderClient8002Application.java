package providerclient8002;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"providerclient8002.dao"})//扫描接口
public class SpringCloudProviderClient8002Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProviderClient8002Application.class, args);
    }

}
