package slearing.weather.service.weather;

import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * CityListService测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CityListServiceTest {
    @Autowired
    private CityListService cityListService;

    @Test
    public void getCityList() {
        final JSONObject jsonObject = cityListService.getCityList();
        System.out.println(jsonObject.toString());
    }
}