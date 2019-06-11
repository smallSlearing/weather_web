package slearing.weather.service.weather;


import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * CityWeatherService测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CityWeatherServiceTest {
    @Autowired
    private CityWeatherService service ;

    @Test
    public void getTodayTemperatureByCity() {
        final JSONObject city = service.getTodayTemperatureByCity("广州");
        System.out.println(city.toString());
    }
}