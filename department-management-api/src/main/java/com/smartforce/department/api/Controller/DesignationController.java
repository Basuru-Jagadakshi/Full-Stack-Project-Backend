package com.smartforce.department.api.Controller;

import com.smartforce.department.api.Model.Designation;
import com.smartforce.department.api.Service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/designation")
@CrossOrigin("*")
public class DesignationController {

    @Autowired
    private DesignationService designationService;

    @PostMapping
    public ResponseEntity<Designation> addDesignation(@RequestBody Designation designation){
        return new ResponseEntity<Designation>(designationService.addDesignation(designation), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Designation> getAllDesignation(){
        return designationService.getAllDesignation();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Designation> updateDesignation(@RequestBody Designation designation, @PathVariable("id") String id){
        return new ResponseEntity<Designation>(designationService.updateDesignation(designation, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDesignation(@PathVariable("id") String id){
        designationService.deleteDesignation(id);
        return new ResponseEntity<String>("Designation is deleted successfully", HttpStatus.OK);
    }
}
