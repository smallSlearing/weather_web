package slearing.weather.util.weather;

import net.sf.json.JSONObject;

/**
 * 根据城市名/id查询天气
 * @author slearing
 *
 */
public class WeatherReportByCity {
    private static final String appKey = "7c8172c96f052f630564579d8398f058";
    /**
     * 根据城市名获取
     * @param cityName
     * @return
     */
    public static String excute(String cityName){
        String url=//此处以返回json格式数据示例,所以format=2,以根据城市名称为例,cityName传入中文
                "http://v.juhe.cn/weather/index?cityname="+cityName+"&dtype=json&format=2&key="+appKey;
        return PureNetUtil.get(url);//通过工具类获取返回数据
    }
    /**
     * 获取返回数据中的一个属性示例,此处以获取今日温度为例
     * "temperature": "8℃~20℃"     今日温度
     * @param city
     * @return
     */
    public static JSONObject GetTodayTemperatureByCity(String city) {
        String result=excute(city);
        if(result!=null){
            JSONObject obj=JSONObject.fromObject(result);
            /*获取返回状态码*/
            result=obj.getString("resultcode");
            /*如果状态码是200说明返回数据成功*/
            if(result!=null&&result.equals("200")){
//                result=obj.getString("result");
//                //此时result中数据有多个key,可以对其key进行遍历,得到对个属性
//                obj=JSONObject.fromObject(result);
//                //今日温度对应的key是today
//                result=obj.getString("today");
//                obj=JSONObject.fromObject(result);
//                //今日温度对应当key是temperature
//                result=obj.getString("temperature");
                return obj;
            }
        }
        return null;
    }

}