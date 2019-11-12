package feignclient9000.service.hystrix;

import feignclient9000.service.InfoClientService;
import org.springframework.stereotype.Component;

@Component
public class InfoFallBackImpl implements InfoClientService {
    @Override
    public String info() {
        return "fallback info";
    }
}
