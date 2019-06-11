package slearing.weather.service.weather;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import slearing.weather.util.weather.WeatherReportByCity;

/**
 * @Author slearing
 * 查询指定的城市的天气信息的service
 */
@Service
public class CityWeatherService {
    public JSONObject getTodayTemperatureByCity(String cityName ){
        JSONObject jsonObject = null;

        //调用第三方接口查询天气预报
        jsonObject = WeatherReportByCity.GetTodayTemperatureByCity(cityName);

        return jsonObject;
    }
}
