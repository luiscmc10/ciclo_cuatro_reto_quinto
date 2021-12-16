/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Reto_cuatro_ciclo_cuatro.repositoriesCrud;

import com.example.Reto_cuatro_ciclo_cuatro.entities.User;
import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Luis Mendez
 */
public interface UserCrudRepository extends MongoRepository<User,Integer>{

    public List<User> findByMonthBirthtDay(String monthBirthtDay);
    List<User> findBybirthtDay(Date date);
    
}
