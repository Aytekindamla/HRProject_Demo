package com.example.HR.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Employes {

    @Entity
    public  class Employee {
     @Id
     @GeneratedValue(strategy= GenerationType.IDENTITY)
     private Long id;
     private String name;
     private String position;

     public Long getId(){
     return id;
     }
    public String getName(){
      return name;
    }
     public void setName(String name) {
            this.name = name;
     }
     public String getPosition() {
            return position;
     }
      public void setPosition(String position) {
            this.position = position;
        }
    }
}
