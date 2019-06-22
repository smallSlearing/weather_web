package slearing.weather.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author slearing
 * 视频的实体类
 */
@Data
@NoArgsConstructor
public class Video{
    private Integer id;
    private String imgUrl;
    private String videoUrl;
    private Integer star;
}
