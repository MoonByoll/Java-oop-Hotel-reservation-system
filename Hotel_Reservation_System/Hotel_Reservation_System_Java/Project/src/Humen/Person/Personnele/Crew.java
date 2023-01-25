package Humen.Person.Personnele;

public class Crew extends Personnele {

    private char[] crewId;
    private String crewChore;

    public Crew(String firstName, String lastName, String nationalCode, String crewId, String crewChore)
            throws Exception {
        super(firstName, lastName, nationalCode, crewId);
        this.crewChore = crewChore;
    }

    // getters
    public String getChores() {
        return crewChore;
    }

    @Override
    public char[] getPersonneleId() {
        return crewId;
    }

    @Override
    public String toString() {
        String s;
        s = ("first name: " + firstName + "   Last Name: " + lastName + "   Chore: " + String.valueOf(crewChore)
                + "   Personnele Code: " + String.valueOf(personneleId) + "   The Crew is now " + status);
        return s;
    }
}
