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
        String[] cityArr = cityName.split(" ");
        //根据区获取PM
        JSONObject jsonObject = PMUtil.getPM(cityArr[1]);

        if(jsonObject.getString("resultcode").equals("202")){
            jsonObject = PMUtil.getPM(cityArr[0]);
        }

        return  jsonObject;
    }
}
