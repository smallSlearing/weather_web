package slearing.weather.service.weather;

import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * PMService 测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PMServiceTest {
    @Autowired
    private PMService pmService;

    @Test
    public void getPM() {
        final JSONObject pm = pmService.getPM("广州");
        System.out.println(pm.toString());
    }
}