package com.example.demo.dao;

import com.example.demo.entities.Vols;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VolsRepository  extends JpaRepository<Vols, String> {
    List<Vols> findByDateDuvol(String date);
    Vols deleteVolsByNumeroDuVol(String id);
    Vols findByNumeroDuVol(String num);

}
