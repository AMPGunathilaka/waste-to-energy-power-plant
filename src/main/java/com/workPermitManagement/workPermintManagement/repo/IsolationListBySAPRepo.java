package com.workPermitManagement.workPermintManagement.repo;

import com.workPermitManagement.workPermintManagement.entity.ForgotPassword;
import com.workPermitManagement.workPermintManagement.entity.IsolationListBySAP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface IsolationListBySAPRepo extends JpaRepository<IsolationListBySAP, Integer> {

    List<IsolationListBySAP> findByWorkPermitIsolationListBySap_WorkPermitId(int workPermitId);
}
