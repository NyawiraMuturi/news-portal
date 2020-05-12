package models;

import org.sql2o.Connection;

import java.util.Objects;

public class Department {
    private String nameOfDepartment;
    private String descriptionOfDepartment;
    private String numberofemployees;
    private int id;

    public Department(String nameOfDepartment,String descriptionOfDepartment,String nbrEmployees){
        this.nameOfDepartment=nameOfDepartment;
        this.descriptionOfDepartment=descriptionOfDepartment;
        this.numberofemployees=nbrEmployees;

    }

    public String getDescriptionOfDepartment() {
        return descriptionOfDepartment;
    }

    public void setDescriptionOfDepartment(String descriptionOfDepartment) {
        this.descriptionOfDepartment = descriptionOfDepartment;
    }

    public String getNameOfDepartment() {
        return nameOfDepartment;
    }

    public void setNameOfDepartment(String nameOfDepartment) {
        this.nameOfDepartment = nameOfDepartment;
    }

    public String getNumberofemployees() {
        return numberofemployees;
    }

    public void setNumberofemployees(String numberofemployees) {
        this.numberofemployees = numberofemployees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return numberofemployees == that.numberofemployees &&
                id == that.id &&
                Objects.equals(nameOfDepartment, that.nameOfDepartment) &&
                Objects.equals(descriptionOfDepartment, that.descriptionOfDepartment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfDepartment, descriptionOfDepartment, numberofemployees, id);
    }
    public void save() {
        try(Connection con = models.DB.sql2o.open()) {
            String sql = "INSERT INTO departments (nameofdepartment, descrptofdepartment, numberofemployees) VALUES (:nameofdepartment, :descrptofdepartment, :numberofemployees)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("nameofdepartment", this.nameOfDepartment)
                    .addParameter("descrptofdepartment", this.descriptionOfDepartment)
                    .addParameter("numberofemployees", this.numberofemployees)
                    .executeUpdate()
                    .getKey();
        }
    }
}