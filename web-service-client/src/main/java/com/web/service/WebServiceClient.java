package com.web.service;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * @author misterWei
 * @create 2018年11月05号:14点39分
 * @mailbox mynameisweiyan@gmail.com
 */
@WebService(name = "web-service-client")

public class WebServiceClient  {

    public String getString(){
        return "say Hello";
    }

    //发布webService服务
    public static void main(String[] args) {
        String address="http://127.0.0.1:9999/WebServiceClient";
        Endpoint.publish(address, new WebServiceClient());

    }
}
