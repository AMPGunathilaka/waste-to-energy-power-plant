package com.workPermitManagement.workPermintManagement.repo;


import com.workPermitManagement.workPermintManagement.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface StaffRepo extends JpaRepository<Staff,String> {
    Optional<Staff> findByStaffEmail(String staffEmail);

    boolean existsStaffByStaffEmail(String staffEmail);
}
