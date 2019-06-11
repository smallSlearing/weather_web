package slearing.weather.service.weather;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import slearing.weather.util.weather.GetCityListUtil;

/**
 * @Author slearing
 * 获得支持的城市列表的service
 */
@Service
public class CityListService {
    public JSONObject getCityList(){
        //调用第三方接口查询城市列表
        JSONObject jsonObject = GetCityListUtil.getCityList();

        return jsonObject;
    }
}
