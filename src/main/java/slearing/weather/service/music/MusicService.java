package slearing.weather.service.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import slearing.weather.mapper.MusicMapper;
import slearing.weather.pojo.Music;

import java.util.List;

/**
 * @Author slearing
 */
@Service
public class MusicService {
    @Autowired
    private MusicMapper mapper;

    public List<Music> findAll(){
        List<Music> musicList = mapper.findAll();

        return musicList;
    }

}
