package slearing.weather.service.news;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import slearing.weather.util.general.GeneralNetUtil;


/**
 * @Author slearing
 * 新闻的service
 */
@Service
public class NewsService {
    //请求的key
    private final String key = "db39e20d462bd0ed3c494628d7a883ff";
    //请求的地址
    private String baseUrl = "http://v.juhe.cn/toutiao/index";

    public JSONObject getNewsByType(String type){
        GeneralNetUtil newsNetUtil = new GeneralNetUtil();
        //拼凑url
        String url = baseUrl+"?type="+type+"&key="+key;

        //调用第三方接口工具类查询新闻信息
        String result = newsNetUtil.sendGet(url);

        //把字符串转成json对象
        JSONObject jsonObject = JSONObject.fromObject(result);

        return  jsonObject;
    }


}
