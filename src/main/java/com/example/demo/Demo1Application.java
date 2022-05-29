package com.example.demo;

import com.example.demo.dao.AdminRepository;
import com.example.demo.dao.FidelysRepository;

import com.example.demo.dao.MouvementRepository;
import com.example.demo.entities.Admin;
import com.example.demo.entities.AppUserRole;
import com.example.demo.entities.Fidelys;
import com.example.demo.entities.Mouvement;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Demo1Application extends WebMvcConfigurerAdapter implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }
    @Autowired
    FidelysRepository fidelysRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(16);
    public boolean setlocked (){
        List<Fidelys> list= fidelysRepository.findById(21);
        System.out.println(list.get(0).getPassword());
        String pass = bCryptPasswordEncoder.encode(list.get(0).getPassword());
        System.out.println(pass);
        list.get(0).setPassword(pass);
        //list.get(0).setLocked(false);
        list.get(0).setAppUserRole(AppUserRole.user);
        fidelysRepository.save(list.get(0));
        return true;
    }
   BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
 Admin admin= new Admin("admin","admin","informatique");
 @Autowired
 AdminRepository adminRepository;
    CorsRegistry registry;
    @Autowired
    MouvementRepository mouvementRepository;
    String pattern = "dd/MM/yyyy";
    String dateInString =new SimpleDateFormat(pattern).format(new Date());
    Mouvement mouvement = new Mouvement("Achat Miles",0,10000,1,dateInString,0);

    @Override
    public void run(String... args) throws Exception {

        admin.setAppUserRole(AppUserRole.admin);
        String password = encoder.encode(admin.getPassword());
        admin.setPassword(password);
        //adminRepository.save(admin);
      // setlocked();ù
        mouvementRepository.save(mouvement);




    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(
                        "http://localhost:4200"
                )
                .allowedMethods(
                        "GET",
                        "PUT",
                        "POST",
                        "DELETE",
                        "PATCH",
                        "OPTIONS"
                );
    }
}
