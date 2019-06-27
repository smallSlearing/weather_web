package slearing.weather.mapper;

import org.apache.ibatis.annotations.Mapper;
import slearing.weather.pojo.Music;

import java.util.List;

/**
 * @Author slearing
 */
@Mapper
public interface MusicMapper {
    List<Music> findAll();
}
