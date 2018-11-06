package com.web.service;

import a.b.c.WebServiceClient;
import a.b.c.WebServiceClientService;

/**
 * @author misterWei
 * @create 2018年11月05号:14点58分
 * @mailbox mynameisweiyan@gmail.com
 */
public class TestWeb {

    public static void main(String[] args) {
        WebServiceClientService webServiceClientService = new WebServiceClientService();
        WebServiceClient webServiceClientPort = webServiceClientService.getWebServiceClientPort();
        System.out.println(webServiceClientPort.getString());
    }

}
