package com.example.demo.dao;

import com.example.demo.entities.Mouvement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MouvementRepository extends JpaRepository<Mouvement, Integer> {
    List<Mouvement> findByIduser(int id);
}
