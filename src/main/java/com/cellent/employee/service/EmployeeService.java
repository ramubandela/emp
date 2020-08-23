package com.cellent.employee.service;

import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cellent.employee.EmployeeDTO.EmployeeDTO;
import com.cellent.employee.entity.Employee;
import com.cellent.employee.exception.EmployeeException;
import com.cellent.employee.repository.EmpRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmpRepository repository;
	
	public Employee addEmployee(Employee employee) {
		
		Queue<String> q=new PriorityBlockingQueue<>();
		
		Employee emp=null;
		try {
			if(employee !=null)
			 {
				System.out.println(employee);
				 emp = repository.save(employee);
				
			 }else {
				 throw new EmployeeException("employee object is null  ");
			 }
		} catch (Exception e) {
			System.out.println(e.toString());
			throw new EmployeeException(e.toString());
		}
		
		return emp;
	}

	public List<EmployeeDTO> getAllEmployess() {
		List<EmployeeDTO> findAllDTO=null;
		try {
			List<Employee> findAll = repository.findAll();
			ModelMapper modelMapper = new ModelMapper();
			  Type type = new TypeToken<List<EmployeeDTO>>(){}.getType();
			  findAllDTO = modelMapper.map(findAll, type);
	         //return postDTOList;
		} catch (Exception e) {
			throw new EmployeeException(e.toString());
		}

		
		return findAllDTO;
	}
	
	public EmployeeDTO getEmployee(BigInteger id)
	{
		EmployeeDTO dto=null;
		
		try {
			Employee one = repository.getOne(id);
			dto=convertEntityToDTO(one);
		} catch (Exception e) {
			throw new EmployeeException(e.toString());
		}
		
		
		return dto;
	}
	
	public String deleteEmployee(BigInteger id)
	{
		String status="deleted successfully";
		try {
			if(id !=null) {
			 repository.deleteById(id);
			}else
			{
				throw new EmployeeException("id shouldnt be null");
			}
		} catch (Exception e) {
			throw new EmployeeException(e.toString());
		} 
		
		return status;
	}
	private Employee convertDtoToEntity(EmployeeDTO employeedto) {
		// TODO Auto-generated method stub
		System.out.println("before convsersion emp convertDtoToEntity "+employeedto);
		ModelMapper modelMapper = new ModelMapper();
		// user here is a prepopulated User instance
		Employee emp = modelMapper.map(employeedto, Employee.class);
		System.out.println("after convsersion emp convertDtoToEntity "+emp);
		return emp;
	}

	private EmployeeDTO convertEntityToDTO(Employee employee) {
		System.out.println("before convsersion empDTO convertEntityToDTO "+employee);
		ModelMapper modelMapper = new ModelMapper();
		// user here is a prepopulated User instance
		EmployeeDTO empDTO = modelMapper.map(employee, EmployeeDTO.class);
		System.out.println("before convsersion empDTO convertEntityToDTO "+empDTO);
		return empDTO;
	}


}
