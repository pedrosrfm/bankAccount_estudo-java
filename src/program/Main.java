package program;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter department name: ");
        String departmentName = sc.nextLine();
        System.out.print("\nEnter work data:\n");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Level: ");
        String level = sc.nextLine();
        System.out.print("Base salary: ");
        double baseSalary = sc.nextDouble();

        Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, new Department(departmentName));

        System.out.print("\nHow many contracts to this worker? ");
        int contractsAmount = sc.nextInt();

        for (int i=1;i<=contractsAmount;i++){
            System.out.print("Enter contract # " + i + " data:\n");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();
            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContract(contract);
        }

        System.out.print("\nEnter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.print("Name: " + worker.getName());
        System.out.print("\nDepartment: " + worker.getDepartment().getName());
        System.out.print("\nIncome for " + monthAndYear + ": U$ " + String.format("%.2f", worker.income(year, month)));

    }
}
