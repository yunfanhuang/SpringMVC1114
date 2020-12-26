package com.spring.mvc.entity;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Employees")
public class Employee {
    
    @Id
    @GeneratedValue
    private Integer id;
    
    @Column
    private String name;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Department department = new Department();
    
    @OneToOne(cascade = CascadeType.PERSIST)
    private Salary salary = new Salary();
    
    @JoinTable(
            name = "employee_club",
            joinColumns = {@JoinColumn(name = "employee_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "club_id",referencedColumnName = "id")}
    )    
    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Club> club = new LinkedHashSet<>();

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Set<Club> getClub() {
        return club;
    }

    public void setClub(Set<Club> club) {
        this.club = club;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", department=" + department + ", salary=" + salary + ", club=" + club + '}';
    }
    
    
}
