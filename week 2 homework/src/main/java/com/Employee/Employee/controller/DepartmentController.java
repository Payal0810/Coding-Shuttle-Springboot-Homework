package com.Employee.Employee.controller;

import com.Employee.Employee.dto.DepartmentDTO;
import com.Employee.Employee.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departmets")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService service;

    @GetMapping
    public List<DepartmentDTO> getAll(){
        return service.getAllDepartmets();
    }

    @GetMapping("/{id}")
    public DepartmentDTO getById(@PathVariable Long id){
        return service.getDepartmentById(id);
    }

    @PostMapping
    public DepartmentDTO create(@Valid @RequestBody DepartmentDTO dto){
        return service.createDepartment(dto);
    }

    @PutMapping("/{id}")
    public DepartmentDTO update(@PathVariable Long id, @Valid @RequestBody DepartmentDTO dto){
        return service.updateDepartment(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.deleteDepartment(id);
    }

}
