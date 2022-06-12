package com.example.project_dbb.Entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
public class ModeratorStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "moderatorId", unique = true)
    private long moderatorId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "date")
    private Date date;

    @Column(name = "userId")
    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "userId", updatable = false)
    private User userId;

    @Column(name = "statusId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statusId", updatable = false)
    private RequestStatus statusId;

    @Column(name = "datasetId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "datasetId", updatable = false)
    private Dataset datasetId;
}
