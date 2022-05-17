package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

     JavaMailSender javaMailSender;
    @Bean
    public JavaMailSenderImpl mailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

        javaMailSender.setProtocol("SMTP");
        javaMailSender.setHost("127.0.0.1");
        javaMailSender.setPort(25);

        return javaMailSender;
    }

    public void sendSimpleEmail(String toEmail,String body,
                                String Subject){
        try{
        SimpleMailMessage message= new SimpleMailMessage();

        message.setFrom("verifapp.tun@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(Subject);

        javaMailSender.send(message);
        System.out.println("mail send..");
    }catch(Exception e){throw e;}}
}
