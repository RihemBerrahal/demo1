package com.example.demo.service;

import com.example.demo.dao.MouvementRepository;
import com.example.demo.entities.Mouvement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MouvementService {
    @Autowired
    MouvementRepository mouvementRepository;

    public List<Mouvement> getMouvementByIdUser(int IdUser) {
        System.out.println(mouvementRepository.findByIduser(IdUser));
        return mouvementRepository.findByIduser(IdUser);
    }
}