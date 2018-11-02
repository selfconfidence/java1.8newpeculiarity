package com.mail.send;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @author misterWei
 * @create 2018年11月02号:09点15分
 * @mailbox mynameisweiyan@gmail.com
 */
public class MailSend {
    public static void main(String [] args) throws Exception
    {
        // 收件人电子邮箱
        String to = "mynameisweiyan@gmail.com";

        // 发件人电子邮箱
        String from = "aaa@store.com";

        // 指定发送邮件的主机为 localhost
        String host = "localhost";

        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);

        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties);


            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: 头部头字段
            message.setSubject("This is the Subject Line!");

            // 设置消息体
            message.setText("Java代码 发送的");

            // 发送消息
            Transport.send(message);
            System.out.println("Sent message successfully....");

    }

}
