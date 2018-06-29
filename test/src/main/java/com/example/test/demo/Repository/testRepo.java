package com.example.test.demo.Repository;

import com.example.test.demo.Model.testModel;
import org.springframework.data.repository.CrudRepository;

public interface testRepo extends CrudRepository<testModel,Integer> {

}
