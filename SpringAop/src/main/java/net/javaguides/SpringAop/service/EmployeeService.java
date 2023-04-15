package net.javaguides.SpringAop.service;

import net.javaguides.SpringAop.exception.ResourceNotFoundException;
import net.javaguides.SpringAop.model.Employee;
import net.javaguides.SpringAop.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Optional<Employee> getEmployeeById(Long employeeId){
        return this.employeeRepository.findById(employeeId);
    }

    public List<Employee> getAllEmployees() {

        return this.employeeRepository.findAll();
    }

    public Employee add(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) throws ResourceNotFoundException {

        Employee employeeFromDb = this.employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource Not found"));

        employeeFromDb.setFirstName(employee.getFirstName());
        employeeFromDb.setLastName(employee.getLastName());
        employeeFromDb.setEmailId(employee.getEmailId());

        return this.employeeRepository.save(employeeFromDb);
    }

    public Boolean deleteEmployee(Long id) throws ResourceNotFoundException {
        Employee employee = this.employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource Not Found"));

        employeeRepository.delete(employee);

        return true;
    }
}
