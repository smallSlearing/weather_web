package slearing.weather.controller.news;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import slearing.weather.service.news.NewsService;

/**
 * @Author slearing
 * 新闻的controller
 */
@Controller
@RequestMapping("news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @RequestMapping("getNewsByType")
    @ResponseBody
    public JSONObject getNewsByType(@RequestParam(value = "type",defaultValue = "头条")String type){

        JSONObject newsByType = newsService.getNewsByType(type);

        return newsByType;
    }
}
