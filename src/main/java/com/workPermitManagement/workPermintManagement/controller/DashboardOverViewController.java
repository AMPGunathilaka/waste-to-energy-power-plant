package com.workPermitManagement.workPermintManagement.controller;


import com.workPermitManagement.workPermintManagement.service.interfaces.DashboardOverViewIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/dashboard")
@CrossOrigin("*")
public class DashboardOverViewController {

    @Autowired
    private DashboardOverViewIF dashboardOverViewIF;

    @GetMapping(path = "/getCountOfReceivedWorkPermits")
    public long getCountOfReceivedWorkPermits(){
        long count = dashboardOverViewIF.getCountOfReceivedWorkPermits();
        return count;
    }

    @GetMapping(path = "/getCountOfApprovedWorkPermits")
    public long getCountOfApprovedWorkPermits(){
        long count = dashboardOverViewIF.getCountOfApprovedWorkPermits();
        return count;
    }

    @GetMapping(path = "/getCountOfIsolationCompleteWorkPermits")
    public long getCountOfIsolationCompleteWorkPermits(){
        long count = dashboardOverViewIF.getCountOfIsolationCompleteWorkPermits();
        return count;
    }

    @GetMapping(path = "/getCountOfCompletedByEcpWorkPermits")
    public long getCountOfCompletedByEcpWorkPermits(){
        long count = dashboardOverViewIF.getCountOfCompletedByEcpWorkPermits();
        return count;
    }

    @GetMapping(path = "/getCountOfCompletedBySapWorkPermits")
    public long getCountOfCompletedBySapWorkPermits(){
        long count = dashboardOverViewIF.getCountOfCompletedBySapWorkPermits();
        return count;
    }

    @GetMapping(path = "/getCountOfDeIsolatedByApWorkPermits")
    public long getCountOfDeIsolatedByApWorkPermits(){
        long count = dashboardOverViewIF.getCountOfDeIsolatedByApWorkPermits();
        return count;
    }

    @GetMapping(path = "/getCountOfTotallyCompletedWorkPermits")
    public long getCountOfTotallyCompletedWorkPermits(){
        long count = dashboardOverViewIF.getCountOfTotallyCompletedWorkPermits();
        return count;
    }

    @GetMapping(path = "/getCountOfRejectedWorkPermits")
    public long getCountOfRejectedWorkPermits(){
        long count = dashboardOverViewIF.getCountOfRejectedWorkPermits();
        return count;
    }

    @GetMapping(path = "/getCountOfRegisteredStaff")
    public long getCountOfRegisteredStaff(){
        long count = dashboardOverViewIF.getCountOfRegisteredStaff();
        return count;
    }
}
