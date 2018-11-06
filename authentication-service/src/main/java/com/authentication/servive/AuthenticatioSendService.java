package com.authentication.servive;

/**
 * @author misterWei
 * @create 2018年11月06号:15点05分
 * @mailbox mynameisweiyan@gmail.com
 */
public class AuthenticatioSendService {
    public static void main(String[] args) {
        //realName=身份证姓名&cardNo=身份证号码
        String params="realName="+"xxx"+"&cardNo="+666l;
        Object send = api.send("9f9a7246b0e44cba81a8cca13a480b95", "https://1.api.apistore.cn/idcard3", params);
        System.out.println(send);

    }


}
