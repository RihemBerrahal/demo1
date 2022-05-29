package com.example.demo.service;


import com.example.demo.dao.FidelysRepository;
import com.example.demo.entities.AppUserRole;
import com.example.demo.entities.Fidelys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class FidelysService {
    @Autowired
    private FidelysRepository fidelysRepository  ;
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
    @Autowired
    EmailSenderService emailSenderService;

    public int loginFidelys(Fidelys fidelys){


        Optional<Fidelys> fidelys2
       =fidelysRepository.findByEmail(fidelys.getEmail());
        System.out.println(fidelys.getEmail()+"   "+fidelys.getPassword());

        boolean match = encoder.matches(fidelys.getPassword(),fidelys2.get().getPassword());
        System.out.println(match);
        if(match==true){
            String test=fidelys2.get().getFirstname();
            System.out.println(test);

            return fidelys2.get().getId();

        }

          else {
              System.out.println("le");
              return 00;}


    }





   // @EventListener(ApplicationReadyEvent.class)
    public int sign(Fidelys fidelys){

        String res="reponse";

            boolean test = fidelysRepository.existsByEmailAndPassword(fidelys.getEmail(),fidelys.getPassword());
            if(test){
                res="this fidelys already existsssssssss";

            }else{
                System.out.println(fidelys.getEmail());

           // emailSenderService.sendSimpleEmail(fidelys.getEmail(),"this is body","this is obejct");
               fidelys.setAppUserRole(AppUserRole.user);
               fidelys.setStatus("Provisoire");
                String passwordencoder = encoder.encode(fidelys.getPassword());
                fidelys.setPassword(passwordencoder );
                fidelysRepository.save(fidelys);


                res=  "check your mail";



    }
            System.out.println(fidelys.getAdresse());


            return fidelys.getId();

}
    public List<Fidelys> getfidelys(int id){
        List list = fidelysRepository.findById(id);
        System.out.println(id);
        return list;

    }
 public    Fidelys updatepassword(int id, String password, String oldpassword) throws Exception {
        List<Fidelys> list = fidelysRepository.findById(id);
                System.out.println(list.get(0).getEmail() );
                boolean test= encoder.matches(oldpassword,list.get(0).getPassword());
                if(test==true){
                    String password1=encoder.encode(password);
                    list.get(0).setPassword(password1);
                    fidelysRepository.save(list.get(0));
                    return (list.get(0));
                }else {throw new Exception("password incorrect");}





    }
    public    Fidelys updateprenom(Fidelys fidelys)
    {
        List<Fidelys> list = fidelysRepository.findById(fidelys.getId());
        System.out.println(list.get(0).getEmail() );
        list.get(0).setSecondname(fidelys.getSecondname());
        fidelysRepository.save(list.get(0));
        return (list.get(0));




    }
    public    Fidelys updatenom(Fidelys fidelys)
    {
        List<Fidelys> list = fidelysRepository.findById(fidelys.getId());
        System.out.println(list.get(0).getEmail() );
        list.get(0).setFirstname(fidelys.getFirstname());
        fidelysRepository.save(list.get(0));
        return (list.get(0));




    }

    public    Fidelys updateemail(Fidelys fidelys)
    {
        List<Fidelys> list = fidelysRepository.findById(fidelys.getId());
        System.out.println(list.get(0).getEmail() );
        list.get(0).setEmail(fidelys.getEmail());
        fidelysRepository.save(list.get(0));
        return (list.get(0));





    }
    public    Fidelys updatesexe(Fidelys fidelys)
    {
        List<Fidelys> list = fidelysRepository.findById(fidelys.getId());
        System.out.println(list.get(0).getEmail() );
        list.get(0).setSexe(fidelys.getSexe());
        fidelysRepository.save(list.get(0));
        return (list.get(0));




    }

    public    Fidelys updatetel(Fidelys fidelys)
    {
        List<Fidelys> list = fidelysRepository.findById(fidelys.getId());
        System.out.println(list.get(0).getEmail() );
        list.get(0).setTel(fidelys.getTel());
        fidelysRepository.save(list.get(0));
        return (list.get(0));




    }
    public    Fidelys updatecin(Fidelys fidelys)
    {
        List<Fidelys> list = fidelysRepository.findById(fidelys.getId());
        System.out.println(list.get(0).getEmail() );
        list.get(0).setCin(fidelys.getCin());
        fidelysRepository.save(list.get(0));
        return (list.get(0));




    }
    public    Fidelys updatedate(Fidelys fidelys)
    {
        List<Fidelys> list = fidelysRepository.findById(fidelys.getId());
        System.out.println(list.get(0).getEmail() );
        list.get(0).setBirthdaydate(fidelys.getBirthdaydate());
        fidelysRepository.save(list.get(0));
        return (list.get(0));




    }
    public    Fidelys updatenat(Fidelys fidelys)
    {
        List<Fidelys> list = fidelysRepository.findById(fidelys.getId());
        System.out.println(list.get(0).getEmail() );
        list.get(0).setNationalite(fidelys.getNationalite());
        fidelysRepository.save(list.get(0));
        return (list.get(0));




    }
    public    Fidelys updatefon(Fidelys fidelys)
    {
        List<Fidelys> list = fidelysRepository.findById(fidelys.getId());
        System.out.println(list.get(0).getEmail() );
        list.get(0).setFonction(fidelys.getFonction());
        fidelysRepository.save(list.get(0));
        return (list.get(0));




    }
    public    Fidelys updatesoc(Fidelys fidelys)
    {
        List<Fidelys> list = fidelysRepository.findById(fidelys.getId());
        System.out.println(list.get(0).getEmail() );
        list.get(0).setSociete(fidelys.getSociete());
        fidelysRepository.save(list.get(0));
        return (list.get(0));




    }
    public List<Fidelys> getAll(){
       return fidelysRepository.findAll();
    }
    public Fidelys UpdateFidelys(Fidelys fidelys){
        List<Fidelys> fid= fidelysRepository.findById(fidelys.getId());

        fid.get(0).setStatus(fidelys.getStatus());
        fidelysRepository.save(fid.get(0));
        return fid.get(0);

    }
    public Fidelys deleteFidelys(int id){
        return fidelysRepository.deleteFidelysById(id);

    }
    public Fidelys find(int id){
        Fidelys fidelys;
        List<Fidelys> fid= fidelysRepository.findById(id);
        fidelys=fid.get(0);
        return fidelys;
    }




}
