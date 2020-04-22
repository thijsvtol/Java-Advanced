package nl.inholland.myfirstapi.Controller;

import nl.inholland.myfirstapi.Model.Skate;
import nl.inholland.myfirstapi.Service.SkateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("skates")
@CrossOrigin(origins = "http://localhost:8080")
public class SkateController {

    @Autowired private SkateService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllSkates() {
        return ResponseEntity.status(200).body(service.getAllSkates());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getSkateById(@PathVariable("id") Integer id) {
        for(Skate skate : service.getAllSkates()){
            if(skate.getId() == id){
                return ResponseEntity.status(200).body(skate);
            }
        }
        return ResponseEntity.status(404).body("could not find a skate with id: " + id);
    }

    @RequestMapping(value = "/nameStartsWith/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getSkateName(@PathVariable("name") String name) {
        //Get first skate name that begins with the given parameter
        List<String> skateNames = new ArrayList<>();

        //Get all skate names
        for (Skate skate : service.getAllSkates()) {
            skateNames.add(skate.getName());
        }

        //Return first result
        return ResponseEntity.status(404).body(skateNames
                .stream()
                .filter(a -> a.startsWith(name))
                .findFirst()
                .orElse("No result"));
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createSkate(@RequestBody Skate skate){
        service.addSkate(skate);
        return ResponseEntity.status(HttpStatus.CREATED).body(skate.getId());
    }
}
