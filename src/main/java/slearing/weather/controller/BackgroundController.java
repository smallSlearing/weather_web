package slearing.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import slearing.weather.pojo.Background;
import slearing.weather.service.background.BackgroundService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author slearing
 */
@RequestMapping("background")
@Controller
public class BackgroundController {
    @Autowired
    private BackgroundService service;

    @ResponseBody
    @RequestMapping("/findAll")
    public Map<String , Object> findAll(){
        Map<String, Object> map = new HashMap<>();

        List<Background> list = service.findAll();

        if(list != null && list.size() != 0){
            map.put("status","200");//查找到背景图片的路径
            map.put("data",list);
        }else{
            map.put("status","500");    //查找背景图片失败
        }

        return map;
    }

}
