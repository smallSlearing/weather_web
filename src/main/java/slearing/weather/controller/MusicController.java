package slearing.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import slearing.weather.mapper.MusicMapper;
import slearing.weather.pojo.Background;
import slearing.weather.pojo.Music;
import slearing.weather.service.background.BackgroundService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author slearing
 */
@Controller
@RequestMapping("music")
public class MusicController {

        @Autowired
        private MusicMapper service;

        @ResponseBody
        @RequestMapping("/findAll")
        public Map<String , Object> findAll(){
            Map<String, Object> map = new HashMap<>();

            List<Music> musicList = service.findAll();

            if(musicList != null && musicList.size() != 0){
                map.put("status","200");//查找到背景音乐成功
                map.put("data",musicList);
            }else{
                map.put("status","500");    //查找背景音乐失败
            }

            return map;
        }


}
