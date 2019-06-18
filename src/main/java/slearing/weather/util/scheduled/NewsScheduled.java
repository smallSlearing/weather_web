package slearing.weather.util.scheduled;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import slearing.weather.mapper.NewsMapper;
import slearing.weather.pojo.News;
import slearing.weather.util.general.GeneralNetUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author slearing‘
 * 用来执行关于新闻的定时任务
 */
@Component
public class NewsScheduled {
    int i = 0;
    @Autowired
    private NewsMapper newsMapper;

    //请求的key
    private final String key = "db39e20d462bd0ed3c494628d7a883ff";
    //请求的地址
    private String baseUrl = "http://v.juhe.cn/toutiao/index";


    /**
     * 用来定时从第三方查询新闻，插入数据库
     */
    @Scheduled(fixedDelay = 1000*60*60) //设置每一个小时执行一次
    public void insertNew(){
        //获得新闻列表
        List<JSONArray> dataList = getNewsByType();
        //解析新闻列表的json对象
        List<List<News>> list = parseJson(dataList);

        for(List<News> l : list){
            newsMapper.insertNews(l);
        }

    }

    /**
     * 用来定时从数据库中删除10条新闻
     */
    @Scheduled(fixedDelay = 1000*60*59) //设置每59分钟执行一次
    public void deleteNew(){
        String[] typeArr = {"头条","社会","国内","国际","娱乐","体育","军事","科技","财经","时尚"};

        for (String type: typeArr) {
            newsMapper.deleteNewsByType(type);
        }
    }


    /**
     * 调用第三方接口根据typeArr中的元素进行查询新闻
     * @return  各种类型的新闻的列表
     */
    public  List<JSONArray> getNewsByType(){
        String[] typeArr = {"top","shehui","guonei","guoji","yule","tiyu","junshi","keji","caijing","shishang"};
        List<JSONArray> list = new ArrayList<>();

        for (String type:typeArr){
            System.out.println(i++);
            GeneralNetUtil newsNetUtil = new GeneralNetUtil();
            //拼凑url
            String url = baseUrl+"?type="+type+"&key="+key;

            //调用第三方接口工具类查询新闻信息
            String result = newsNetUtil.sendGet(url);

            //把字符串转成json对象
            JSONObject jsonObject = JSONObject.fromObject(result);

            //当查询的结果没有问题的话，就把其中的数据部分取出来放入list
            if(jsonObject.getString("reason").equals("成功的返回")){
                list.add(jsonObject.getJSONObject("result").getJSONArray("data"));
            }

        }

        return  list;
    }


    /**
     * 解析新闻的json对象
     * @param dataList 新闻列表的json对象
     * @return
     */
    public List<List<News>> parseJson(List<JSONArray> dataList){
        List<List<News>> list = new ArrayList<>();

        for (int i = 0 ; i < dataList.size() ; i++) {
            JSONArray arr = dataList.get(i);

            List<News> childList = new ArrayList<>();
            for (int j = 0 ; j < arr.size(); j++){
                News news = new News();
                JSONObject element = arr.getJSONObject(j);

                news.setUniquekey(element.getString("uniquekey"));
                news.setDate(element.getString("date"));
                news.setTitle(element.getString("title"));
                news.setCategory(element.getString("category"));
                news.setAuthorName(element.getString("author_name"));
                news.setUrl(element.getString("url"));
                news.setThumbnailPicS(element.getString("thumbnail_pic_s"));

                childList.add(news);
            }

            list.add(childList);
        }


        return list;
    }

}
