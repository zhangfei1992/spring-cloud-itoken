package providerclient8001.controller;

import common.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import providerclient8001.service.DeptService;

import java.util.List;

@RestController
@RefreshScope
public class DeptController {
    @Autowired
    private DeptService service;
    @Qualifier("discoveryClient")
    @Autowired
    private DiscoveryClient client;
    @Value("${test}")
    public String name;
    @Value("${spring.datasource.url}")
    public String name2;

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return service.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id) {
        System.out.println("i am 8001 ");
        return service.get(id);
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list() {
        return service.list();
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String info() {
        return "Hello, cloud-provider";
    }

//	@Autowired
//	private DiscoveryClient client;

    /**
     * 服务发现：可以得到当前在eureka中已注册的服务
     *
     * @return
     */
    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery() {
        List<String> list = client.getServices();
        System.out.println("**********" + list);
        System.out.println(name);
        System.out.println(name2);
        List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-CONFIG-PROVIDER-CLIENT8001");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }

}
