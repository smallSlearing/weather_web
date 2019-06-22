package slearing.weather.service.video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import slearing.weather.mapper.VideoMapper;
import slearing.weather.pojo.Video;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author slearing
 */
@Service
public class VideoService {

    @Autowired
    private VideoMapper videoMapper;

    /**
     * 查找所有的视频信息
     * @return 视频信息列表
     */
    public List<Video> findVideos(){
        List<Video> videos = videoMapper.findVideos();

        if(videos == null){
            //当数据库中没有视频信息的时候，创建一个空列表
            videos = new ArrayList<>();
        }


        return videos;
    }

    /**
     * 实现点赞功能，是点赞数量加1
     * @param id 被点赞的视频的id
     * @return
     */
    public boolean addStar(int id){
        int rowNum = videoMapper.addStar(id);

        if(rowNum > 0){
            return true;
        }

        return  false;
    }
}
