package admission;

public class Student extends Registration {
    private double cgpa;
    private int passedCredit;
    public Student() {
        super();
        cgpa = 3.89;
        passedCredit = 9;
    }

    public void updateCgpa(int credit, double gpa) {
        cgpa = ((cgpa*passedCredit)+(gpa*credit)) / (passedCredit+credit);
        passedCredit += credit;
    }

    public void info() {
        super.info();
        System.out.printf("CGPA: %.2f\n", cgpa);
    }
}
