package com.example.demo.service;


import com.example.demo.dao.ReclamationRpository;
import com.example.demo.entities.Reclamation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class ReclamationService {
    @Autowired
    ReclamationRpository reclamationRpository;
    public String addRec(Reclamation reclamation){
        reclamationRpository.save(reclamation);
        return "add";


    }

    public List<Reclamation> getrec(int id){
        List list = reclamationRpository.findByIduser(id);
        System.out.println(id);
        return list;

    }

    public List<Reclamation> getrep(int id){
        List list = reclamationRpository.findById(id);
        System.out.println(id);
        return list;

    }

    public String deleterec(int id){
        reclamationRpository.deleteById(id);
        System.out.println(id);
        return "reclamation supprimer";

    }
    public List<Reclamation> getAllrec(){
        List list = reclamationRpository.findAll();

        return list;

    }
    public String addrep(Reclamation rec){
        List<Reclamation> list = reclamationRpository.findById(rec.getId());
        list.get(0).setReponse(rec.getReponse());
        return "reponse added";

    }
    public String addrepadmin(Reclamation rec){

        rec.setReponse(rec.getReponse());
        reclamationRpository.save(rec);
        return "reponse added";

    }
    public Reclamation getrecbyid(int id){
       List<Reclamation> rec =reclamationRpository.findById(id);
       return rec.get(0);
    }


}
