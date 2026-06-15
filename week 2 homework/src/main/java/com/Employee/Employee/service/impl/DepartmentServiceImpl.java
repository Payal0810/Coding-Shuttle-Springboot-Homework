package com.Employee.Employee.service.impl;

import com.Employee.Employee.dto.DepartmentDTO;
import com.Employee.Employee.entity.DepartmentEntity;
import com.Employee.Employee.repository.DepartmentRepository;
import com.Employee.Employee.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;

    @Override
    public List<DepartmentDTO> getAllDepartmets() {
        return repository.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    @Override
    public DepartmentDTO getDepartmentById(Long id) {
        DepartmentEntity department = repository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Department not found"));
        return convertToDTO(department);
    }

    @Override
    public DepartmentDTO createDepartment(DepartmentDTO dto) {
        DepartmentEntity department = convertToEntity(dto);
        return convertToDTO(repository.save(department));
    }

    @Override
    public DepartmentDTO updateDepartment(Long id, DepartmentDTO dto) {
        DepartmentEntity department = repository.findById(id)
                .orElseThrow(()->
                        new ResourceNotFoundException("Department not found"));
        department.setTitle(dto.getTitle());
        department.setIsActive(dto.getIsActive());

        return convertToDTO(repository.save(department));
    }

    @Override
    public void deleteDepartment(Long id) {
        DepartmentEntity department = repository.findById(id)
                .orElseThrow(()->
                        newResourceNotFoundException("Department not found"));

        repository.delete(department);
    }

    private DepartmentDTO convertToDTO(DepartmentEntity department){
        DepartmentDTO dto = new DepartmentDTO();

        dto.setId(department.getId());
        dto.setTitle(department.getTitle());
        dto.setIsActive(department.getIsActive());
        dto.setCreatedAt(department.getCreatedAt());

        return dto;
    }

    private DepartmentEntity convertToEntity(DepartmentDTO dto){
        DepartmentEntity department = new DepartmentEntity();

        department.setTitle(dto.getTitle());
        department.setIsActive(dto.getIsActive());
        department.setCreatedAt(LocalDateTime.now());

        return department;
    }
}
