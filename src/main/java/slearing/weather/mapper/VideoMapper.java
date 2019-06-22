package slearing.weather.mapper;

import org.apache.ibatis.annotations.Mapper;
import slearing.weather.pojo.Video;

import java.util.List;

@Mapper
public interface VideoMapper {

    /**
     * 查找所有视频信息
     * @return
     */
    List<Video> findVideos();

    /**
     * 增加视频的点赞量
     * @return
     */
    int addStar(int id);

}
