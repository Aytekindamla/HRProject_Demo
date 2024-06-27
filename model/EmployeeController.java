package com.example.HR.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService; // EmployeeService bağımlılığı

    // Yeni bir çalışan işe almak için POST isteği
    // RequestBody ile gelen JSON verisini Employes.Employee türüne dönüştürür
    // Sonrasında employeeService.hireEmployee metodunu çağırarak işe alım işlemini gerçekleştirir
    @PostMapping("/hire")
    public Employes.Employee hireEmployee(@RequestBody Employes.Employee employee) {
        return employeeService.hireEmployee(employee);
    }

    // Tüm çalışanları listelemek için GET isteği
    // employeeService.getAllEmployees metodunu çağırarak tüm çalışanları döndürür
    @GetMapping
    public List<Employes.Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Belirli bir çalışanı ID'ye göre getirmek için GET isteği
    // PathVariable ile gelen ID'ye göre employeeService.getEmployeeById metodunu çağırarak çalışanı Optional olarak döndürür
    @GetMapping("/{id}")
    public Optional<Employes.Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // Bir çalışanı güncellemek için PUT isteği
    // PathVariable ile gelen ID'ye göre ve RequestBody ile gelen güncel veriye göre çalışanı günceller
    // Yeni veriyi employeeDetails olarak alır ve employeeService.updateEmployee metodunu çağırarak güncelleme işlemini gerçekleştirir
    @PutMapping("/{id}")
    public Employes.Employee updateEmployee(@PathVariable Long id, @RequestBody Employes.Employee employeeDetails) {
        return employeeService.updateEmployee(id, employeeDetails);
    }

    // Bir çalışanı işten çıkarmak için DELETE isteği
    // PathVariable ile gelen ID'ye göre çalışanı işten çıkartır
    // Geriye bir değer döndürmez (void)
    @DeleteMapping("/fire/{id}")
    public void fireEmployee(@PathVariable Long id) {
        employeeService.fireEmployee(id);
    }
}
