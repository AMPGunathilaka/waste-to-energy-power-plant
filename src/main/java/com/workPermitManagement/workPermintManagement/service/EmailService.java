package com.workPermitManagement.workPermintManagement.service;


import com.workPermitManagement.workPermintManagement.dto.EmailDTO.EmailSaveDTO;
import com.workPermitManagement.workPermintManagement.entity.EmailNotification;
import com.workPermitManagement.workPermintManagement.repo.EmailRepo;
import com.workPermitManagement.workPermintManagement.service.interfaces.EmailIF;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EmailService implements EmailIF {

    @Autowired
    private EmailRepo emailRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void sendEmail(EmailSaveDTO emailDTO) {
        EmailNotification emailNotification =  modelMapper.map(emailDTO, EmailNotification.class);
        emailRepo.save(emailNotification);
    }


}
