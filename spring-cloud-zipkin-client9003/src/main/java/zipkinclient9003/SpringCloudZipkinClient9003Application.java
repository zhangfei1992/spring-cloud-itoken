package zipkinclient9003;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin2.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
@EnableDiscoveryClient
public class SpringCloudZipkinClient9003Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudZipkinClient9003Application.class, args);
    }

}
