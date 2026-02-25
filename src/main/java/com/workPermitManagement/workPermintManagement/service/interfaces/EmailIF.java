package com.workPermitManagement.workPermintManagement.service.interfaces;

import com.workPermitManagement.workPermintManagement.dto.EmailDTO.EmailSaveDTO;

import java.util.List;

public interface EmailIF {

    void sendEmail(EmailSaveDTO emailDTO);


}
