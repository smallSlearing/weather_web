package slearing.weather.service.background;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import slearing.weather.mapper.BackgroundMapper;
import slearing.weather.pojo.Background;

import java.util.List;

/**
 * @Author slearing
 */
@Service
public class BackgroundService {
    @Autowired
    private BackgroundMapper mapper;

    public List<Background> findAll(){
        List<Background> backgroundList = mapper.findAll();

        return backgroundList;
    }

}
