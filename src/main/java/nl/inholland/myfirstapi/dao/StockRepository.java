package nl.inholland.myfirstapi.dao;

import nl.inholland.myfirstapi.Model.Stock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<Stock, Integer> {

    Iterable<Stock> getAllByQuantityGreaterThanEqualOrderByQuantity(int minimum);

    @Query("select s.quantity * sk.price from Stock s, Skate sk where s.skate.id = sk.id and s.skate.id=?1")
    int getQuantityByGuitarId(long id);
}
