package com.cellent.employee.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Table(name = "employee")
@Data
  
  
/*
 * @ToString
 * 
 * @Getter
 * 
 * @Setter
 */
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="employee_id" )
	private BigInteger id;
	@Column(name ="employee_name" )
	private String name;
	@Column(name ="employee_address" )
	private String address;
		

}
