package Place.Hotel;

import Humen.Person.Personnele.Personnele;
import Humen.Person.Traveler.Travelers;
import Place.Hotel.Features.HotelFeatures;
import Place.Hotel.Rooms.Room;

public class Hotel {
    // thease are belonged to hotel and not a specific object thats why they are
    // static
    private static final String HOTEL_NAME = "SunMoon";
    private static final String HOTEL_REGISTER_NUM = "Fr158236";
    private static final String HOTEL_ADDRESS = "France, Paris, Shanzelizei st";
    private static final int HOTEL_FLOORS = 10;
    private static final int TRAVELER_CAPACITY = 20;

    private static final int MAX_ROOMS = 100;
    private static final int MAX_PERSONNELE = 30;
    // my Hotel has rooms features and people and needs the access
    private static Room[] room = new Room[MAX_ROOMS];
    private static Personnele[] person = new Personnele[MAX_PERSONNELE];
    private static int roomCount = 0;
    private static int personneleCount = 0;

    // Hotel has a hotel feature and visitors but still remains a hotel without it
    // so its aggregration
    private HotelFeatures hotelFeature;
    private Travelers travelers;

    public Hotel() {
    }

    // setter
    public void setFeatures(HotelFeatures features) {
        this.hotelFeature = features;
    }

    public void setTraveler(Travelers travelers) {
        this.travelers = travelers;
    }

    // getters
    public HotelFeatures getFeatures() {
        return hotelFeature;
    }

    public Travelers getTraveler() {
        return travelers;
    }

    public static int getTRAVELER_CAPACITY() {
        return TRAVELER_CAPACITY;
    }

    public static int getMAX_ROOMS() {
        return MAX_ROOMS;
    }

    public static int getMAX_PERSONNELE() {
        return MAX_PERSONNELE;
    }

    public static Room[] getRoom() {
        return room;
    }

    public static Personnele[] getPersonnele() {
        return person;
    }

    public static void addRoom(Room r) {
        room[roomCount++] = r;
    }

    public static void addPersonnele(Personnele p) {
        person[personneleCount++] = p;
    }

    public static void getHotelInfo() {
        System.out.print('\n' + "-------********-------" + '\n');
        System.out.println("  You Are So Welcomed In Our Six Star Hotel  ");
        System.out
                .println("Hotel Name:   " + HOTEL_NAME + "  Hotel Address:   " + HOTEL_ADDRESS + "  RegisterNumber:   "
                        + HOTEL_REGISTER_NUM + "  With " + HOTEL_FLOORS + "  Floors" + '\n');
    }
}
