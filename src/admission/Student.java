package admission;

import java.util.Random;
import java.util.Scanner;

public class Student {
    
    private String name, id, phoneNo, batchCode, dept, email;
    private double cgpa = 0;

    public Student() {
        // Input
        Scanner sc = new Scanner(System.in);
        System.out.println("<--------------Enter Student's Information-------------->");
        System.out.print("Student Name: ");
        name = sc.nextLine();
        System.out.print("Phone Number: ");
        phoneNo = sc.nextLine();
        System.out.print("Batch: ");
        batchCode = sc.nextLine();
        System.out.print("Department: ");
        dept = sc.nextLine();
        dept = dept.toUpperCase();
        sc.close();

        // Initialiazation
        id = generateID();
        email = generateEmail();
        System.out.println("Registration Complete!");
    }
    
    public Student(String name, String phoneNo, String batchCode, String dept) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.batchCode = batchCode;
        this.dept = dept;
    }

    private String getDeptCode() {
        String deptCode = "";
        if ( dept.equals("CSE") ) deptCode = "011";
        else if ( dept.equals("EEE") ) deptCode = "021";
        return deptCode;
    }

    private String deptMail() {
        String dept_mail = "";
        if ( dept.equals("CSE") ) dept_mail = "@bscse.uiu.ac.bd";
        else if ( dept.equals("EEE") ) dept_mail = "@bseee.uiu.ac.bd";
        return dept_mail;
    }
    
    private String generateID() {
        Random rand = new Random();
        Integer x = rand.nextInt(100, 999);
        String roll = x.toString();
        return  getDeptCode() + batchCode + roll;
    }

    private String generateEmail() {
        String words[] = name.split(" ");
        return name.toLowerCase().charAt(0) + words[words.length-1].toLowerCase() + batchCode + id.substring(6) + deptMail();
    }

    public void info() {
        System.out.println("<--------------Student's Information-------------->");
        System.out.println("Name: " + name);
        System.out.println("Student ID: " + id);
        System.out.println("Department: " + dept);
        System.out.println("Phone Number: " + phoneNo);
        System.out.println("Email: " + email);
    }
}
