package com.example.project_dbb.Entity;


import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
public class Dataset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "datasetId", unique = true)
    private long datasetId;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "creation_data")
    private Date creationDate;

    @Column(name = "userId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", updatable = false)
    private User userId;

}
