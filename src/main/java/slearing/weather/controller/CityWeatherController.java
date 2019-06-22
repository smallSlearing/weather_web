package slearing.weather.controller;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import slearing.weather.pojo.News;
import slearing.weather.service.news.NewsService;
import slearing.weather.service.weather.CityListService;
import slearing.weather.service.weather.CityWeatherService;

import java.util.HashMap;
import java.util.List;


/**
 * @Author slearing
 * 获得指定城市的天气预报
 */
@Controller
@RequestMapping("weather")
public class CityWeatherController {

    @Autowired
    private CityWeatherService cityWeatherService;
    @Autowired
    private CityListService cityListService;
    @Autowired
    private NewsService newsService;

    /**
     * 获取指定城市的所有天气信息
     * @param cityName 城市名
     * @return
     */
    @ResponseBody
    @RequestMapping("cityWeather")
    public HashMap<String , Object> cityWeather(@RequestParam(defaultValue = "广州 增城" ) String cityName ){
         HashMap<String, Object> map = new HashMap<>();
         JSONObject cityWeather = cityWeatherService.getTodayTemperatureByCity(cityName); //指定城市的基础信息
         JSONObject pm = cityWeatherService.getPM(cityName); //指定城市的PM值
         JSONObject hoursWeather = cityWeatherService.getHoursWeather(cityName); //指定城市的未来几个小时天气预报
        List<News> news = newsService.findNewsByType("头条", 1, 4);
        map.put("cityWeather" ,cityWeather);
         map.put("pm" ,pm);
         map.put("hoursWeather" ,hoursWeather);
         map.put("news" ,news);

         return map;

    }

    /**
     * 获取支持的城市列表
     * @return
     */
    @ResponseBody
    @RequestMapping("getCityList")
    public HashMap<String , JSONObject> getCityList(){
        HashMap<String, JSONObject> map = new HashMap<>();

        JSONObject cityList = cityListService.getCityList();
        map.put("cityList" ,cityList);

        return map;
    }
}
