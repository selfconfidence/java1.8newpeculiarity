import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * @author misterWei
 * @create 2018年10月25号:13点31分
 * @mailbox mynameisweiyan@gmail.com
 */
public class CSDNRequest  extends Thread {
    private static int start=0;
    @Test
    public void requestCSDN() throws IOException {
        for (int i =0;i<10000 ; i++){
            Runnable runnable = () -> {
                try {
                    reuqests();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            };
            runnable.run();

        }
        for (int i =0;i<10000 ; i++) {
            Runnable runnable = () -> {
                try {
                    reuqests();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            };
            runnable.run();
        }
    }
    private static void reuqests() throws IOException {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("https://blog.csdn.net/mister_Wei");
        HttpResponse execute = httpClient.execute(httpGet);
        if (execute.getStatusLine().getStatusCode()==200) {
            HttpEntity entity = execute.getEntity();
            System.out.println(EntityUtils.toString(entity).length()>900);
            start++;
            System.out.println(start);
        }

    }
   @SuppressWarnings("all")
    public static void main(String[] args) throws IOException {
        Runnable runnable = () -> {
            try {
                for (int i=0;i<100;i++){
                    reuqests();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        new Thread(runnable).start();
        Runnable runnable2 = () -> {
            try {
                for (int i=0;i<100;i++){
                    reuqests();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        new Thread(runnable2).start();
        Runnable runnable3 = () -> {
            try {
                for (int i=0;i<100;i++){
                    reuqests();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        new Thread(runnable3).start();

        for (int i =0;i<10000 ; i++) {
            reuqests();
        }
    }

}
