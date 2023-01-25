package Humen.Person.Traveler;

public class AveragePeople extends Travelers {

    private Double peopleWallet = travellerWallet;

    public AveragePeople(String firstName, String lastName, String nationalCode, String phone, int age,
            int travelerCount, Double peopleWallet) throws Exception {
        super(firstName, lastName, nationalCode, phone, age, travelerCount, peopleWallet);
    }

    // setter
    // declare the person job
    @Override
    public void setJob(String job) {
        super.setJob(job);
    }

    // getters
    @Override
    public Double getWalet() {
        return peopleWallet;
    }

    @Override
    public String getJob() {
        return super.getJob();
    }

    @Override
    public void updateWallet(Double studentWallet) {
        this.peopleWallet = studentWallet;
    }

    @Override
    public String toString() {
        String s;
        s = ("first name: " + firstName + "   Last Name: " + lastName + "   Job: " + job +
                "   Traveler Count: " + travelerCount + "   Your Wallet Amount: " + peopleWallet);
        return s;
    }
}
