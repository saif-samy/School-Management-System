package projectoop;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ProjectOOP {

    public static void main(String[] args) {
        int menu = 3, menuChoice = -1, loginOption = 10;
        School school = new School();
        // read data
        school.readStaffData();
        school.readStudentsData();
        school.readTeachersData();
        school.readPrincipalData();
        school.readHRData();
        school.readClassroomsData();

        if (school.getHrs().isEmpty()) {
            LocalDate date = LocalDate.parse("2020-07-06");
            HR hr = new HR("Abdelrahman", "Moahmmed", "abdelahman@gmail.com", "123456789", date, "Abdelrahman", "12345", "Male", "HR", date, "A120");
            System.out.println("HR added");
            school.addnewHR(hr);
        }
        
        if (school.getPrincipal() == null) {
            LocalDate date = LocalDate.parse("2020-07-06");
            Principal pr = new Principal("Seif", "Osman", "saifosman@gmail.com", "983242368", date, "Seif", "12345", "Male", "Principal", date, "A120");
            System.out.println("PR added");
            school.setPrincipal(pr);
        }
        
        if (school.getClassrooms().isEmpty()) {
            Classroom classroom = new Classroom("Year 8", school.getStudents(), school.getTeachers());
            Classroom classroom2 = new Classroom("Year 9", school.getStudents(), school.getTeachers());
            Classroom classroom3 = new Classroom("Year 10", school.getStudents(), school.getTeachers());
            school.addNewClassroom(classroom);
            school.addNewClassroom(classroom2);
            school.addNewClassroom(classroom3);
        }
        if (school.getTeachers().isEmpty()) {
            LocalDate date = LocalDate.parse("2020-07-06");
            Teacher t = new Teacher("Abdelrahman", "Ahmed", "abdelahman@gmail.com", "123456789", date, "Vega", "12345", "Male", "Teacher", date, "A120");
            System.out.println("Teacher added");
            school.addNewTeacher(t);
        }
        if (school.getStudents().isEmpty()) {
            LocalDate date = LocalDate.parse("2001-07-06");
            Student s = new Student("Abdelrahman", "Shoeb", "abdelahman@gmail.com", "123456789", date, "Shoeb", "12345", "Male", school.getClassrooms().get(0));
            System.out.println("Student added");
            school.addNewStudent(s);
            school.getClassrooms().get(0).addNewStudent(s);
            Subject sub = new Subject("Math", "M100", 80, school.getTeachers().get(0));
            for (int i = 0; i < 3; i++)
                school.getStudents().get(0).addNewSubject(sub);
            LocalDate date2 = LocalDate.parse("2022-06-05");
            Assignment a = new Assignment("Solve question 3", date2);
            for (int i = 0; i < 3; i++)
                school.getStudents().get((0)).addAssignment(a);
        }
        
        if (school.getStaffs().isEmpty()){
            LocalDate date = LocalDate.parse("2001-07-06");
            LocalDate date2 = LocalDate.parse("2001-07-06");
            Staff staff = new Staff("Nour", "Ehab", "nourehab@gmail.com", "0107878778", date, "NourEhab", "12345", "Male", "Cleaner", date2, "A201");
            school.addNewStaff(staff);
            System.out.println("Staff added");
        }
        

        JOptionPane.showMessageDialog(null, "Welcome to School Management System!");

        do {

            //Welcome Menu ------------------------------------------------------------
            menuChoice = -1;
            while (menuChoice == -1 || menu <= 0 || (menu != 1 && menu != 2)) {
                if (menu <= 0) {
                    JOptionPane.showMessageDialog(null, "Entered negative or zero, please choose a valid option.");
                    menu = 5;
                }
                try {
                    menu = Integer.parseInt(JOptionPane.showInputDialog(null, "Select an option:\n1: Login to your account.\n2: Exit.\n"));
                    menuChoice = 0;
                } catch (NumberFormatException h) {
                    JOptionPane.showMessageDialog(null, "An Exception has occurred, Entered wrong format!");
                }
            }

            //Login Menu ------------------------------------------------------------------
            if (menu == 1) {
                menuChoice = -1;
                loginOption = 10;
                while (menuChoice == -1 || loginOption <= 0 || (loginOption != 1 && loginOption != 2 && loginOption != 3 && loginOption != 4 && loginOption != 5)) {
                    if (loginOption <= 0) {
                        JOptionPane.showMessageDialog(null, "Entered negative or zero, please choose a valid option.");
                        loginOption = 10;
                    }
                    try {
                        loginOption = Integer.parseInt(JOptionPane.showInputDialog(null, "Select an option:\n1: Principal login.\n2: HR login.\n3: Teacher login.\n4: Student login.\n5: Exit login menu."));
                        menuChoice = 0;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "An Exception has occurred, Entered wrong format!");
                    }
                }
            }

            //Principal  --------------------------------------------------------------------------------
            if (loginOption == 1) {
                //Principal login ----------------------------------------------------------------------------
                boolean principalLogin = false;
                JTextField prUsername = new JTextField();
                JTextField prPassword = new JTextField();
                Object[] prData = {"Username:", prUsername, "Password:", prPassword};
                JOptionPane.showConfirmDialog(null, prData, "Principal login", JOptionPane.OK_CANCEL_OPTION);
                if (Staff.Login(school.getPrincipal(), prUsername.getText(), prPassword.getText())) {
                    principalLogin = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong principal username or password entered.");
                }

                //Principal login success and menu ------------------------------------------------------
                if (principalLogin) {
                    JOptionPane.showMessageDialog(null, "Login Succes!");
                    principalLogin = false;
                    int principalOption = 10;
                    do {
                        menuChoice = -1;
                        while (menuChoice == -1 || principalOption <= 0 || (principalOption != 1 && principalOption != 2 && principalOption != 3 && principalOption != 4 && principalOption != 5)) {
                            if (principalOption <= 0) {
                                JOptionPane.showMessageDialog(null, "Entered negative or zero, please choose a valid option.");
                                principalOption = 10;
                            }
                            try {
                                principalOption = Integer.parseInt(JOptionPane.showInputDialog(null, "Select an option:\n1: Add new student.\n2: Remove student.\n3: Add Teacher to class.\n4: Remove teacher from class.\n5: Exit menu."));
                                menuChoice = 0;
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "An Exception has occurred, Entered wrong format!");
                            }
                        }

                        //Add new Student
                        if (principalOption == 1) {
                            try {
                                int classOption;
                                JOptionPane.showMessageDialog(null, "Enter student data.");
                                JTextField studentFirstName = new JTextField();
                                JTextField studentLastName = new JTextField();
                                JTextField studentEmail = new JTextField();
                                JTextField studentPhoneNumeber = new JTextField();
                                JTextField studentBirthDate = new JTextField();
                                JTextField studentGender = new JTextField();
                                Object[] studentData = {"First name:", studentFirstName, "Last Name:", studentLastName, "Email:", studentEmail, "Phone number: ", studentPhoneNumeber,
                                    "Birthdate(YYYY-MM-DD):", studentBirthDate, "Gender(Male-Female):", studentGender};
                                JOptionPane.showConfirmDialog(null, studentData, "Student Data", JOptionPane.OK_CANCEL_OPTION);

                                boolean classChoice = false;
                                do {
                                    String names = "";
                                    for (int i = 0; i < school.getClassrooms().size(); i++) {
                                        names += (i + 1) + ": ";
                                        names += school.getClassrooms().get(i).getName();
                                        names += "\n";
                                    }
                                    classOption = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose class:\n" + names));
                                    if (classOption != 0 && classOption > 0 && classOption <= school.getClassrooms().size()) {
                                        classOption--;
                                        classChoice = true;
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Invalid class chosen.");
                                    }
                                } while (!classChoice);

                                if (school.getClassrooms().get(classOption).getStudents().size() < 30 && !studentFirstName.equals(null) && !studentLastName.getText().equals(null)
                                        && !studentEmail.getText().equals(null) && !studentPhoneNumeber.getText().equals(null) && !studentBirthDate.getText().equals(menu)
                                        && !studentGender.getText().equals(null)) {
                                    Student student = new Student(studentFirstName.getText(), studentLastName.getText(), studentEmail.getText(), studentPhoneNumeber.getText(),
                                            LocalDate.parse(studentBirthDate.getText()), studentFirstName.getText() + studentLastName.getText(), studentFirstName.getText() + studentPhoneNumeber.getText(),
                                            studentGender.getText(), school.getClassrooms().get(classOption));
                                    school.addNewStudent(student);
                                    school.getPrincipal().addNewStudent(school.getClassrooms().get(classOption), student);
                                    JOptionPane.showMessageDialog(null, "Student added!");
                                } else {
                                    if (school.getClassrooms().get(classOption).getStudents().size() == 30) {
                                        JOptionPane.showMessageDialog(null, "Class is full, cannot add the student!");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Cannot add student, data enterred incorrectly");
                                    }
                                }
                            } catch (NumberFormatException | DateTimeParseException | IndexOutOfBoundsException e) {
                                JOptionPane.showMessageDialog(null, "Error!");
                            }
                        } 

                        //remove student
                        else if (principalOption == 2) {
                            try {
                                int classOption, studentOption;
                                boolean classChoice = false, studentChoice = false;
                                do {
                                    String names = "";
                                    for (int i = 0; i < school.getClassrooms().size(); i++) {
                                        names += (i + 1) + ": ";
                                        names += school.getClassrooms().get(i).getName();
                                        names += "\n";
                                    }
                                    classOption = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose class to remove student from:\n" + names));
                                    if (classOption != 0 && classOption > 0 && classOption <= school.getClassrooms().size()) {
                                        classOption--;
                                        classChoice = true;
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Invalid class chosen.");
                                    }
                                } while (!classChoice);

                                do {
                                    String names = "";
                                    for (int i = 0; i < school.getClassrooms().get(classOption).getStudents().size(); i++) {
                                        names += (i + 1) + ": ";
                                        names += school.getClassrooms().get(classOption).getStudents().get(i).getFirstName();
                                        names += " ";
                                        names += school.getClassrooms().get(classOption).getStudents().get(i).getLastName();
                                        names += "\n";
                                    }
                                    studentOption = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose student to remove:\n" + names));
                                    if (studentOption != 0 && studentOption > 0 && studentOption <= school.getClassrooms().get(classOption).getStudents().size()) {
                                        studentOption--;
                                        studentChoice = true;
                                        school.getStudents().remove(school.getClassrooms().get(classOption).getStudents().get(studentOption));
                                        school.getPrincipal().removeStudent(school.getClassrooms().get(classOption), school.getClassrooms().get(classOption).getStudents().get(studentOption));
                                        JOptionPane.showMessageDialog(null, "Student removed!");
                                    }
                                } while (!studentChoice);
                            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                                JOptionPane.showMessageDialog(null, "Error!");
                            }
                        } 

                        //add teacher to class
                        else if (principalOption == 3) {
                            try {
                                int classOption, teacherOption;
                                boolean classChoice = false, teacherChoice = false;

                                do {
                                    String names = "";
                                    for (int i = 0; i < school.getClassrooms().size(); i++) {
                                        names += (i + 1) + ": ";
                                        names += school.getClassrooms().get(i).getName();
                                        names += "\n";
                                    }
                                    classOption = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose class to add teacher to:\n" + names));
                                    if (classOption != 0 && classOption > 0 && classOption <= school.getClassrooms().size()) {
                                        classOption--;
                                        classChoice = true;
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Invalid class chosen.");
                                    }
                                } while (!classChoice);

                                do {
                                    String names = "";
                                    for (int i = 0; i < school.getTeachers().size(); i++) {
                                        names += (i + 1) + ": ";
                                        names += school.getTeachers().get(i).getFirstName();
                                        names += " ";
                                        names += school.getTeachers().get(i).getLastName();
                                        names += "\n";
                                    }

                                    teacherOption = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose teacher to add to class:\n" + names));
                                    if (teacherOption != 0 && teacherOption > 0 && teacherOption <= school.getTeachers().size()) {
                                        teacherOption--;
                                        teacherChoice = true;
                                        school.getPrincipal().addClassTeacher(school.getClassrooms().get(classOption), school.getTeachers().get(teacherOption));
                                        JOptionPane.showMessageDialog(null, "Teacher added!");
                                    }
                                } while (!teacherChoice);
                            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                                JOptionPane.showMessageDialog(null, "Error!");
                            }
                        }

    
                        //remove teacher from class
                        else if (principalOption == 4) {
                            try {
                                int classOption, teacherOption;
                                boolean classChoice = false, teacherChoice = false;

                                do {
                                    String names = "";
                                    for (int i = 0; i < school.getClassrooms().size(); i++) {
                                        names += (i + 1) + ": ";
                                        names += school.getClassrooms().get(i).getName();
                                        names += "\n";
                                    }
                                    classOption = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose class to remove teacher from:\n" + names));
                                    if (classOption != 0 && classOption > 0 && classOption <= school.getClassrooms().size()) {
                                        classOption--;
                                        classChoice = true;
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Invalid class chosen.");
                                    }
                                } while (!classChoice);

                                do {
                                    String names = "";
                                    for (int i = 0; i < school.getClassrooms().get(classOption).getTeachers().size(); i++) {
                                        names += (i + 1) + ": ";
                                        names += school.getClassrooms().get(classOption).getTeachers().get(i).getFirstName();
                                        names += " ";
                                        names += school.getClassrooms().get(classOption).getTeachers().get(i).getLastName();
                                        names += "\n";
                                    }

                                    teacherOption = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose teacher to remove:\n" + names));
                                    if (teacherOption != 0 && teacherOption > 0 && teacherOption <= school.getClassrooms().get(classOption).getTeachers().size()) {
                                        teacherOption--;
                                        teacherChoice = true;
                                        school.getPrincipal().removeTeacher(school.getClassrooms().get(classOption), school.getClassrooms().get(classOption).getTeachers().get(teacherOption));
                                        JOptionPane.showMessageDialog(null, "Teacher removed!");
                                    }
                                } while (!teacherChoice);
                            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                                JOptionPane.showMessageDialog(null, "Error!");
                            }
                        }
                    } while (principalOption != 5);
                }
            } 

            //HR----------------------------------------------------------
            else if (loginOption == 2) {
                boolean HRLogin = false;
                JTextField hrUsername = new JTextField();
                JTextField hrPassword = new JTextField();
                Object[] hrData = {"Username:", hrUsername, "Password:", hrPassword};
                JOptionPane.showConfirmDialog(null, hrData, "HR login", JOptionPane.OK_CANCEL_OPTION);
                for (int i = 0; i < school.getHrs().size() && !HRLogin; i++) {
                    if (Staff.Login(school.getHrs().get(i), hrUsername.getText(), hrPassword.getText())) {
                        HRLogin = true;
                    }
                }
                if (HRLogin == false) {
                    JOptionPane.showMessageDialog(null, "Wrong HR username or password entered.");
                } else {
                    JOptionPane.showMessageDialog(null, "Login Succes!");
                    HRLogin = false;
                    int hrOption = 10;
                    do {
                        menuChoice = -1;
                        while (menuChoice == -1 || hrOption <= 0 || (hrOption != 1 && hrOption != 2 && hrOption != 3 && hrOption != 4)) {
                            if (hrOption <= 0) {
                                JOptionPane.showMessageDialog(null, "Entered negative or zero, please choose a valid option.");
                                hrOption = 10;
                            }
                            try {
                                hrOption = Integer.parseInt(JOptionPane.showInputDialog(null, "Select an option:\n1: Change base salary.\n2: Add staff.\n3: Remove Staff.\n4: Exit menu."));
                                menuChoice = 0;
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "An Exception has occurred, Entered wrong format!");
                            }
                        }

                        //Change base salary
                        if (hrOption == 1) {
                            int baseSalaryOption = 10;
                            try {
                                do {
                                    baseSalaryOption = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose staff type:\n1: Cleaner\n2: Teacher\n3: Principal\n4: HR"));
                                } while (baseSalaryOption != 1 && baseSalaryOption != 2 && baseSalaryOption != 3 && baseSalaryOption != 4);
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Error!");
                            }

                            double newSalary = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter new salary: "));
                            if (baseSalaryOption == 1) {
                                Staff s = new Staff();
                                HR.changeBaseSalary(s, newSalary);
                                JOptionPane.showMessageDialog(null, "Cleaner base salary changed.");
                            } else if (baseSalaryOption == 2) {
                                Teacher t = new Teacher();
                                HR.changeBaseSalary(t, newSalary);
                                JOptionPane.showMessageDialog(null, "Teacher base salary changed.");
                            } else if (baseSalaryOption == 3) {
                                Principal p = new Principal();
                                HR.changeBaseSalary(p, newSalary);
                                JOptionPane.showMessageDialog(null, "Principal base salary changed.");
                            } else if (baseSalaryOption == 4) {
                                HR hr = new HR();
                                HR.changeBaseSalary(hr, newSalary);
                                JOptionPane.showMessageDialog(null, "HR base salary changed.");
                            }
                        } 

                        //Add staff
                        else if (hrOption == 2) {
                            try {
                                JTextField staffFirstName = new JTextField();
                                JTextField staffLastName = new JTextField();
                                JTextField staffEmail = new JTextField();
                                JTextField staffPhoneNumeber = new JTextField();
                                JTextField staffBirthDate = new JTextField();
                                JTextField staffGender = new JTextField();
                                JTextField staffjobdescription = new JTextField();
                                JTextField staffHiringDate = new JTextField();
                                JTextField staffOfficeNumber = new JTextField();
                                Object[] teacherData = {"First name:", staffFirstName, "Last Name:", staffLastName, "Email:", staffEmail, "Phone number: ", staffPhoneNumeber,
                                    "Birthdate(YYYY-MM-DD):", staffBirthDate, "Gender(Male-Female):", staffGender, "Job description(Cleaner-Teacher-Principal-HR:", staffjobdescription,
                                    "Hiring date:", staffHiringDate, "Office Number:", staffOfficeNumber};
                                JOptionPane.showConfirmDialog(null, teacherData, "Teacher Data", JOptionPane.OK_CANCEL_OPTION);

                                if (!staffFirstName.getText().equals(null) && !staffLastName.getText().equals(null)
                                        && !staffEmail.getText().equals(null) && !staffPhoneNumeber.getText().equals(null) && !staffBirthDate.getText().equals(null)
                                        && !staffGender.getText().equals(null) && !staffjobdescription.getText().equals(null) && !staffHiringDate.getText().equals(null) && !staffOfficeNumber.getText().equals(null)) {

                                    if (staffjobdescription.getText().equals("Cleaner")) {
                                        Staff s = new Staff(staffFirstName.getText(), staffLastName.getText(), staffEmail.getText(), staffPhoneNumeber.getText(),
                                                LocalDate.parse(staffBirthDate.getText()), staffFirstName.getText() + staffLastName.getText(), staffFirstName.getText() + staffPhoneNumeber.getText(),
                                                staffGender.getText(), staffjobdescription.getText(), LocalDate.parse(staffHiringDate.getText()), staffOfficeNumber.getText());
                                        school.getStaffs().add(s);
                                        JOptionPane.showMessageDialog(null, "New cleaner added!");
                                    } else if (staffjobdescription.getText().equals("Teacher")) {
                                        Teacher s = new Teacher(staffFirstName.getText(), staffLastName.getText(), staffEmail.getText(), staffPhoneNumeber.getText(),
                                                LocalDate.parse(staffBirthDate.getText()), staffFirstName.getText() + staffLastName.getText(), staffFirstName.getText() + staffPhoneNumeber.getText(),
                                                staffGender.getText(), staffjobdescription.getText(), LocalDate.parse(staffHiringDate.getText()), staffOfficeNumber.getText());
                                        school.getTeachers().add((Teacher) s);
                                        JOptionPane.showMessageDialog(null, "New teacher added!");
                                    } else if (staffjobdescription.getText().equals("Principal")) {
                                        Principal s = new Principal(staffFirstName.getText(), staffLastName.getText(), staffEmail.getText(), staffPhoneNumeber.getText(),
                                                LocalDate.parse(staffBirthDate.getText()), staffFirstName.getText() + staffLastName.getText(), staffFirstName.getText() + staffPhoneNumeber.getText(),
                                                staffGender.getText(), staffjobdescription.getText(), LocalDate.parse(staffHiringDate.getText()), staffOfficeNumber.getText());
                                        school.setPrincipal((Principal) s);
                                    } else if (staffjobdescription.getText().equals("HR")) {
                                        HR s = new HR(staffFirstName.getText(), staffLastName.getText(), staffEmail.getText(), staffPhoneNumeber.getText(),
                                                LocalDate.parse(staffBirthDate.getText()), staffFirstName.getText() + staffLastName.getText(), staffFirstName.getText() + staffPhoneNumeber.getText(),
                                                staffGender.getText(), staffjobdescription.getText(), LocalDate.parse(staffHiringDate.getText()), staffOfficeNumber.getText());
                                        school.getHrs().add((HR) s);
                                        JOptionPane.showMessageDialog(null, "New HR added!");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Incorrect job description entered");
                                    }
                                }
                            } catch (NumberFormatException | DateTimeParseException | IndexOutOfBoundsException e) {
                                JOptionPane.showMessageDialog(null, "Error!");
                            }
                        } 

                        //Remove Staff
                        else if (hrOption == 3) {
                            int staffOption = 10000000;
                            boolean staffChoice = false;
                            do {
                                String names = "";
                                for (int i = 0; i < school.getStaffs().size(); i++) {
                                    names += (i + 1) + ": ";
                                    names += school.getStaffs().get(i).getFirstName();
                                    names += " ";
                                    names += school.getStaffs().get(i).getLastName();
                                    names += "\n";
                                }
                                staffOption = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose class:\n" + names));
                                if (staffOption != 0 && staffOption > 0 && staffOption <= school.getStaffs().size()) {
                                    staffOption--;
                                    staffChoice = true;
                                    school.getStaffs().remove(staffOption);
                                    JOptionPane.showMessageDialog(null, "Staff removed");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Invalid staff chosen.");
                                }
                            } while (!staffChoice);
                        }
                    } while (hrOption != 4);
                }
            } 

            //Teacher---------------------------------------------------
            else if (loginOption == 3) {
                boolean teacherLogin = false;
                int teacherindex = -1;
                JTextField teacherUsername = new JTextField();
                JTextField teacherPassword = new JTextField();
                Object[] teacherData = {"Username:", teacherUsername, "Password:", teacherPassword};
                JOptionPane.showConfirmDialog(null, teacherData, "Teacher login", JOptionPane.OK_CANCEL_OPTION);
                for (int i = 0; i < school.getTeachers().size() && !teacherLogin; i++) {
                    if (Staff.Login(school.getTeachers().get(i), teacherUsername.getText(), teacherPassword.getText())) {
                        teacherLogin = true;
                        teacherindex = i;
                    }
                }
                if (teacherLogin == false) {
                    JOptionPane.showMessageDialog(null, "Wrong teacher username or password entered.");
                } else {
                    JOptionPane.showMessageDialog(null, "Login Succes!");
                    teacherLogin = false;
                    int teacherOption = 10;
                    do {
                        menuChoice = -1;
                        while (menuChoice == -1 || teacherOption <= 0 || (teacherOption != 1 && teacherOption != 2 && teacherOption != 3)) {
                            if (teacherOption <= 0) {
                                JOptionPane.showMessageDialog(null, "Entered negative or zero, please choose a valid option.");
                                teacherOption = 10;
                            }
                            try {
                                teacherOption = Integer.parseInt(JOptionPane.showInputDialog(null, "Select an option:\n1: Add assignment for class.\n2: Change student grade for subject.\n3: Exit menu."));
                                menuChoice = 0;
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "An Exception has occurred, Entered wrong format!");
                            }
                        }

                        //Add assignment for class
                        if (teacherOption == 1) {
                            try {
                                int classOption;
                                boolean classChoice = false;

                                do {
                                    String names = "";
                                    for (int i = 0; i < school.getTeachers().get(teacherindex).getClassrooms().size(); i++) {
                                        names += (i + 1) + ": ";
                                        names += school.getTeachers().get(teacherindex).getClassrooms().get(i).getName();
                                        names += "\n";
                                    }
                                    classOption = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose class to add assignment to:\n" + names));
                                    if (classOption != 0 && classOption > 0 && classOption <= school.getTeachers().get(teacherindex).getClassrooms().size()) {
                                        classOption--;
                                        classChoice = true;
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Invalid class chosen.");
                                    }
                                } while (!classChoice);

                                JTextField assignmentdescriotion = new JTextField();
                                JTextField assignmentduedate = new JTextField();
                                Object[] assignmentData = {"Assugnment descriotion:", assignmentdescriotion, "Assignment due date(YYYY-MM-DD):", assignmentduedate};
                                JOptionPane.showConfirmDialog(null, assignmentData, "Assignment Data", JOptionPane.OK_CANCEL_OPTION);

                                Assignment a = new Assignment(assignmentdescriotion.getText(), LocalDate.parse(assignmentduedate.getText()));

                                for (int i = 0; i < school.getTeachers().get(teacherindex).getClassrooms().get(classOption).getStudents().size(); i++) {
                                    school.getTeachers().get(teacherindex).getClassrooms().get(classOption).getStudents().get(i).addAssignment(a);
                                }
                                JOptionPane.showMessageDialog(null, "Assignment added successfully!");

                            } catch (NumberFormatException | IndexOutOfBoundsException | DateTimeParseException e) {
                                JOptionPane.showMessageDialog(null, "Error!");
                            }
                        }
                        
                        //Change grade for student
                        else if (teacherOption == 2){
                            try{
                                int classOption, studentOption;
                                boolean classChoice = false, studentChoice = false;

                                do {
                                    String names = "";
                                    for (int i = 0; i < school.getTeachers().get(teacherindex).getClassrooms().size(); i++) {
                                        names += (i + 1) + ": ";
                                        names += school.getTeachers().get(teacherindex).getClassrooms().get(i).getName();
                                        names += "\n";
                                    }
                                    classOption = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose class to add assignment to:\n" + names));
                                    if (classOption != 0 && classOption > 0 && classOption <= school.getTeachers().get(teacherindex).getClassrooms().size()) {
                                        classOption--;
                                        classChoice = true;
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Invalid class chosen.");
                                    }
                                } while (!classChoice);
                                
                                do{
                                    String name = "";
                                    for (int i = 0; i < school.getTeachers().get(teacherindex).getClassrooms().get(classOption).getStudents().size(); i++){
                                        name += (i + 1) + ": ";
                                        name += school.getTeachers().get(teacherindex).getClassrooms().get(classOption).getStudents().get(i).getFirstName();
                                        name += " ";
                                        name += school.getTeachers().get(teacherindex).getClassrooms().get(classOption).getStudents().get(i).getLastName();
                                        name += "\n";
                                    }
                                    studentOption = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose student to change grade for:\n" + name));
                                    if (studentOption != 0 && studentOption > 0 && studentOption <= school.getTeachers().get(teacherindex).getClassrooms().get(classOption).getStudents().size()){
                                        studentOption--;
                                        studentChoice = true;
                                    }
                                } while (!studentChoice);
                                
                                int subjectindex = -1;
                                for (int i = 0; i < school.getTeachers().get(teacherindex).getClassrooms().get(classOption).getStudents().get(studentOption).getSubjects().size() && subjectindex == -1; i++){
                                    if (school.getTeachers().get(teacherindex).getClassrooms().get(classOption).getStudents().get(studentOption).getSubjects().get(i).getTeacher()
                                            == school.getTeachers().get(teacherindex)){
                                        subjectindex = i;
                                    }
                                }
                                
                                double newGrade = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter new Grade: "));
                                
                                if (newGrade >= 0 && newGrade <= 100) {
                                    school.getTeachers().get(teacherindex).changeStudentSubjectGrade(school.getTeachers().get(teacherindex).getClassrooms().get(classOption),
                                            school.getTeachers().get(teacherindex).getClassrooms().get(classOption).getStudents().get(studentOption),
                                            newGrade, subjectindex);

                                    JOptionPane.showMessageDialog(null, "Grade changed!");
                                } else{
                                    JOptionPane.showMessageDialog(null, "Invalid grade entered");
                                }
                            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                                JOptionPane.showMessageDialog(null, "Error!");
                            }
                        }
                    } while (teacherOption != 3);
                }
            } 

            //Student-------------------------------------------------
            else if (loginOption == 4) {
                boolean studentLogin = false;
                int studentindex = -1;
                JTextField studentUsername = new JTextField();
                JTextField studentPassword = new JTextField();
                Object[] studentData = {"Username:", studentUsername, "Password:", studentPassword};
                JOptionPane.showConfirmDialog(null, studentData, "Teacher login", JOptionPane.OK_CANCEL_OPTION);
                for (int i = 0; i < school.getStudents().size() && !studentLogin; i++) {
                    if (studentUsername.getText().equals(school.getStudents().get(i).getUsername()) && studentPassword.getText().equals(school.getStudents().get(i).getPassword())) {
                        studentLogin = true;
                        studentindex = i;
                    }
                }
                if (studentLogin == false) {
                    JOptionPane.showMessageDialog(null, "Wrong teacher username or password entered.");
                } else {
                    JOptionPane.showMessageDialog(null, "Login Succes!");
                    studentLogin = false;
                    int studentOption = 10;
                    do {
                        try {
                            menuChoice = -1;
                            while (menuChoice == -1 || studentOption <= 0 || (studentOption != 1 && studentOption != 2 && studentOption != 3)) {
                                if (studentOption <= 0) {
                                    JOptionPane.showMessageDialog(null, "Entered negative or zero, please choose a valid option.");
                                    studentOption = 10;
                                }
                                try {
                                    studentOption = Integer.parseInt(JOptionPane.showInputDialog(null, "Select an option:\n1: View assignments.\n2: Calculate total percentage.\n3: Exit menu."));
                                    menuChoice = 0;
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null, "An Exception has occurred, Entered wrong format!");
                                }
                            }
                            
                            // View assignments
                            if (studentOption == 1){
                               String data = "";
                               school.getStudents().get(studentindex).viewAssignments();
                            }
                            
                            //Calculate total Percentage
                            else if (studentOption == 2){
                                JOptionPane.showMessageDialog(null, Student.calcTotalPercentage(school.getStudents().get(studentindex)));
                            }
                        } catch (NumberFormatException | IndexOutOfBoundsException e) {
                            JOptionPane.showMessageDialog(null, "Error!");
                        }
                    } while (studentOption != 3);
                }
            }
            loginOption = 10;
        } while (menu != 2);

        //Saving files
        if (!school.getStaffs().isEmpty())
            school.saveStaffData();
        if (!school.getStudents().isEmpty())
            school.saveStudentData();
        if (!school.getTeachers().isEmpty())
            school.saveTeachersData();
        if (school.getPrincipal().getFirstName() != null)
            school.savePrincipalData();
        if (!school.getHrs().isEmpty())
            school.saveHRData();
        if (!school.getClassrooms().isEmpty())
            school.saveClassrooms();
    }
}