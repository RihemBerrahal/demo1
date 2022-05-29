package com.example.demo.dao;


import com.example.demo.entities.Vols;
import com.example.demo.entities.billet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface billetRepository extends JpaRepository<billet, String> {
    boolean findByIdAndAndVols(String id, Vols vols);
}
