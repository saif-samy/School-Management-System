package projectoop;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Classroom implements Serializable{
    private String name;
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Teacher> teachers = new ArrayList<>();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<Student> getStudents() {
        return students;
    }
    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void addNewStudent(Student newStudent){
        if (students.size() < 30)
            students.add(newStudent);
        else 
            JOptionPane.showMessageDialog(null, "Cannot add new student.");
    }
    public void addNewTeacher(Teacher newTeacher){
        if (this.teachers.size() < 6){
            teachers.add(newTeacher);
        }
        else   
        JOptionPane.showMessageDialog(null, "Cannot add new teacher.");
    }

    public static double getLowestgrade(ArrayList<Student> students, int subject){
        double lowestgrade = 100;
        for (int i = 0; i < students.size(); i++){
            if (students.get(i).getSubjects().get(subject).getGrade() < lowestgrade)
                lowestgrade = students.get(i).getSubjects().get(subject).getGrade();
        }
        return lowestgrade;
    }

    public static double getHighestgrade(ArrayList<Student> students, int subject){
        double highestgrade = 0;
        for (int i = 0; i < students.size(); i++){
            if (students.get(i).getSubjects().get(subject).getGrade() > highestgrade)
                highestgrade = students.get(i).getSubjects().get(subject).getGrade();
        }
        return highestgrade;
    }

    public static double getAverageGrade(ArrayList<Student> students, int subject){
        double avgGrade = 0;
        for (int i = 0; i < students.size(); i++){
            avgGrade += students.get(i).getSubjects().get(subject).getGrade();
        }
        return avgGrade / students.size();
    }
    
    public Classroom(){
        
    }
    public Classroom(String newName){
        this.name = newName;
    }
    public Classroom(String newName, ArrayList<Student> newStudents, ArrayList<Teacher> newTeachers){
        this.name = newName;
        for (int i = 0; i < newStudents.size(); i++){
            students.add(newStudents.get(i));
        }
        for (int i = 0; i < newTeachers.size(); i++){
            teachers.add(newTeachers.get(i));
        }
    }
}
