package slearing.weather.controller.weather;

import net.sf.json.JSONObject;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import slearing.weather.service.weather.CityListService;
import slearing.weather.service.weather.CityWeatherService;
import slearing.weather.service.weather.PMService;

import java.util.HashMap;


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
    private PMService pmService;

    /**
     * 获取指定城市的所有天气信息
     * @param cityName 城市名
     * @return
     */
    @ResponseBody
    @RequestMapping("cityWeather")
    public HashMap<String , JSONObject> cityWeather(@RequestParam(defaultValue = "广州" ) String cityName ){
         HashMap<String, JSONObject> map = new HashMap<>();

         JSONObject cityWeather = cityWeatherService.getTodayTemperatureByCity(cityName); //指定城市的基础信息
         JSONObject pm = pmService.getPM(cityName); //指定城市的PM值

         map.put("cityWeather" ,cityWeather);
         map.put("pm" ,pm);

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
