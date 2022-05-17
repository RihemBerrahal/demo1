package com.example.demo.dao;


import com.example.demo.entities.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReclamationRpository extends JpaRepository<Reclamation, Integer> {

    List<Reclamation> findByIduser(int id);
    List<Reclamation> findById(int id);

}
