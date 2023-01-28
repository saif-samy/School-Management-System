package projectoop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public final class School implements SaveData, ReadData{
    private String schoolName;
    private String schoolEmail;
    private ArrayList<Staff> staffs = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Teacher> teachers = new ArrayList<>();
    private ArrayList<HR> hrs = new ArrayList<>();
    private Principal principal;
    private ArrayList<Classroom> classrooms = new ArrayList<>();
    private File staffsData = new File ("Staffs.data");
    private File studentData = new File("Students.data");
    private File teachersData = new File("Teachers.data");
    private File principalData = new File("Principal.data");
    private File hrData = new File("HR.data");
    private File classroomData = new File("Classroom.data");

    public String getSchoolName() {
        return schoolName;
    }
    public String getSchoolemail() {
        return schoolEmail;
    }
    public ArrayList<Staff> getStaffs() {
        return staffs;
    }
    public ArrayList<Student> getStudents() {
        return students;
    }
    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }
    public ArrayList<HR> getHrs() {
        return hrs;
    }
    public Principal getPrincipal() {
        return principal;
    }
    public ArrayList<Classroom> getClassrooms() {
        return classrooms;
    }
    
    
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
    public void setSchoolEmail(String schoolEmail) {
        this.schoolEmail = schoolEmail;
    }
    public void setPrincipal(Principal principal) {
        if (this.principal == null)
            this.principal = principal;
        else
            JOptionPane.showMessageDialog(null, "Cannot add new principal!");
    }
    

    public void addNewStaff(Staff newStaff) {
        staffs.add(newStaff);
    }
    public void addNewStudent(Student newStudent) {
        students.add(newStudent);
    }
    public void addNewTeacher(Teacher newTeacher) {
        teachers.add(newTeacher);
    }
    public void addnewHR(HR newHR){
        hrs.add(newHR);
    }
    public void addNewClassroom(Classroom classroom){
        classrooms.add(classroom);
    }
    public void removePrincipal(){
        this.principal = null;
    }

    public void printStaffs() {
        for (int i = 0; i < staffs.size(); i++) {
            System.out.println(staffs.get(i).toString());
        }
    }
    public void printStudents() {
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).toString());
        }
    }
    public void printTeachers() {
        for (int i = 0; i < teachers.size(); i++) {
            System.out.println(teachers.get(i).toString());
        }
    }
    public void printPrincipal(){
        System.out.println(principal);
    }
    public void printHR() {
        for (int i = 0; i < hrs.size(); i++) {
            System.out.println(hrs.get(i).toString());
        }
    }

    public void createNewFile(File file){
       try{
            if (!file.exists()){
                file.createNewFile();
            }
       }catch (IOException e){
            System.out.println(e);
       }
    }

    @Override
    public void saveStaffData() {
        // Save staff data
        try {
            createNewFile(this.staffsData);
            try (FileOutputStream FOS = new FileOutputStream(this.staffsData); ObjectOutputStream OOS = new ObjectOutputStream(FOS)) {
                if (this.staffs != null)
                    OOS.writeObject(this.staffs);
                OOS.close();
                FOS.close();
            }
            System.out.println("Staff data saved successfully.");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public void saveStudentData() {
        // Save Student Data
        try {
            createNewFile(this.studentData);
            try (FileOutputStream FOS = new FileOutputStream(this.studentData); ObjectOutputStream OOS = new ObjectOutputStream(FOS)) {
                if (this.students != null)
                    OOS.writeObject(this.students);
                OOS.close();
                FOS.close();
            }
            System.out.println("Student data saved successfully.");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public void saveTeachersData() {
        // Save teacher data
        try {
            createNewFile(this.teachersData);
            try (FileOutputStream FOS = new FileOutputStream(this.teachersData); ObjectOutputStream OOS = new ObjectOutputStream(FOS)) {
                if (this.teachers != null)
                    OOS.writeObject(this.teachers);
                OOS.close();
                FOS.close();
            }
            System.out.println("Teacher data saved successfully.");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public void savePrincipalData() {
        // Save teacher data
        try {
            createNewFile(this.principalData);
            try (FileOutputStream FOS = new FileOutputStream(this.principalData); ObjectOutputStream OOS = new ObjectOutputStream(FOS)) {
                if (this.principal != null)
                    OOS.writeObject(this.principal);
                OOS.close();
                FOS.close();
            }
            System.out.println("Principal data saved successfully.");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public void saveHRData() {
        // Save teacher data
        try {
            createNewFile(this.hrData);
            try (FileOutputStream FOS = new FileOutputStream(this.hrData); ObjectOutputStream OOS = new ObjectOutputStream(FOS)) {
                if (this.hrs != null){
                    OOS.writeObject(this.hrs);
                    OOS.close();
                FOS.close();
                }
            }
            System.out.println("HR data saved successfully.");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    @Override
    public void saveClassrooms() {
        // Save teacher data
        try {
            createNewFile(this.classroomData);
            try (FileOutputStream FOS = new FileOutputStream(this.classroomData); ObjectOutputStream OOS = new ObjectOutputStream(FOS)) {
                if (this.classrooms != null){
                    OOS.writeObject(this.classrooms);
                    OOS.close();
                    FOS.close();
                }
            }
            System.out.println("Classroom data saved successfully.");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public void readStaffData(){
        //Read Staffs data
        if (!this.staffsData.exists()){
            System.out.println("Staffdata does not exist");
        }else{
            try{
                try (FileInputStream FIS = new FileInputStream(this.staffsData); ObjectInputStream OIS = new ObjectInputStream(FIS)) {
                    this.staffs = (ArrayList <Staff>) OIS.readObject();
                    OIS.close();
                    FIS.close();
                }
                System.out.println("Staff data read successfully.");
            }catch(IOException | ClassNotFoundException e){
                System.out.println(e);
            }
        }
    }

    @Override
    public void readStudentsData(){
        //Read Student Data
        if (!this.studentData.exists()){
            System.out.println("Studentdata does not exist");
        }else{
            try{
                try (FileInputStream FIS = new FileInputStream(this.studentData); ObjectInputStream OIS = new ObjectInputStream(FIS)) {
                    this.students = (ArrayList <Student>) OIS.readObject();
                    OIS.close();
                    FIS.close();
                }
                System.out.println("Student data read successfully.");
            }catch(IOException | ClassNotFoundException e){
                System.out.println(e);
            }
        }
    }

    @Override
    public void readTeachersData(){
        //Read Teachers data
        if (!this.teachersData.exists()){
            System.out.println("Teacherdata does not exist");
        }else{
            try{
                try (FileInputStream FIS = new FileInputStream(this.teachersData); ObjectInputStream OIS = new ObjectInputStream(FIS)) {
                    this.teachers = (ArrayList <Teacher>) OIS.readObject();
                    OIS.close();
                    FIS.close();
                }
                System.out.println("Teacher data read successfully.");
            }catch(IOException | ClassNotFoundException e){
                System.out.println(e);
            }
        }
    }

    @Override
    public void readPrincipalData(){
        //Read Teachers data
        if (!this.principalData.exists()){
            System.out.println("Principaldata does not exist");
        }else{
            try{
                try (FileInputStream FIS = new FileInputStream(this.principalData); ObjectInputStream OIS = new ObjectInputStream(FIS)) {
                    this.principal = (Principal) OIS.readObject();
                    OIS.close();
                    FIS.close();
                }
                System.out.println("Principal data read successfully.");
            }catch(IOException | ClassNotFoundException e){
                System.out.println(e);
            }
        }
    }

    @Override
    public void readHRData(){
        //Read Teachers data
        if (!this.hrData.exists()){
            System.out.println("HRdata does not exist");
        }else{
            try{
                try (FileInputStream FIS = new FileInputStream(this.hrData); ObjectInputStream OIS = new ObjectInputStream(FIS)) {
                    this.hrs = (ArrayList <HR>) OIS.readObject();
                    OIS.close();
                    FIS.close();
                }
                System.out.println("HR data read successfully.");
            }catch(IOException | ClassNotFoundException e){
                System.out.println(e);
            }
        }
    }
    
    @Override
    public void readClassroomsData(){
        //Read Teachers data
        if (!this.classroomData.exists()){
            System.out.println("Classroomsdata does not exist");
        }else{
            try{
                try (FileInputStream FIS = new FileInputStream(this.classroomData); ObjectInputStream OIS = new ObjectInputStream(FIS)) {
                    this.classrooms = (ArrayList <Classroom>) OIS.readObject();
                    OIS.close();
                    FIS.close();
                }
                System.out.println("Classroom data read successfully.");
            }catch(IOException | ClassNotFoundException e){
                System.out.println(e);
            }
        }
    }

    public School(){

    }
    public School(String newName, String newEmail){
        this.schoolName = newName;
        this.schoolEmail = newEmail;
    }
    public School(String newName, String newEmail, ArrayList<Staff> newStaffs, ArrayList<Student> newStudents, ArrayList<Teacher> newTeachers, Principal newPrinciple, ArrayList<HR> newHRS){
        this.schoolName = newName;
        this.schoolEmail = newEmail;
        for (int i = 0; i < newStaffs.size(); i++){
            this.staffs.add(newStaffs.get(i));
        }
        for (int i = 0; i < newStudents.size(); i++){
            this.students.add(newStudents.get(i));
        }
        for (int i = 0; i < newTeachers.size(); i++){
            this.teachers.add(newTeachers.get(i));
        }
        this.principal = newPrinciple;
        for (int i = 0; i < newHRS.size(); i++){
            this.hrs.add(newHRS.get(i));
        }
    }
}
