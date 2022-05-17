package com.example.demo.service;


import com.example.demo.dao.FidelysRepository;
import com.example.demo.entities.Fidelys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    FidelysRepository fidelysRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {


      return  fidelysRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("username not found"));
    }
}
