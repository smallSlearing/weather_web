package slearing.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
     * 实现点赞获得取消点赞功能
     * @param id 被点赞视频的id
     * @return
     */
    @ResponseBody
    @RequestMapping("star")
    public String star(Integer id , @RequestParam(defaultValue = "true") boolean isAdd){
        int rowCount = videoService.star(id , isAdd);

        String reslut = "0";     //增加或者取消点赞失败

        if(rowCount > 0){
            if(isAdd){
                reslut = "1";    //增加点赞成功
            }else{
                reslut = "2";   //取消点赞成功
            }
        }
        return reslut;
    }

}
