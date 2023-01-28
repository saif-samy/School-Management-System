package projectoop;

import java.time.LocalDate;

public class HR extends Staff{
    private static double hrBaseSalary = 7000;
    
    public static void setHrBaseSalary(double hrBaseSalary) {
        HR.hrBaseSalary = hrBaseSalary;
    }
    public static double getHrBaseSalary() {
        return hrBaseSalary;
    }
    
    //Using polymorphism
    public static void changeBaseSalary (Staff s, double newBaseSalary){
        if (s instanceof Staff)
            Staff.setCleanerBaseSalary(newBaseSalary);
        else if (s instanceof Teacher)
            Teacher.setTeacherBaseSalary(newBaseSalary);
        else if (s instanceof Principal)
            Principal.setPrincipalBaseSalary(newBaseSalary);
        else if (s instanceof HR)
            HR.setHrBaseSalary(newBaseSalary);
    }
    
    //Using Polymorphism
    public static void addNewStaff(Staff newStaff, School school){
        if (newStaff instanceof Teacher)
            school.addNewTeacher((Teacher) newStaff);
        else if (newStaff instanceof Staff)
            school.addNewStaff(newStaff);
        else if (newStaff instanceof Principal)
            school.setPrincipal((Principal) newStaff);
        else if (newStaff instanceof HR)
            school.addnewHR((HR) newStaff);
    }
    
    public static void removeStaff(Staff newStaff, School school){
        if (newStaff instanceof Teacher)
            school.getTeachers().remove((Teacher) newStaff);
        else if (newStaff instanceof Staff)
            school.getStaffs().remove(newStaff);
        else if (newStaff instanceof HR)
            school.getHrs().remove((HR) newStaff);
        else if (newStaff instanceof Principal)
            school.removePrincipal();
    }
    
    @Override
     public double calcSalary(LocalDate Date){
         return HR.hrBaseSalary + (Person.calcYears(Date) * 0.07 * HR.hrBaseSalary);
     }

    @Override
    public String toString() {
        return super.toString();
    }

    public HR (){

    }
    public HR (String newFirstName, String newLastName, String newEmail, String newPhoneNumber, LocalDate newBirthDate, String newUsername, String newPassword,
    String newGender, String newJD, LocalDate newHiringDate, String newOfficeNumber){
        super(newFirstName, newLastName, newEmail, newPhoneNumber, newBirthDate, newUsername, newPassword, newGender, newJD, newHiringDate, newOfficeNumber);
    }
}
