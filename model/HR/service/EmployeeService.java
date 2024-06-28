package com.example.HR.service;
import com.example.HR.model.Employes;
import com.example.HR.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Yeni bir çalışanı işe alır
    public Employes.Employee hireEmployee(Employes.Employee employee) {
        return employeeRepository.save(employee);
    }

    // Tüm çalışanları listeler
    public List<Employes.Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Belirli bir ID'ye sahip çalışanı getirir => optional ile yapılar
    public Optional<Employes.Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    // Belirli bir ID'ye sahip çalışanı günceller
    public Employes.Employee updateEmployee(Long id, Employes.Employee employeeDetails) {
        Employes.Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        employee.setName(employeeDetails.getName());
        employee.setPosition(employeeDetails.getPosition());
        return employeeRepository.save(employee);
        // orElse yani if döngüsünün else kısmı gibi düşününlebilir Aradıüımız çalışanı bulur.
        // kullanıcıya belirli bir metin gesteriyoruzç
    }
    // Belirli bir ID'ye sahip çalışanı işten çıkarır
    public void fireEmployee(Long id) {
        Employes.Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        employeeRepository.delete(employee);
    }
}