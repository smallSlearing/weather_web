package slearing.weather.util.general;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @Author slearing
 * 负责和一些第三方接口（查询未来三个小时、查询新闻）通信
 */
public class GeneralNetUtil {

    /**
     * 发送HttpGet请求
     * @param url  请求的地址
     * @return  获得json数据
     */
    public String sendGet(String url) {
        //1.获得一个httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //2.生成一个get请求
        HttpGet httpGet = new HttpGet(url);

        CloseableHttpResponse response = null;
        String result = null; //返回的数据


        try {
            //3.执行get请求并返回结果
            response = httpclient.execute(httpGet);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try {
            //4.处理结果，这里将结果返回为字符串
            HttpEntity entity = response.getEntity();
            if (response.getEntity() != null) {
                result = EntityUtils.toString(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
