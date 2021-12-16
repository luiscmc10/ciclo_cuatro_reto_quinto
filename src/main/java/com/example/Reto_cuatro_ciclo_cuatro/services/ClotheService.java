/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Reto_cuatro_ciclo_cuatro.services;

import com.example.Reto_cuatro_ciclo_cuatro.entities.Clothe;
import com.example.Reto_cuatro_ciclo_cuatro.repositories.ClotheRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Luis Mendez
 */
@Service
public class ClotheService {
    
    @Autowired
    public ClotheRepository repository;
    
    public List<Clothe> getAllClothe(){
        return (List<Clothe>) repository.getAllClothe();
    }
    
    public Optional<Clothe> getClotheId(Integer id){
        return repository.getClotheId(id);
    }
    
    public Optional<Clothe> getClotheReference(String reference){
        return repository.getClotheReference(reference);
    }
    
    
   public Clothe createClothe(Clothe clotheNew){
       return repository.createClothe(clotheNew);
   }
   
   public Clothe update(Clothe clotheEdit){
        if(clotheEdit.getReference()!=null){
            Optional<Clothe> resultado = repository.getClotheReference(clotheEdit.getReference());
            if(resultado.isPresent()){
                if(clotheEdit.isAvailability()){
                    resultado.get().setAvailability(clotheEdit.isAvailability());
                }
                if(clotheEdit.getCategory()!=null){
                    resultado.get().setCategory(clotheEdit.getCategory());
                }
                if(clotheEdit.getDescription()!=null){
                    resultado.get().setDescription(clotheEdit.getDescription());
                }
                if(clotheEdit.getPhotography()!=null){
                    resultado.get().setPhotography(clotheEdit.getPhotography());
                }
                if(clotheEdit.getPrice()!= null){
                    resultado.get().setPrice(clotheEdit.getPrice());
                }
                if(clotheEdit.getQuantity()!=null){
                    resultado.get().setQuantity(clotheEdit.getQuantity());
                }
                if(clotheEdit.getSize()!=null){
                    resultado.get().setSize(clotheEdit.getSize());
                }
                repository.createClothe(resultado.get());
                return resultado.get();
            }else{
                return clotheEdit;
            }
        }else{
            return clotheEdit;
        }
    }
   
   public boolean delete(String id){
        Boolean aBoolean = getClotheReference(id).map(eliminado -> {
           repository.delete(eliminado);
           return true;
        }).orElse(false);
        return aBoolean;
    } 
    
     //Reto 5
    public List<Clothe> productByPrice(double price) {
        return repository.productByPrice(price);
    }

    //Reto 5
    public List<Clothe> findByDescriptionLike(String description) {
        return repository.findByDescriptionLike(description);
    }
}

