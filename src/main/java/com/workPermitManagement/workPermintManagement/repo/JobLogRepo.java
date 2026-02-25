package com.workPermitManagement.workPermintManagement.repo;



import com.workPermitManagement.workPermintManagement.entity.JobLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface JobLogRepo extends JpaRepository<JobLog, Integer> {
}
