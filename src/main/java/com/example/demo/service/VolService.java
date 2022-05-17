package com.example.demo.service;




import com.example.demo.dao.VolsRepository;
import com.example.demo.entities.Vols;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class VolService {
    @Autowired
    VolsRepository volRepository;

    String pattern = "dd/MM/yyyy";
    String dateInString =new SimpleDateFormat(pattern).format(new Date());

    public List<Vols> VolDuJour(String d){

        try{
            List<Vols> vols= volRepository.findByDateDuvol(dateInString);
            return vols;
        }catch(Exception e){throw e;}
    }
    public List<Vols> allvol(){
        return volRepository.findAll();
    }
    public Vols addvol(Vols vol){
        return volRepository.save(vol);
    }
    public Vols updatevol(Vols vol){
        return volRepository.save(vol);
    }
   public String deletevol(String id){
      Vols  vol= findvol(id);
         volRepository.delete(vol);
         return "vol deleted";

    }
   public Vols findvol(String id){
       return volRepository.findByNumeroDuVol(id);
   }
}
