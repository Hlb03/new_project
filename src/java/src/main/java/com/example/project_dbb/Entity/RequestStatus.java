package com.example.project_dbb.Entity;

import lombok.Data;

import javax.persistence.*;

public enum RequestStatus {
    COMPLETED(1), PROCESSING(2), REJECTED(3);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne(fetch = FetchType.EAGER)
    @Column(name = "statusId", unique = true)
    private long statusId;

    private RequestStatus(long statusId) {
        this.statusId = statusId;
    }
}
