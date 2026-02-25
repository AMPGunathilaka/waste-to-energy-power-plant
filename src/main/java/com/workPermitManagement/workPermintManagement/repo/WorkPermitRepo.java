package com.workPermitManagement.workPermintManagement.repo;


import com.workPermitManagement.workPermintManagement.entity.WorkPermit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface WorkPermitRepo extends JpaRepository<WorkPermit,Integer> {

    List<WorkPermit> findAllByStatusEquals(String approved_by_sap);
}
