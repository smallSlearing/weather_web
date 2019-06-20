package slearing.weather.service.weather;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import slearing.weather.util.general.GeneralNetUtil;
import slearing.weather.util.weather.PMUtil;
import slearing.weather.util.weather.WeatherReportByCity;

/**
 * @Author slearing
 * 查询指定的城市的天气信息的service
 */
@Service
public class CityWeatherService {
    /**
     * 查询基本的天气
     * @param cityName
     * @return
     */
    public JSONObject getTodayTemperatureByCity(String cityName ){
        JSONObject jsonObject = null;

        //调用第三方接口查询天气预报
        jsonObject = WeatherReportByCity.GetTodayTemperatureByCity(cityName.split(" ")[1]);

        return jsonObject;
    }

    /**
     * 查询未来几个小时天气
     * @param cityName
     * @return
     */
    public JSONObject getHoursWeather(String cityName){
        String key = "f298ee4a5bf14963a14fe05e06846ac9";
        String baseUrl = "https://api.heweather.net/s6/weather/hourly";
        GeneralNetUtil hoursWeatherUtil = new GeneralNetUtil();
        //拼凑url
        String url = baseUrl+"?location="+cityName.split(" ")[1]+"&key="+key;

        //调用第三方接口
        String result = hoursWeatherUtil.sendGet(url);

        JSONObject jsonObject = JSONObject.fromObject(result);

        return  jsonObject;
    }

    /**
     * 查询PM
     * @param cityName
     * @return
     */
    public JSONObject getPM(String cityName){
        String[] cityArr = cityName.split(" ");
        //根据区获取PM
        JSONObject jsonObject = PMUtil.getPM(cityArr[1]);

        if(jsonObject.getString("resultcode").equals("202")){
            jsonObject = PMUtil.getPM(cityArr[0]);
        }

        return  jsonObject;
    }
}
