package hystrixdashclient9002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrixDashboard
public class SpringCloudHystrixdashClient9002Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudHystrixdashClient9002Application.class, args);
    }

}
