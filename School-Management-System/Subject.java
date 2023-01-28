package projectoop;

import java.io.Serializable;

public class Subject implements Serializable{
    private String name;
    private String code;
    private double grade;
    private Teacher teacher;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public double getGrade() {
        return grade;
    }
    public void setGrade(double grade) {
        this.grade = grade;
    }
    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() + " Code: " + this.getCode();
    }

    public Subject(){

    }
    public Subject(String newName, String newCode, Teacher newTeacher){
        this.name = newName;
        this.code = newCode;
        this.teacher = newTeacher;
    }
      public Subject(String newName, String newCode, double newGrade, Teacher newTeacher){
        this.name = newName;
        this.code = newCode;
        this.grade = newGrade;
        this.teacher = newTeacher;
    }
}
