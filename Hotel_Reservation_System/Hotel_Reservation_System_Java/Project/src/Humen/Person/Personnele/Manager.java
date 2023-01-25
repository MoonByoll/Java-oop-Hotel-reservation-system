package Humen.Person.Personnele;

public class Manager extends Personnele {

    // any manager no matter if changed , they all have same contact info
    public static final String MANAGER_ID = "M116";
    public static final int ROOM_NUMBER = 140;
    public static final String MANAGER_EMAIL = "ManagerM1165@gmail.com";

    // beacuse manager id is final and initialized before, dont need it in
    // constructor arguments
    public Manager(String firstName, String lastName, String nationalCode) throws Exception {
        super(firstName, lastName, nationalCode, MANAGER_ID);
    }

    public void contactManager() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        String s;
        s = ("first name: " + firstName + "   Last Name: " + lastName + "   Manager Id: "
                + String.valueOf(MANAGER_ID) + "   Manager room number: " + ROOM_NUMBER + "   Manager Email: "
                + MANAGER_EMAIL);
        return s;
    }

}
