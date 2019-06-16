package slearing.weather.service.weather;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import slearing.weather.util.weather.HoursWeatherUtil;


/**
 * @Author slearing
 */
@Service
public class HoursWeatherService {
    private final String key = "f298ee4a5bf14963a14fe05e06846ac9";
    private String baseUrl = "https://api.heweather.net/s6/weather/hourly";

    public JSONObject getHoursWeather(String cityName){
        HoursWeatherUtil hoursWeatherUtil = new HoursWeatherUtil();
        //拼凑url
        String url = baseUrl+"?location="+cityName.split(" ")[1]+"&key="+key;

        //调用第三方接口
        String result = hoursWeatherUtil.sendGet(url);

        JSONObject jsonObject = JSONObject.fromObject(result);

        return  jsonObject;
    }


}
