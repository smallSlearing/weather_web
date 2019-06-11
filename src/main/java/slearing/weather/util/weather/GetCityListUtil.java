package slearing.weather.util.weather;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 * 获取城市列表
 * 全国天气预报接口调用JAVA示例
 *     dtype     string    N    返回数据格式：json或xml,默认json
 *     key        string     Y    你申请的key
 * @author slearing
 *
 */
public class GetCityListUtil {
    private static final String appKey = "7c8172c96f052f630564579d8398f058";
    /**
     * 调用获取城市列表接口,返回所有数据
     * @return 返回接口数据
     */
    public static String excute(){
        String url="http://v.juhe.cn/weather/citys?key="+appKey;//接口URL
        //PureNetUtil是一个封装了get和post方法获取网络请求数据的工具类
        return PureNetUtil.get(url);//使用get方法
    }
    /**
     * 调用接口返回数据后,解析数据,返回城市列表
     * @return 返回城市列表
     */
    public static JSONObject getCityList() {
        String result=excute();//返回接口结果,得到json格式数据
        if(result!=null){
            JSONObject obj=JSONObject.fromObject(result);
            result=obj.getString("resultcode");//得到返回状态码
            if(result!=null&&result.equals("200")){//200表示成功返回数据
                return obj;
            }

        }
        return null;
    }

}
