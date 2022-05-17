package com.example.demo.dao;

import com.example.demo.entities.Fidelys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface FidelysRepository extends JpaRepository<Fidelys, Integer> {


     Fidelys findByEmailAndPassword(String email, String password);


     boolean existsByEmailAndPassword(String email, String password);
     List<Fidelys> findById(int id);

     Optional<Fidelys> findByEmail(String email);

     @Override
     List<Fidelys> findAll();
     Fidelys deleteFidelysById(int id);
}

