package org.example.morbirthday.repository;


import org.example.morbirthday.model.Dinner;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DinnerRepository {
    List<Dinner>orders = new ArrayList<>();


    public DinnerRepository(){

    }

    public List<Dinner> getOrders(){
        return orders;
    }

    public void addOrder(Dinner dinner){
        orders.add(dinner);
    }

    public Dinner removeOrder(Dinner dinner){
        Dinner temp = null;
        for(Dinner i: orders){
            if(i.getName().equalsIgnoreCase(dinner.getEmail())){
                temp = i;
                orders.remove(i);
                return temp;
            }
        }
        return temp;
    }





}
