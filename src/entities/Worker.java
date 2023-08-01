package entities;

import entities.enums.WorkerLevel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Worker {
    private String name;
    private WorkerLevel level;
    private Double baseSalary;

    //associados//
    private List<HourContract> contracts = new ArrayList<>();
    private Department department;




    //construtor//
    public Worker(String name, WorkerLevel level, Double baseSalary, Department department){
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    //getters e setters//
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public WorkerLevel getLevel(){
        return level;
    }
    public void setLevel(){
        this.level = level;
    }
    public Double getBaseSalary(){
        return baseSalary;
    }
    public void setBaseSalary(Double baseSalary){
        this.baseSalary = baseSalary;
    }

    public Department getDepartment(){
        return department;
    }

    public void setDepartment(String name){
        department.setName(name);
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

    //métodos//
    public void addContract(HourContract contract){
        contracts.add(contract);
    }

    public void removeContract(HourContract contract){
        contracts.remove(contract);
    }

    public Double income(Integer year, Integer month){
        double sum = baseSalary;
        Calendar cal = Calendar.getInstance();
        for (HourContract c : contracts)
        {
            cal.setTime(c.getDate());
            int c_year = cal.get(Calendar.YEAR);
            int c_month = cal.get(Calendar.MONTH) + 1;
            if (c_year == year && c_month == month)
            {
                sum += c.totalValue();
            }
        }
        return sum;
    }

}
