package Humen.Person.Traveler;

public class Student extends Travelers {

    private char[] studentId;
    private Double studentWallet = travellerWallet;

    public Student(String firstName, String lastName, String nationalCode, String phone, int age, int travelerCount,
            Double studentWallet) throws Exception {
        super(firstName, lastName, nationalCode, phone, age, travelerCount, studentWallet);
    }

    // setters
    // declare student id for discount
    public void setStudentId(String studentId) throws Exception {
        if (studentId.length() == 5) {
            this.studentId = studentId.toCharArray();
        } else {
            throw new Exception("Student ID is not valid!");
        }
    }

    // getters
    public char[] getStudentId() {
        return studentId;
    }

    @Override
    public Double getWalet() {
        return studentWallet;
    }

    @Override
    public void updateWallet(Double studentWallet) {
        this.studentWallet = studentWallet;
    }

    @Override
    public String toString() {
        String s;
        s = ("first name: " + firstName + "   Last Name: " + lastName + "   Student Id: " + String.valueOf(studentId) +
                "   Traveler Count: " + travelerCount + "   Your Wallet Amount: " + studentWallet);
        return s;
    }
}
