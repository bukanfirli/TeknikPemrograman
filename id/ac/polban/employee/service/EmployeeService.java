package id.ac.polban.employee.service;

import java.util.HashMap;
import java.util.Map;
import id.ac.polban.employee.model.*; // Import model agar bisa digunakan

public class EmployeeService {
    // Menyimpan data karyawan di dalam Map (ID sebagai Key)
    private Map<Integer, Employee> employees = new HashMap<>();

    // RELASI DEPENDENCY: Method ini bergantung pada objek Employee sebagai parameter
    public void addEmployee(Employee emp) {
        employees.put(emp.getId(), emp);
    }
    
    public Employee getEmployee(int id) {
        return employees.get(id);
    }

    public void raiseSalary(int id, double percent) {
        Employee emp = employees.get(id);
        if (emp != null) {
            // Rumus kenaikan gaji
            double newSalary = emp.getSalary() * (1 + percent/100);
            emp.setSalary(newSalary);
        }
    }
}