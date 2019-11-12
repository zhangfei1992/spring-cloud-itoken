package feignclient9000.controller;

import feignclient9000.service.InfoClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Configuration
public class ConsumerController {

    @Autowired
    InfoClientService infoClientService;

    @RequestMapping(value = "/consumerInfo", method = RequestMethod.GET)
    public String consumerInfo(){
        return infoClientService.info();
    }
}
