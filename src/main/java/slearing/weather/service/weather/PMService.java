package slearing.weather.service.weather;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import slearing.weather.util.weather.PMUtil;

/**
 * @Author slearing
 * 查询指定城市的PM指数
 */
@Service
public class PMService {
    public JSONObject getPM(String cityName){
        JSONObject jsonObject = PMUtil.getPM(cityName);

        return  jsonObject;
    }
}
