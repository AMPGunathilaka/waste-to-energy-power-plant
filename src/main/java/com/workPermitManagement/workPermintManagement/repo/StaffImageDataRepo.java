package com.workPermitManagement.workPermintManagement.repo;


import com.workPermitManagement.workPermintManagement.entity.StaffImageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface StaffImageDataRepo extends JpaRepository<StaffImageData,Integer> {


    Optional<StaffImageData> findImageByStaff_StaffEmail(String staffEmail);
}
