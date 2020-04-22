package nl.inholland.myfirstapi.Service;

import nl.inholland.myfirstapi.Model.Stock;
import nl.inholland.myfirstapi.dao.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    StockRepository stockRepository;

    public List<Stock> getStockMinimum(int min){
        return (List<Stock>) stockRepository.getAllByQuantityGreaterThanEqualOrderByQuantity(min);
    }

}
