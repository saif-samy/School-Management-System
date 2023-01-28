package projectoop;

import java.time.LocalDate;

public class Principal extends Staff{
    private static double principalBaseSalary = 15000;
    
    public static void setPrincipalBaseSalary(double principalBaseSalary) {
        Principal.principalBaseSalary = principalBaseSalary;
    }
    public static double getPrincipalBaseSalary() {
        return principalBaseSalary;
    }
    
    public void addNewStudent(Classroom classroom, Student student) {
        if (classroom.getStudents().size() < 30){
            classroom.addNewStudent(student);
        }
    }
    
    public void removeStudent(Classroom classroom, Student student){
        classroom.getStudents().remove(student);
    } 

    public void addClassTeacher(Classroom classroom, Teacher teacher){
       if (classroom.getTeachers().size() < 6){
            classroom.addNewTeacher(teacher);
            teacher.addClassroom(classroom);
       }
    }
    
    public void removeTeacher(Classroom classroom, Teacher teacher){
        classroom.getTeachers().remove(teacher);
    }
    
    @Override
     public double calcSalary(LocalDate Date){
         return Principal.principalBaseSalary + (Person.calcYears(Date) * 0.09 * Principal.principalBaseSalary);
     }

    @Override
    public String toString() {
        return super.toString();
    }

    public Principal (){

    }
    public Principal (String newFirstName, String newLastName, String newEmail, String newPhoneNumber, LocalDate newBirthDate, String newUsername, String newPassword,
    String newGender, String newJD, LocalDate newHiringDate, String newOfficeNumber){
        super(newFirstName, newLastName, newEmail, newPhoneNumber, newBirthDate, newUsername, newPassword, newGender, newJD, newHiringDate, newOfficeNumber);
    }
}
