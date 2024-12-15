package com.smartforce.department.api.Service.Impl;

import com.smartforce.department.api.Model.Designation;
import com.smartforce.department.api.Repository.DesignationRepository;
import com.smartforce.department.api.Service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesignationServiceImpl implements DesignationService {

    @Autowired
    private DesignationRepository designationRepository;

    public Designation addDesignation(Designation designation){
        return designationRepository.save(designation);
    }

    public List<Designation> getAllDesignation(){
        return designationRepository.findAll();
    }

    public Designation updateDesignation(Designation designation, String id){
        Designation existingDesignation = designationRepository.findById(id).orElseThrow(() -> new RuntimeException());
        existingDesignation.setName(designation.getName());
        designationRepository.save(existingDesignation);
        return existingDesignation;
    }

    public void deleteDesignation(String id){
        designationRepository.findById(id).orElseThrow(() -> new RuntimeException());
        designationRepository.deleteById(id);
    }
}
