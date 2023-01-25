package Humen.Person.Traveler;

import Humen.Person.Person;
import Humen.Person.KeyManage.Key;
import Place.Hotel.Rooms.Room;

public class Travelers extends Person implements CanPay, CanReserveRoom {

    // traveler's info
    // aggregation relation of key for traveler
    protected Key key;
    protected Room room;
    protected int travelerCount;
    protected String job;
    protected Double travellerWallet;
    protected int travelAmountOfDays;
    // composition relation of Marriage and reservation state for traveler
    // maybe the trveler declare their marieage state wrong and want to edit it so
    // its not immutable
    protected MarriegeState marriegeState;
    protected ReservationState reserveState;

    public Travelers(String firstName, String lastName, String nationalCode, String phone, int age, int travelerCount,
            Double travellerWallet) throws Exception {
        super(firstName, lastName, nationalCode);
        // for reservation money amount should be more than 500 dollars
        if (travellerWallet >= 500) {
            this.travellerWallet = travellerWallet;
        } else {
            throw new Exception("Money Amount LOW");
        }
        if (travelerCount > 0) {
            this.travelerCount = travelerCount;
        } else {
            throw new Exception("Why are you reserving for no one");
        }
        super.setAge(age);
        super.setPhone(phone);
    }

    // setters
    public void setKey(Key key) {
        this.key = key;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setTravelDays(int travelAmountOfDays) {
        this.travelAmountOfDays = travelAmountOfDays;
    }

    public void setMarriegeState(MarriegeState marriegeState) {
        this.marriegeState = marriegeState;
    }

    public void setReserveState(ReservationState reserveState) {
        this.reserveState = reserveState;
    }

    // getters
    public Key getKey() {
        return key;
    }

    public Room getRoom() {
        return room;
    }

    public int getTravelCount() {
        return travelerCount;
    }

    public Double getWalet() {
        return travellerWallet;
    }

    public String getJob() {
        return job;
    }

    public int getTravelDays() {
        return travelAmountOfDays;
    }

    public MarriegeState getMarriageState() {
        return marriegeState;
    }

    public ReservationState getreserveState() {
        return reserveState;
    }

    public ReservationState statusToReserved() {
        return ReservationState.RESERVED;
    }

    public void statusToNotReserved() {
        setReserveState(ReservationState.NOT_RESERVED);
    }

    public void statusToPending() {
        setReserveState(ReservationState.PENDING);
    }

    // after pay the wallet is updated
    public void updateWallet(Double travellerWallet) {
        this.travellerWallet = travellerWallet;
    }

    @Override
    public String toString() {
        String s;
        s = ("First name: " + firstName + "   Last Name: " + lastName + "   National Code: "
                + String.valueOf(nationalCode)
                + "   Traveler Count: " + travelerCount + "   Age : " + age + "   Gender:" + this.getGender());
        return s;
    }

    @Override
    public boolean equals(Object other) {
        Travelers guy = (Travelers) other;
        if (this.firstName.equals(guy.firstName) && this.lastName.equals(guy.lastName)
                && String.valueOf(this.nationalCode).equals(String.valueOf(guy.nationalCode))
                && this.age == guy.age && this.phone.equals(guy.phone) && this.travelerCount == guy.travelerCount
                && this.travellerWallet.equals(guy.travellerWallet) && this.getGender().equals(guy.getGender())
                && this.getMarriageState().equals(guy.getMarriageState())) {
            return true;
        }
        return false;
    }

    // implement of interfaces
    @Override
    public ReservationState reserve(ReservationState reserveStatus) {
        return this.reserveState = reserveStatus;
    }

    @Override
    public Double pay(Double newWallet, Double price) {
        return newWallet -= price;
    }
}
