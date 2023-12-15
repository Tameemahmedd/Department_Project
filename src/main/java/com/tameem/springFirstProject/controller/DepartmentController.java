package com.tameem.springFirstProject.controller;

import com.tameem.springFirstProject.entity.Department;
import com.tameem.springFirstProject.error.DepartmentNotFound;
import com.tameem.springFirstProject.service.DeparmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
   private  DeparmentService deparmentService;
    private final Logger LOGGER= LoggerFactory.getLogger(DepartmentController.class);
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
       LOGGER.info("Inside SaveDepartment of DepartmentController ");
        return deparmentService.saveDepartment(department);

    }
    @GetMapping("/departments")
    public List<Department> fetchdepartmentList(){
        LOGGER.info("Inside fetchdepartmentList of DepartmentController ");
        return deparmentService.fetchDepartmentList();
    }
@GetMapping("/departments/{id}")
    public Department fetchbyId(@PathVariable("id") Long departmentId) throws DepartmentNotFound {
    LOGGER.info("Inside fetchbyId of DepartmentController ");
    return deparmentService.fetchbyId(departmentId);
}
@DeleteMapping("/departments/{id}")
    public String deleteDepartment(@PathVariable("id") Long departmentId){
      deparmentService.deleteDepartment(departmentId);
      return "Deleted!!";
}
@PutMapping("/departments/{id}")
public Department updateDepartment(@PathVariable("id") Long departmentId,@RequestBody Department department){
return deparmentService.updateDepartment(departmentId,department);
}
@GetMapping("/departments/name/{name}")
public Department fetchDepartmentbyName(@PathVariable("name")String departmentName){
        return deparmentService.fetchDepartmentbyName(departmentName);

}
}
