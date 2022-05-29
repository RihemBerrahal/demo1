package com.example.demo.controller;

import com.example.demo.entities.Vols;
import com.example.demo.service.BilletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BilletController {
    @Autowired
    BilletService billetService;

    boolean findbilletByvol(String id, Vols vols){
        return billetService.findbilletByvol(id,vols);
    }
}
