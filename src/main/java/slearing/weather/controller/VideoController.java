package slearing.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import slearing.weather.pojo.Video;
import slearing.weather.service.video.VideoService;

import java.util.List;

/**
 * @Author slearing
 * 视频的控制层
 */
@Controller
@RequestMapping("video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    /**
     * 实现查找所有的视频的功能
     * @return 视频列表
     */
    @ResponseBody
    @RequestMapping("findVideos")
    public List<Video> findVideos(){
        List<Video> videos = videoService.findVideos();

        return videos;
    }

    /**
     * 实现点赞功能
     * @param id 被点赞视频的id
     * @return
     */
    @ResponseBody
    @RequestMapping("addStar")
    public boolean addStar(Integer id){
        boolean flag = videoService.addStar(id);

        return flag;
    }

}
