package ru.manikinos.profile.entity.query;

public class AllWorks {
    private String nameCompany;
    private String nameWork;
    private int salary;
    private int workExperience;

    public AllWorks(String nameCompany, String nameWork, int salary, int workExperience) {
        this.nameCompany = nameCompany;
        this.nameWork = nameWork;
        this.salary = salary;
        this.workExperience = workExperience;
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

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }
}
