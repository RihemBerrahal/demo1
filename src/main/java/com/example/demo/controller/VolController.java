package com.example.demo.controller;



import com.example.demo.entities.Vols;
import com.example.demo.service.VolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class VolController {
    @Autowired
    VolService volService;

    String pattern = "dd/MM/yyyy";
    String dateInString =new SimpleDateFormat(pattern).format(new Date());

    @RequestMapping("/vol")
    public List<Vols> VolDuJour(){

        try{
            List<Vols> volsList= volService.VolDuJour(dateInString);
            System.out.println(volsList.toString()+"   "+dateInString);
            return volsList;
        }catch(Exception e){throw e;}
    }
    @RequestMapping("/allvol")
    public List<Vols> allvol(){
        return volService.allvol();
    }
    @PostMapping("/addvol")
    public Vols addvol(@RequestBody Vols vol){
        return volService.addvol(vol);
    }
    @PostMapping("/updatevol")
    public Vols updatevol( @RequestBody Vols vol){
        return volService.updatevol(vol);
    }
   @PostMapping("/deletevol")
    public String deletevol(@RequestBody String id){
        return volService.deletevol(id);
    }
  @PostMapping("/findvol")
  public Vols dfindvol(@RequestBody String id){
      return volService.findvol(id);
  }
}
