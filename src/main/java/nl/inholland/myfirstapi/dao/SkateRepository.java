package nl.inholland.myfirstapi.dao;

import nl.inholland.myfirstapi.Model.Skate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkateRepository extends CrudRepository<Skate, Integer>{

}
