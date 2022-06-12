package com.example.project_dbb.Opportunities;

import com.example.project_dbb.Entity.Dataset;
import com.example.project_dbb.Repo.DatasetRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DatasetOpportunities {

    private final DatasetRepo datasetRepo;


    @Autowired
    public DatasetOpportunities(DatasetRepo datasetRepo){
        this.datasetRepo = datasetRepo;
    }

    public List<Dataset> getAllDatasets(){
        return datasetRepo.findAll();
    }

    @Deprecated
    public Dataset getById(long id){
        return datasetRepo.getById(id);
    }

    public void delDataset(Dataset dataset){
        datasetRepo.delete(dataset);
    }

    public void saveDataset(Dataset dataset){
        datasetRepo.save(dataset);
    }

}
