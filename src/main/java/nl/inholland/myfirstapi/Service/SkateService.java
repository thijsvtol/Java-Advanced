package nl.inholland.myfirstapi.Service;

import nl.inholland.myfirstapi.Model.Skate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SkateService {

    List<Skate> skates;

    public SkateService() {
        this.skates =  Arrays.asList(
                new Skate(1, "EVO Krypton", 499.95f),
                new Skate(2, "EHS Velocity", 680.00f),
                new Skate(3, "Bont cyclon", 300.95f)
        );
    }

    public List<Skate> getAllSkates() {
        return skates;
    }
}
