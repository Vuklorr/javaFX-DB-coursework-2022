package ru.manikinos.profile.entity;

public class WorkActivity {
    private int id;
    private String nameCompany;
    private String nameWork;
    private int salary;

    public WorkActivity(int id, String nameCompany, String nameWork, int salary) {
        this.id = id;
        this.nameCompany = nameCompany;
        this.nameWork = nameWork;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getNameWork() {
        return nameWork;
    }

    public void setNameWork(String nameWork) {
        this.nameWork = nameWork;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
