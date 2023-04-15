package net.javaguides.SpringAop.controller;

import net.javaguides.SpringAop.exception.ResourceNotFoundException;
import net.javaguides.SpringAop.model.Employee;
import net.javaguides.SpringAop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> allEmployees = this.employeeService.getAllEmployees();
        return ResponseEntity.ok().body(allEmployees);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long empId)
            throws ResourceNotFoundException {

        Employee employee = this.employeeService.getEmployeeById(empId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Employee not found in the db")
                );
        return ResponseEntity.ok().body(employee);
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){

        Employee addedEmployee = this.employeeService.add(employee);

        return ResponseEntity.ok().body(addedEmployee);
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee)
            throws ResourceNotFoundException {
        Employee updatedEmployee = this.employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<?> deleteEmployee (@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.accepted().body(this.employeeService.deleteEmployee(id));
    }
}
