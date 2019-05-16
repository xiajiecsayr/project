package com.qhit.utils;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Component
public class HttpUtil {

    @Resource
    LoadBalancerClient loadBalancerClient;

    public Object getForList(String servername, String mapping,Class c ,Map map){
        ServiceInstance instance = loadBalancerClient.choose(servername);
        String url = "http://"+instance.getHost()+":"+instance.getPort()+"/"+mapping+"?1=1";
        for (Object key:map.keySet()){
            url+= "&"+key+"="+map.get(key);
        }
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url,c);
    }

    public Object getForList(String servername, String mapping,Class c){
        ServiceInstance instance = loadBalancerClient.choose(servername);
        String url = "http://"+instance.getHost()+":"+instance.getPort()+"/"+mapping;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url,c);
    }


}
