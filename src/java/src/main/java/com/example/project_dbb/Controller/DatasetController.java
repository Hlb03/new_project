package com.example.project_dbb.Controller;

import com.example.project_dbb.Entity.Dataset;
import com.example.project_dbb.Opportunities.DatasetOpportunities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DatasetController {

    private final DatasetOpportunities datasetOpportunities;

    @Autowired
    public DatasetController(DatasetOpportunities datasetOpportunities){
        this.datasetOpportunities = datasetOpportunities;
    }

    @GetMapping(value = "/datasets")
    public ResponseEntity<List<Dataset>> getAllDatasets(){
        List<Dataset> list = datasetOpportunities.getAllDatasets();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @Deprecated
    @GetMapping(value = "/datasetId")
    public ResponseEntity<Dataset> getById(@PathVariable long id){
        Dataset dataset = datasetOpportunities.getById(id);

        return new ResponseEntity<>(dataset, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delDataset")
    public ResponseEntity<Dataset> delDataset(@RequestBody Dataset dataset){
        datasetOpportunities.delDataset(dataset);

        return new ResponseEntity<>(dataset, HttpStatus.OK);
    }

    @PostMapping(value = "/addDataset")
    public ResponseEntity<Dataset> addDataset(@RequestBody Dataset dataset){
        datasetOpportunities.saveDataset(dataset);

        return new ResponseEntity<>(dataset, HttpStatus.OK);
    }
}
