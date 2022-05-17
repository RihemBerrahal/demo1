package com.example.demo.controller;


import com.example.demo.entities.Reclamation;
import com.example.demo.service.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReclamationController {
    @Autowired
    ReclamationService reclamationService;


    @PostMapping("/addrec")
    public String addRec(@RequestBody Reclamation rec) {
        System.out.println(reclamationService.addRec(rec));


        return reclamationService.addRec(rec);
    }

    @PostMapping("/getrec")
    public List<Reclamation> getRec(@RequestBody Reclamation rec) {

System.out.println(reclamationService.getrec(rec.getIduser()));
System.out.println(rec.getIduser());
        List list =reclamationService.getrec(rec.getIduser());

        return list;
    }

    @PostMapping("/getrep")
    public List<Reclamation> getrep(@RequestBody Reclamation rec) {

        System.out.println(reclamationService.getrep(rec.getId()));
        System.out.println(rec.getId());
        List list =reclamationService.getrep(rec.getId());

        return list;
    }

    @PostMapping("/supprec")
    public String suprec(@RequestBody Reclamation rec) {



        return reclamationService.deleterec(rec.getId());
    }
    @RequestMapping("/getallrec")
    public List<Reclamation> getallrec() {

        System.out.println(reclamationService.getAllrec());

        List list =reclamationService.getAllrec();

        return list;
    }
    @PostMapping("/addre")
    public String addrep(@RequestBody Reclamation rec){
        return reclamationService.addrep(rec);
    }
    @PostMapping("/findrec")
    public Reclamation findRec(@RequestBody int id){
        return reclamationService.getrecbyid(id);
    }
    @PostMapping("/addrepadmin")
    public String addrepadmin(@RequestBody Reclamation rec){
        return reclamationService.addrepadmin(rec);
    }


}
