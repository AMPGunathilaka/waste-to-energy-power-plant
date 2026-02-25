package com.workPermitManagement.workPermintManagement.repo;



import com.workPermitManagement.workPermintManagement.entity.ForgotPassword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface ForgotPasswordRepo extends JpaRepository<ForgotPassword, Integer> {
    Optional<ForgotPassword> findByResetCode(String code);
}
