package projectoop;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class Person implements Serializable{
    protected String firstName;
    protected String lastName;
    protected String email;
    protected int age;
    protected String phoneNumber;
    //Date must be in YYYY-MM-DD format
    protected LocalDate birthDate;
    protected String username;
    protected String password;
    protected String gender;

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    protected static int calcYears(LocalDate Date){
        LocalDate currentDate = LocalDate.now();
        if ((Date != null) && (currentDate != null))
            return Period.between(Date, currentDate).getYears();
        else
            return 0;
    }

    @Override
    public String toString() {
        return "First Name: " + this.getFirstName() + " Last Name: " + this.getLastName() + " Email: " + this.getEmail() + " Phone number: " + this.getPhoneNumber()
            + " Birthdate: " + this.getBirthDate() + " Age: " + this.getAge();
    }

    public Person(){

    }
    public Person (String newFirstName, String newLastName, String newEmail, String newPhoneNumber, LocalDate newBirthDate, String newUsername, String newPassword, String newGender){
        this.firstName = newFirstName;
        this.lastName = newLastName;
        this.email = newEmail;
        this.phoneNumber = newPhoneNumber;
        this.birthDate = newBirthDate;
        this.username = newUsername;
        this.password = newPassword;
        this.gender = newGender;
        this.age = Person.calcYears(newBirthDate);
    }
}
