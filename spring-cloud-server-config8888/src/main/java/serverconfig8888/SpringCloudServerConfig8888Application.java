package serverconfig8888;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudServerConfig8888Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudServerConfig8888Application.class, args);
    }

}
