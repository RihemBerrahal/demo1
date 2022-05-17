package com.example.demo.service;

import com.example.demo.dao.AdminRepository;
import com.example.demo.entities.Admin;
import com.example.demo.entities.Fidelys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
    public Admin loginAdmin(Admin admin) throws Exception {


        Admin Admin1
                =adminRepository.findByUsername(admin.getUsername());
        System.out.println(admin.getUsername()+"   "+admin.getPassword());

        boolean match = encoder.matches(admin.getPassword(),Admin1.getPassword());
        System.out.println(match);
        if(match==true){
            String test=Admin1.getUsername();
            System.out.println(test);

            return Admin1;

        }

        else {
            System.out.println("le");
            throw new Exception("admin unfound");
        }


    }
}
