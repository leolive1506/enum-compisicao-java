package entities;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
  private String name;
  private Double baseSalary;
  private WorkerLevel level;

  // composições
  private Department department;
  private List<HourContract> contracts = new ArrayList<>();

  public Worker() {
  }

  public Worker(String name, Double baseSalary, WorkerLevel level, Department department) {
    this.name = name;
    this.baseSalary = baseSalary;
    this.level = level;
    this.department = department;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getBaseSalary() {
    return baseSalary;
  }

  public void setBaseSalary(Double baseSalary) {
    this.baseSalary = baseSalary;
  }

  public WorkerLevel getLevel() {
    return level;
  }

  public void setLevel(WorkerLevel level) {
    this.level = level;
  }

  public Department getDepartment() {
    return this.department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  public List<HourContract> getContracts() {
    return contracts;
  }

  public void addContract(HourContract contract) {
    contracts.add(contract);
  }

  public void removeContract(HourContract contract) {
    contracts.remove(contract);
  }

  public Double income(int year, int month) {
    double sum = this.baseSalary;
    Instant contractDate;
    LocalDate localDate;
    for (HourContract contract : this.contracts) {
      contractDate = contract.getDate();
      localDate = LocalDate.ofInstant(contractDate, ZoneId.systemDefault());

      int contractYear = localDate.getYear();
      int contractMonth = localDate.getMonthValue();

      if (contractYear == year && contractMonth == month) {
        sum += contract.totalValue();
      }
    }
  
    return sum;
  }
}
