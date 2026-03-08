package com.workPermitManagement.workPermintManagement.service;



import com.workPermitManagement.workPermintManagement.repo.StaffRepo;
import com.workPermitManagement.workPermintManagement.repo.WorkPermitRepo;
import com.workPermitManagement.workPermintManagement.service.interfaces.DashboardOverViewIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardOverViewService implements DashboardOverViewIF {

    @Autowired
    private WorkPermitRepo workPermitRepo;

    @Autowired
    private StaffRepo staffRepo;


    @Override
    public long getCountOfReceivedWorkPermits() {
        long count = (long) workPermitRepo.countByStatus("pending");
        return count;
    }

    @Override
    public long getCountOfApprovedWorkPermits() {
        long count = (long) workPermitRepo.countByStatus("approved by SAP");
        return count;
    }

    @Override
    public long getCountOfIsolationCompleteWorkPermits() {
        long count = (long) workPermitRepo.countByStatus("isolated by AP");
        return count;
    }

    @Override
    public long getCountOfCompletedByEcpWorkPermits() {
        long count = (long) workPermitRepo.countByStatus("completed by ECP");
        return count;
    }

    @Override
    public long getCountOfCompletedBySapWorkPermits() {
        long count = (long) workPermitRepo.countByStatus("completed by SAP");
        return count;
    }

    @Override
    public long getCountOfDeIsolatedByApWorkPermits() {
        long count = (long) workPermitRepo.countByStatus("completed by AP");
        return count;
    }

    @Override
    public long getCountOfTotallyCompletedWorkPermits() {
        long count = (long) workPermitRepo.countByStatus("completed by HSE");
        return count;
    }

    @Override
    public long getCountOfRejectedWorkPermits() {
        long count = (long) workPermitRepo.countByStatus("rejected");
        return count;
    }

    @Override
    public long getCountOfRegisteredStaff() {
        long count = (long) staffRepo.count();
        return count;
    }


}
