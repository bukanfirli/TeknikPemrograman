package id.ac.polban.employee;

import id.ac.polban.employee.model.*;
import id.ac.polban.employee.service.*;

public class MainApp {
    public static void main(String[] args) {
        
        //Inisialisasi data
        Department it = new Department("IT");
        EmploymentType fulltime = new EmploymentType("Full Time");

        //Buat Objek Employee
        Employee emp1 = new Employee(101, "Andi", it, fulltime, 8000000);
        Employee emp2 = new Employee(102, "Budi", it, fulltime, 7500000);

        //Gunakan EmployeeService
        EmployeeService service = new EmployeeService();
        service.addEmployee(emp1);
        service.addEmployee(emp2);
        
        //Tes Fitur Static
        System.out.println("Total Karyawan Terdaftar: " + Employee.getTotalEmployees());

        //Gaji Sebelum Kenaikan
        System.out.println("\n--- Data Sebelum Kenaikan Gaji ---");
        display(emp1);
        display(emp2);

        //Tes Fitur Raise Salary
        service.raiseSalary(101, 10);
        service.raiseSalary(102, 10);

        //Gaji Setelah Kenaikan
       System.out.println("\n--- Data Setelah Kenaikan Gaji ---");
        display(emp1);
        display(emp2);
    }

    public static void display(Employee e) {
        System.out.println("\n ID: " + e.getId() + 
                           "\n Nama: " + e.getName() + 
                           "\n Dept: " + e.getDepartment().getName() + 
                           "\n Tipe: " + e.getType().getType() + 
                           "\n Gaji: Rp " + e.getSalary());
    }
}