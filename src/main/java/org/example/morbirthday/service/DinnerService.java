package org.example.morbirthday.service;


import org.example.morbirthday.model.Dinner;
import org.example.morbirthday.repository.DatabaseRepository;
import org.example.morbirthday.repository.DinnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DinnerService {
    private final DinnerRepository dinnerRepository;
    private final DatabaseRepository databaseRepository;

    public DinnerService(DinnerRepository dinnerRepository, DatabaseRepository databaseRepository){
        this.dinnerRepository = dinnerRepository;
        this.databaseRepository = databaseRepository;
    }


    public DinnerRepository getDinnerRepository() {
        return dinnerRepository;
    }

    public void addOrder(Dinner dinner){
        dinnerRepository.addOrder(dinner);
    }

    public void removeOrder(Dinner dinner){
        dinnerRepository.removeOrder(dinner);
    }
    public List<Dinner>getOrders(){
        return dinnerRepository.getOrders();
    }

    public List<Dinner> getAllDinners(){
    return databaseRepository.findAll();
    }


    public void addDinner(Dinner dinner){
        databaseRepository.addDinner(dinner);
    }

}
