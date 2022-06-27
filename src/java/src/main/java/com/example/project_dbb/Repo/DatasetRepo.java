package com.example.project_dbb.Repo;

import com.example.project_dbb.Entity.Dataset;
import org.springframework.data.jpa.repository.JpaRepository;
 
public interface DatasetRepo extends JpaRepository<Dataset, Long> {
}
