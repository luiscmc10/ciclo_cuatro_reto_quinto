/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Reto_cuatro_ciclo_cuatro.repositoriesCrud;

import com.example.Reto_cuatro_ciclo_cuatro.entities.Clothe;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author Luis Mendez
 */
public interface ClotheCrudRepository extends MongoRepository<Clothe, Integer> {

    Optional<Clothe> findByReference(String reference);

    public List<Clothe> findByPriceLessThanEqual(double precio);

//Reto 5
    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Clothe> findByDescriptionLike(String description);

}
