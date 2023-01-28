package projectoop;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Teacher extends Staff{
    private ArrayList<Subject> subjects = new ArrayList<>();
    private ArrayList<Classroom> classrooms = new ArrayList<>();
    private static double teacherBaseSalary = 10000;

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }
    public ArrayList<Classroom> getClassrooms() {
        return classrooms;
    }
    public static void setTeacherBaseSalary(double teacherBaseSalary) {
        Teacher.teacherBaseSalary = teacherBaseSalary;
    }
    public static double getTeacherBaseSalary() {
        return teacherBaseSalary;
    }

    public void AddNewSubject (Subject subject){
        if (this.getSubjects().size() < 4)
            this.subjects.add(subject);
        else 
        JOptionPane.showMessageDialog(null, "Cannot add new subject.");
    }

    public void addClassroom(Classroom newClassroom){
        if (classrooms.size() < 6){
            classrooms.add(newClassroom);   
        }
    }

    public void changeStudentSubjectGrade(Classroom classroom, Student student, double newGrade, int subject){
        int i = classroom.getStudents().indexOf((Student) student);
        //Student is not in the students list
        if (i == -1){
            JOptionPane.showMessageDialog(null, "cannot find student");
        }
        //student found
        else{
            //check valid grade is entered
            if (newGrade >= 0 && newGrade <= 100)
                 classroom.getStudents().get(i).getSubjects().get(subject).setGrade(newGrade);
            else 
                JOptionPane.showMessageDialog(null, "Invalid Grade.");
        }
    }
    
    public void addAssignment(Classroom classroom, Assignment assignment){
        for (int i = 0; i < classroom.getStudents().size(); i++){
            classroom.getStudents().get(i).addAssignment(assignment);
        }
    }
    
    @Override
     public double calcSalary(LocalDate Date){
         return Teacher.teacherBaseSalary + (Person.calcYears(Date) * 0.05 * Teacher.teacherBaseSalary);
     }

    public Teacher(){

    }
    public Teacher(String newFirstName, String newLastName, String newEmail, String newPhoneNumber, LocalDate newBirthDate, String newUsername, String newPassword,
            String newGender, String newJD, LocalDate newHiringDate, String newOfficeNumber)
    {
        super(newFirstName, newLastName, newEmail, newPhoneNumber, newBirthDate, newUsername, newPassword, newGender, newJD, newHiringDate, newOfficeNumber);
    }
}
