package com.example.demo.controller;

import com.example.demo.dao.AdminRepository;
import com.example.demo.entities.Admin;
import com.example.demo.entities.Fidelys;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;
    @PostMapping("/loginadmin")
    @CrossOrigin(origins = "http://localhost:4200")
    public Admin Login(@RequestBody Admin admin) throws Exception {
        System.out.println(admin.getUsername());

        System.out.println(adminService.loginAdmin(admin));


        return adminService.loginAdmin(admin);

    }
}
