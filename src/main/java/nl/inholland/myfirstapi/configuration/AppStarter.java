package nl.inholland.myfirstapi.configuration;

import nl.inholland.myfirstapi.Model.Skate;
import nl.inholland.myfirstapi.Model.Stock;
import nl.inholland.myfirstapi.dao.SkateRepository;
import nl.inholland.myfirstapi.dao.StockRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class AppStarter implements ApplicationRunner {

    SkateRepository skateRepository;
    StockRepository stockRepository;

    AppStarter(SkateRepository skateRepository, StockRepository stockRepository){
        this.skateRepository = skateRepository;
        this.stockRepository = stockRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Skate> skates = Arrays.asList(
                new Skate(1, "EVO", 400),
                new Skate(2, "Viking", 500),
                new Skate(3, "Bont", 699.95f)
        );

        skates.forEach(
                skateRepository::save
        );

        skateRepository.findAll()
                .forEach(
                        skate -> stockRepository.save(new Stock(skate, new Random().nextInt(100)))
                );

        Iterable<Stock> stocks = stockRepository.getAllByQuantityGreaterThanEqualOrderByQuantity(30);

        stockRepository.findAll().forEach(System.out::println);
        skateRepository.findAll().forEach(System.out::println);
    }
}
