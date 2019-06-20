package slearing.weather.controller.news;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import slearing.weather.pojo.News;
import slearing.weather.service.news.NewsService;

import java.util.List;

/**
 * @Author slearing
 * 新闻的controller
 */
@Controller
@RequestMapping("news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    /**
     * 根据类型查询所有同一类型的新闻
     * @param type 新闻类型
     * @return  新闻列表的json对象
     */
    @RequestMapping("getNewsByType")
    @ResponseBody
    public  List<News> getNewsByType(@RequestParam(defaultValue = "头条")String type,
                                    @RequestParam(defaultValue = "0")int pageNum,@RequestParam(defaultValue = "8")int pageSize){

        List<News> newsList = newsService.findNewsByType(type, pageNum, pageSize);

        return newsList;
    }
}
