package com.workPermitManagement.workPermintManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "Isolation_List_By_SAP")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IsolationListBySAP {

    @Id
    @Column(name = "isolation_list_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int isolationListId;

    @Column(name = "steps")
    private int steps;

    @Column(name = "equipment")
    private String equipment;

    @Column(name = "tag")
    private String tag;

    @Column(name = "presentStatus")
    private String presentStatus;

    @Column(name = "loToStatus")
    private String loToStatus;

    @Temporal(TemporalType.DATE)
    @Column(name = "isolatedDate")
    private Date isolatedDate;

    @Column(name = "lockNo")
    private String lockNo;

    @ManyToOne
    @JoinColumn(name="work_permit_id")
    private WorkPermit workPermitIsolationListBySap;
}
