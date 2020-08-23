package com.cellent.employee.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cellent.employee.entity.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee, BigInteger> {

}
