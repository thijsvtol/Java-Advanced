package nl.inholland.myfirstapi.Controller;

import nl.inholland.myfirstapi.Model.Skate;
import nl.inholland.myfirstapi.Service.SkateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("skates")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost"} )
public class SkateController {

    @Autowired private SkateService service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity getAllSkates() {
        List<Skate> skates = service.getAllSkates();
        return ResponseEntity.status(200).body(skates);
    }
}
