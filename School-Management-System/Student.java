package projectoop;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Student extends Person{
    private Classroom classroom;
    private ArrayList <Subject> subjects = new ArrayList<>();
    private ArrayList <Assignment> assignments = new ArrayList<>();

    public Classroom getClassroom() {
        return classroom;
    }
    public void setClass(Classroom Class) {
        this.classroom = Class;
    }
    public ArrayList<Subject> getSubjects() {
        return subjects;
    }
    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }
    

    public void addNewSubject (Subject subject){
        if (this.getSubjects().size() < 6)
            this.subjects.add(subject);
        else 
        JOptionPane.showMessageDialog(null, "Cannot add new subject");
    }

    public static double calcTotalPercentage(Student student){
        double totalGrade = 0;
        double grade = 0;
        for (int i = 0; i < student.subjects.size(); i++){
            totalGrade += 100;
            grade += student.subjects.get(i).getGrade();
        }
        return (grade / totalGrade) * 100;
    }
    
    public void checkAssignments(){
        LocalDate currentDate = LocalDate.now();
        for (int i = 0; i < this.assignments.size(); i++){
            if (this.assignments.get(i).getDueDate().isBefore(currentDate)){
                this.assignments.remove(i);
                i--;
            }
        }
    }
    
    public void addAssignment(Assignment assignment){
        assignments.add(assignment);
    }
    
    public void viewAssignments(){
        this.checkAssignments();
        String data = "";
        for (int i = 0; i < this.assignments.size(); i++){
            data +=(i + 1) + ": ";
            data += "Description: " + this.assignments.get(i).getDescription();
            data += ", ";
            data += "Due date: " + this.assignments.get(i).getDueDate();
            data += "\n";
        }
        JOptionPane.showMessageDialog(null, "Assignments:\n" + data);
    }

    @Override
    public String toString() {
        return super.toString() + " Class Number: " + this.classroom.getName() + " Subjects: " + subjects.toString();
    }

    public Student(){

    }
    public Student(String newFirstName, String newLastName, String newEmail, String newPhoneNumber, LocalDate newBirthDate, String newUsername, String newPassword, String newGender, Classroom newClass){
        super(newFirstName, newLastName, newEmail, newPhoneNumber, newBirthDate, newUsername, newPassword, newGender);
        this.classroom = newClass;
    }
}
