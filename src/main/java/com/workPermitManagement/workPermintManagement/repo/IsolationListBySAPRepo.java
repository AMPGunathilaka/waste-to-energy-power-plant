package com.workPermitManagement.workPermintManagement.repo;

import com.workPermitManagement.workPermintManagement.entity.ForgotPassword;
import com.workPermitManagement.workPermintManagement.entity.IsolationListBySAP;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface IsolationListBySAPRepo extends JpaRepository<IsolationListBySAP, Integer> {

    List<IsolationListBySAP> findByWorkPermitIsolationListBySap_WorkPermitId(int workPermitId);


    @Modifying
    @Transactional
    @Query("DELETE FROM IsolationListBySAP i WHERE i.workPermitIsolationListBySap.workPermitId = :workPermitId")
    void deleteByWorkPermitId(@Param("workPermitId") int workPermitId);
}
