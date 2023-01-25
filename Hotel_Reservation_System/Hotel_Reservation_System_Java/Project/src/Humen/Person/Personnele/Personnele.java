package Humen.Person.Personnele;

import Humen.Person.Person;

public class Personnele extends Person {

    // composition relation of personnele availability to personnele
    protected PersonneleState status;
    protected final char[] personneleId;

    public Personnele(String firstName, String lastName, String nationalCode, String personneleId) throws Exception {
        super(firstName, lastName, nationalCode);
        if (personneleId.length() == 4) {
            this.personneleId = personneleId.toCharArray();
        } else {
            throw new Exception("Personnele ID is not valid!");
        }
    }

    // setters
    // see if the specific personnele is available at the moment or not
    public void setStatus(PersonneleState status) {
        this.status = status;
    }

    // getters
    public PersonneleState getStatus() {
        return status;
    }

    public void statusToAvailabe() {
        setStatus(PersonneleState.AVAILABLE);
    }

    public void statusToUnAvailable() {
        setStatus(PersonneleState.NOT_AVAILABE);
    }

    public char[] getPersonneleId() {
        return personneleId;
    }

    @Override
    public String toString() {
        String s;
        s = ("first name: " + firstName + "   Last Name: " + lastName + "   National Code: "
                + String.valueOf(nationalCode)
                + "   Personnele Code: " + String.valueOf(personneleId) + "   The Personnele is now " + status);
        return s;
    }
}
