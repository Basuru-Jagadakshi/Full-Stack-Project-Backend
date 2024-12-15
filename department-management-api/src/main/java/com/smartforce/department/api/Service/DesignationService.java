package com.smartforce.department.api.Service;

import com.smartforce.department.api.Model.Designation;

import java.util.List;

public interface DesignationService {

    Designation addDesignation(Designation designation);

    List<Designation> getAllDesignation();

    Designation updateDesignation(Designation designation, String id);

    void deleteDesignation(String id);
}
