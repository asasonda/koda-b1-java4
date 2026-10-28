package com.collection;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;

public class App 
{
    public static void main( String[] args )
    {
        List<Employee> listEmployee = new ArrayList<>();

        listEmployee.add(new Employee("KR001", "Andi", 7000000));
        listEmployee.add(new Employee("KR002", "Budi", 5000000));
        listEmployee.add(new Employee("KR003", "Citra", 6000000));

        System.out.println();
        System.out.println("Employee List");
        for(Employee employee : listEmployee){
            System.out.println(employee.getEmployeeCode() + " - " + employee.getEmployeeName() + " - " + employee.getEmployeeSalary());
        }
        System.out.println();



        Set<Employee> setEmployee = new HashSet<>();

        setEmployee.add(new Employee("KR001", "Andi", 7000000));
        setEmployee.add(new Employee("KR002", "Budi", 5000000));
        setEmployee.add(new Employee("KR003", "Citra", 6000000));

        System.out.println("Employee Set");
        for(Employee employee : setEmployee){
            System.out.println(employee.getEmployeeCode() + " - " + employee.getEmployeeName() + " - " + employee.getEmployeeSalary());
        }
        System.out.println();


        Queue<Employee> employeeQueue = new ArrayDeque<>();

        employeeQueue.offer(new Employee("KR001", "Andi", 7000000));
        employeeQueue.offer(new Employee("KR002", "Budi", 5000000));
        employeeQueue.offer(new Employee("KR003", "Citra", 6000000));

        System.out.println("Employee Queue");
        for(Employee employee : employeeQueue){
            System.out.println(employee.getEmployeeCode() + " - " + employee.getEmployeeName() + " - " + employee.getEmployeeSalary());
        }



        Map<String, Employee> mapEmployee = new HashMap<>();

        System.out.println();
        System.out.println("Employee Map");
        for(Employee employee : listEmployee){
            mapEmployee.put(employee.getEmployeeCode(),employee);

            System.out.println(employee.getEmployeeCode() + " - " + employee.getEmployeeName() + " - " + employee.getEmployeeSalary());
        }

        System.out.println();




        System.out.println("Active Query");
        List<Employee> employees = listEmployee.stream().filter(employe -> employe.getEmployeeSalary() >= 200000).sorted(Comparator.comparingDouble(Employee::getEmployeeSalary).reversed()).toList();

        employees.forEach((employe -> System.out.println(employe.getEmployeeName() + ": Rp."+ employe.getEmployeeSalary())));

        System.out.println();


        // cari employe
        try{
            Employee employee = findEmployee(listEmployee, "KR001").orElseThrow(()-> new NoSuchElementException("Data Tidak ditemukan"));

            System.out.println("Active Query");
            System.out.println(employee.getEmployeeName()+ ": Rp." + employee.getEmployeeSalary());
            System.out.println();
        } catch(NoSuchElementException e){
            System.out.println("Error: "+ e.getMessage());
        }

    }

    static Optional<Employee> findEmployee (List<Employee> listEmployee, String number){
        return listEmployee.stream().filter(employee -> employee.getEmployeeCode().equals(number)).findFirst();
    }
}
