package slearing.weather.mapper;

import org.apache.ibatis.annotations.Mapper;
import slearing.weather.pojo.News;

import java.util.List;

/**
 * @Author slearing
 */
@Mapper
public interface NewsMapper {
    /**
     * 插入新闻
     * @param newsList 新闻列表
     * @return 影响的行数
     */
    int insertNews(List<News> newsList);

    /**
     * 根据新闻类型删除前面的15条记录
     * @param type
     * @return
     */
    int deleteNewsByType(String type);

    /**
     * 根据类型删除某个类型的新闻
     * @param type
     * @return
     */
    List<News> findNewsByType(String type);
}
