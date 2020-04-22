package nl.inholland.myfirstapi.Controller;

import nl.inholland.myfirstapi.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("stocks")
@CrossOrigin(origins = "http://localhost:8080")
public class StockController {

    @Autowired
    private StockService service;

    @RequestMapping(value = "/minValue/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getSkateById(@PathVariable("id") Integer id) {
        return ResponseEntity.status(200).body(service.getStockMinimum(id));
    }
}
