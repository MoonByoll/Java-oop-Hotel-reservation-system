package Humen.Person;

public class Person {

    // what a person needs to be known as a person
    protected String firstName;
    protected String lastName;
    protected char[] nationalCode;
    // aggregration use of enum gender in person
    protected Gender gender;
    protected String phone;
    protected int age;

    public Person(String firstName, String lastName, String nationalCode) throws Exception {
        this.firstName = firstName;
        this.lastName = lastName;
        // the naational code must be 6 digits
        if (nationalCode.length() == 6) {
            this.nationalCode = nationalCode.toCharArray();
        } else {
            throw new Exception("National ID is not valid!");
        }
    }

    // setters
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    // phone must be 11 digits
    public void setPhone(String phone) throws Exception {
        if (phone.length() == 11) {
            this.phone = phone;
        } else {
            throw new Exception("Phone is not valid!");
        }
    }

    // you should be upper 18 in order to reserve in the hotel
    public void setAge(int age) throws Exception {
        if (age >= 18 && age <= 90) {
            this.age = age;
        } else {
            throw new Exception("Sorry You are Under/Upper Age");
        }
    }

    // getters
    public String getName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public char[] getNationalCode() {
        return nationalCode;
    }

    public Gender getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        String s;
        s = ("first name: " + firstName + "   Last Name: " + lastName + "   National Code: "
                + String.valueOf(nationalCode));
        return s;
    }

    // if the person is equal to another person the reservation is canceled and
    // removed
    @Override
    public boolean equals(Object other) {
        Person guy = (Person) other;
        if (this.firstName.equals(guy.firstName) && this.lastName.equals(guy.lastName)
                && String.valueOf(this.nationalCode).equals(String.valueOf(guy.nationalCode))) {
            return true;
        }
        return false;
    }
}
