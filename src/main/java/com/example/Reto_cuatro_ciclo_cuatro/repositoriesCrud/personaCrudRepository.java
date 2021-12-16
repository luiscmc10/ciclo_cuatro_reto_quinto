/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Reto_cuatro_ciclo_cuatro.repositoriesCrud;

import com.example.Reto_cuatro_ciclo_cuatro.entities.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Luis Mendez
 */
public interface personaCrudRepository extends MongoRepository<Persona, Integer>{
    
}
