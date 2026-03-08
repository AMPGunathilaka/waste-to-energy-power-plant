package com.workPermitManagement.workPermintManagement.service.interfaces;

public interface DashboardOverViewIF {

    long getCountOfReceivedWorkPermits();

    long getCountOfApprovedWorkPermits();

    long getCountOfIsolationCompleteWorkPermits();

    long getCountOfCompletedByEcpWorkPermits();

    long getCountOfCompletedBySapWorkPermits();

    long getCountOfDeIsolatedByApWorkPermits();

    long getCountOfTotallyCompletedWorkPermits();

    long getCountOfRejectedWorkPermits();

    long getCountOfRegisteredStaff();
}
