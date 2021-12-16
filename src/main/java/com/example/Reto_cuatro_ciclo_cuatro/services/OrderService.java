/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Reto_cuatro_ciclo_cuatro.services;

import com.example.Reto_cuatro_ciclo_cuatro.entities.Order;
import com.example.Reto_cuatro_ciclo_cuatro.repositories.OrderRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




/**
 *
 * @author Luis Mendez
 */
@Service
public class OrderService {
    
    @Autowired
    private OrderRepository repository;
    
    public List<Order> getAll(){
        return repository.getAll();
    }
    public List<Order> getZone(String zona){
        return repository.getZone(zona);
    }
    public Optional<Order> getId(Integer id){
        return repository.getById(id);
    }
    public List<Order> getSalesMan(Integer id){
        return repository.getIdSalesMan(id);
    }
    public List<Order> getStatus(String status, Integer id){
        
        List <Order> ListaStatus = repository.getIdSalesMan(id);
        List <Order>al = new ArrayList<Order>();
        List <Order> ListaStatusFinal = null;
        for(Order x : ListaStatus){
            
                al.add(x);
            
        }
        return al;
        /*List <Order> ListaStatus = repository.getStatus(status);
        List <Order> ListaStatusFinal = null;
        for(Order x : ListaStatus){
            if(x.getSalesMan().getId()==id){
                ListaStatusFinal.add(x);
            }
        }
        return ListaStatusFinal;*/
    }
    public List<Order> getFecha(Integer id, Date fecha ){
        List <Order> ListaSalesman = repository.getIdSalesMan(id);
         List <Order> ListaFechas = null;
          for(Order x : ListaSalesman){
            if(x.getRegisterDay().equals(fecha)){
                ListaFechas.add(x);
            }
            
        }
        return ListaFechas;
    }
        
    public Order createOrder(Order order){
        return repository.createOrder(order);
    }
    
    public Order update(Order orderEdit){
        if(orderEdit.getId()!=null){
            Optional<Order> resultado = repository.getById(orderEdit.getId());
            if(resultado.isPresent()){
                if(orderEdit.getProducts()!=null){
                    resultado.get().setProducts(orderEdit.getProducts());
                }
                if(orderEdit.getStatus()!=null){
                    resultado.get().setStatus(orderEdit.getStatus());
                }
                if(orderEdit.getSalesMan()!=null){
                    resultado.get().setSalesMan(orderEdit.getSalesMan());
                }
                if(orderEdit.getRegisterDay()!=null){
                    resultado.get().setRegisterDay(orderEdit.getRegisterDay());
                }
                if(orderEdit.getQuantities()!=null){
                    resultado.get().setQuantities(orderEdit.getQuantities());
                }
                repository.createOrder(resultado.get());
                return resultado.get();
            }else{
                return orderEdit;
            }
        }else{
            return orderEdit;
        }
    }
    
}
