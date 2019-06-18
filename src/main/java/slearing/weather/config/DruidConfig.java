package slearing.weather.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author slearing
 */
@Configuration
public class DruidConfig {

    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean();

        bean.setServlet(new StatViewServlet());
        bean.setUrlMappings(Arrays.asList("/druid/*"));
        Map<String, String> map = new HashMap<String, String>();
        map.put("loginUsername", "admin");
        map.put("loginPassword", "123456");

        bean.setInitParameters(map);

        return bean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter() {
        WebStatFilter filter = new WebStatFilter();

        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(filter);
        bean.setUrlPatterns(Arrays.asList("/*"));

        HashMap<String, String> map = new HashMap<>();

        map.put("exclusions", "/webapps/*,/static/*,/druid/*");

        bean.setInitParameters(map);

        return bean;
    }



    /**
     * 配置数据源
     * 给其中一个数据源加上@Primary。因为在Spring Boot Jdbc的自动配置过程中，会对于开发者透明地使用dataSource进行一些相关配置，所以当有两个Datasource实现类时，Spring Boot将无法确定使用哪一个。
     当我们不为@Bean指定名字时，Spring会默认使用方法名作为Bean的名字，所以下面两个数据源的名字分别为prodDataSource和devDataSource。
     * @return
     */
    @Bean(name = "datasource")
    //配置文件里的属性名是不需要写成spring.datasource.xxx的形式的，写成a.b.c.url也没有问题，只要在配置bean时指定前缀为a.b.c
    @ConfigurationProperties(prefix = "spring.datasource")
    @Primary
    public DataSource testDataSource() {
        return new DruidDataSource();
    }
}
