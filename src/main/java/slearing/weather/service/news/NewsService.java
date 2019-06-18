package slearing.weather.service.news;

import com.github.pagehelper.PageHelper;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import slearing.weather.mapper.NewsMapper;
import slearing.weather.pojo.News;
import slearing.weather.util.general.GeneralNetUtil;

import java.util.List;


/**
 * @Author slearing
 * 新闻的service
 */
@Service
public class NewsService {

    @Autowired
    private NewsMapper newsMapper;

    /**
     * 根据新闻类型进行分页查询
     * @param type  新闻类型
     * @param pageNum  第几页
     * @param pageSize 每页的大小
     * @return  新闻列表
     */
    public List<News> findNewsByType(String type , int pageNum , int pageSize){
        PageHelper.startPage(pageNum,pageSize);

        List<News> list = newsMapper.findNewsByType(type);

        return list;
    }
}
