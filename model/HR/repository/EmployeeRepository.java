package com.example.HR.repository;

import com.example.HR.model.Employes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository <Employes.Employee, Long>{

    /**
 * EmployeeRepository arabirimi.
 *
 * Bu arabirim, Employee varlıkları için JpaRepository'yi genişletir.
 * JpaRepository, Employee varlığı için temel CRUD işlemlerini sağlar.
 */



}
