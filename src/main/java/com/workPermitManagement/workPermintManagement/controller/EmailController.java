package com.workPermitManagement.workPermintManagement.controller;


import com.workPermitManagement.workPermintManagement.dto.EmailDTO.EmailSaveDTO;
import com.workPermitManagement.workPermintManagement.service.interfaces.EmailIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/email")
@CrossOrigin("*")
public class EmailController {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private EmailIF emailIF;

    @PostMapping(path = "/save")
    public String sendMail(@RequestBody EmailSaveDTO emailDTO){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(emailDTO.getSubject());
        message.setTo(emailDTO.getToMail());
        message.setFrom("750bbc001@smtp-brevo.com");
        message.setText(emailDTO.getMessage());
        javaMailSender.send(message);
        return "success";
    }

}