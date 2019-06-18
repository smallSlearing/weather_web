package slearing.weather.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author slearing
 * 新闻表的实体类
 */
@Data
@NoArgsConstructor
public class News {

    private String uniquekey; //新闻标识
    private String title; //新闻标题
    private String date;  //新闻日期
    private String category;
    private String authorName; //作者名
    private String url; //新闻url
    private String thumbnailPicS;  //新闻第一张图片的url

}
