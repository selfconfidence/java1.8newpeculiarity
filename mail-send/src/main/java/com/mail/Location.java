package com.mail;

import com.alibaba.fastjson.JSONObject;
import com.mail.utils.HttpClient;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author misterWei
 * @create 2018年11月02号:11点22分
 * @mailbox mynameisweiyan@gmail.com
 */
public class Location {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        try {
            HttpClient httpClient = new HttpClient("http://api.map.baidu.com/location/ip");
            map.put("ip", "192.168.31.52");
            map.put("ak", "SSWfmQxfImQtH3ZeRRAhbHF9h37MeDXH");

            httpClient.setParameter(map);
            httpClient.get();
            String content = httpClient.getContent();
            System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void connectionIp() throws Exception {
// 获取连接客户端工具
        CloseableHttpClient httpClient = HttpClients.createDefault();

        String entityStr = null;
        CloseableHttpResponse response = null;


        /*
         * 由于GET请求的参数都是拼装在URL地址后方，所以我们要构建一个URL，带参数
         */
        URIBuilder uriBuilder = new URIBuilder("http://api.map.baidu.com/location/ip");
        /** 第一种添加参数的形式 */
        /*uriBuilder.addParameter("name", "root");
        uriBuilder.addParameter("password", "123456");*/
        /** 第二种添加参数的形式 */
        List<NameValuePair> list = new LinkedList<>();
        BasicNameValuePair param1 = new BasicNameValuePair("ip", "125.41.184.111".trim());
        list.add(param1);
        BasicNameValuePair param2 = new BasicNameValuePair("ak", "SSWfmQxfImQtH3ZeRRAhbHF9h37MeDXH");
        list.add(param2);
        uriBuilder.setParameters(list);

        // 根据带参数的URI对象构建GET请求对象
        HttpGet httpGet = new HttpGet(uriBuilder.build());

        /*
         * 添加请求头信息
         *
         */
        // 浏览器表示


        // 执行请求
        response = httpClient.execute(httpGet);
        // 获得响应的实体对象
        HttpEntity entity = response.getEntity();
        // 使用Apache提供的工具类进行转换成字符串
        entityStr = EntityUtils.toString(entity, "utf-8");
        String s = decodeUnicode(entityStr);
        Map parse = (Map) JSONObject.parse(s);
        System.out.println(parse);

    }

    //\u90d1\u5dde\u5e02 转成中文格式 工具method
    public static String decodeUnicode(String str) {
        Charset set = Charset.forName("UTF-16");
        Pattern p = Pattern.compile("\\\\u([0-9a-fA-F]{4})");
        Matcher m = p.matcher( str );
        int start = 0 ;
        int start2 = 0 ;
        StringBuffer sb = new StringBuffer();
        while( m.find( start ) ) {
            start2 = m.start() ;
            if( start2 > start ){
                String seg = str.substring(start, start2) ;
                sb.append( seg );
            }
            String code = m.group( 1 );
            int i = Integer.valueOf( code , 16 );
            byte[] bb = new byte[ 4 ] ;
            bb[ 0 ] = (byte) ((i >> 8) & 0xFF );
            bb[ 1 ] = (byte) ( i & 0xFF ) ;
            ByteBuffer b = ByteBuffer.wrap(bb);
            sb.append( String.valueOf( set.decode(b) ).trim() );
            start = m.end() ;
        }
        start2 = str.length() ;
        if( start2 > start ){
            String seg = str.substring(start, start2) ;
            sb.append( seg );
        }
        return sb.toString() ;
    }
}
