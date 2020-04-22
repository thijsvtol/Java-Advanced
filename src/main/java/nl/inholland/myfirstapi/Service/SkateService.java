package nl.inholland.myfirstapi.Service;

import nl.inholland.myfirstapi.Model.Skate;
import nl.inholland.myfirstapi.dao.SkateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkateService {

    @Autowired
    private SkateRepository skateRepository;

    public List<Skate> getAllSkates() {
        return (List<Skate>) skateRepository.findAll();
    }

    public void addSkate(Skate skate){
        skateRepository.save(skate);
    }
}
