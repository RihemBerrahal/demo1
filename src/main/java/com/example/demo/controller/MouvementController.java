package com.example.demo.controller;

import com.example.demo.entities.Mouvement;
import com.example.demo.service.MouvementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MouvementController {
    @Autowired
    MouvementService mouvementService;

    @PostMapping("/getmouvement")

    public List<Mouvement> getMouvementByIdUser(@RequestBody Mouvement mouvement) {
        return mouvementService.getMouvementByIdUser(mouvement.getIduser());
    }
}
