package eurekaclient7003;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEurekaClient7003Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaClient7003Application.class, args);
    }

}
