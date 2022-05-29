package com.example.demo.service;

import com.example.demo.dao.billetRepository;
import com.example.demo.entities.Vols;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BilletService {
    @Autowired
    billetRepository billetRepository;
   public boolean findbilletByvol(String id, Vols vols){
        return billetRepository.findByIdAndAndVols(id,vols);
    }
}
