package projectoop;

import java.time.LocalDate;

public class Staff extends Person implements Salary{
    protected String jobDescription;
    protected LocalDate hiringDate;
    protected double salary;
    protected String officeNumber;
    private static double cleanerBaseSalary = 5000;

    public String getJobDescription() {
        return jobDescription;
    }
    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
    public LocalDate getHiringDate() {
        return hiringDate;
    }
    public void setHiringDate(LocalDate hiringDate) {
        this.hiringDate = hiringDate;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getOfficeNumber() {
        return officeNumber;
    }
    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }
    public static void setCleanerBaseSalary(double cleanerBaseSalary) {
        Staff.cleanerBaseSalary = cleanerBaseSalary;
    }
    public static double getCleanerBaseSalary() {
        return cleanerBaseSalary;
    }
    

    @Override
    public String toString() {
        return super.toString() + " Job Description: " + this.getJobDescription() + " Hiring Date: " + this.getHiringDate()
            + " Salary: " + this.getSalary() + " Office Number: " + this.getOfficeNumber();
    }

    @Override
    public double calcSalary(LocalDate Date){
        return Staff.cleanerBaseSalary + (Person.calcYears(Date) * 0.05 * Staff.cleanerBaseSalary);
    }
    
    public static boolean Login(Staff staff, String username, String Password){
        if (staff.getUsername().equals(username) && staff.getPassword().equals(Password))
            return true;
        else 
            return false;
    }

    public Staff(){

    }
    public Staff(String newFirstName, String newLastName, String newEmail, String newPhoneNumber, LocalDate newBirthDate, String newUsername, String newPassword,
             String newGender, String newJD, LocalDate newHiringDate, String newOfficeNumber){
        super(newFirstName, newLastName, newEmail, newPhoneNumber, newBirthDate, newUsername, newPassword, newGender);
        this.jobDescription = newJD;
        this.hiringDate = newHiringDate;
        this.officeNumber = newOfficeNumber;
        this.salary = calcSalary(newHiringDate);
    }
}
