package slearing.weather.mapper;

import org.apache.ibatis.annotations.Mapper;
import slearing.weather.pojo.Background;

import java.util.List;

/**
 * @Author slearing
 */
@Mapper
public interface BackgroundMapper {
    List<Background> findAll();
}
