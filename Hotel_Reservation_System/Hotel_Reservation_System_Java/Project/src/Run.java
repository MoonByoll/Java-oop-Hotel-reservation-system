import java.util.*;

import Humen.Person.Gender;
import Humen.Person.Personnele.*;
import Humen.Person.Traveler.*;
import Place.Hotel.*;
import Place.Hotel.Features.*;
import Place.Hotel.Rooms.*;

public class Run {

    public static Travelers reservationSection(Travelers traveler) throws Exception {

        System.out.println("*****  Welcome to RESERVATION Let Us Guide You : Please fill out the FORM *****");
        Scanner scan = new Scanner(System.in);
        System.out.println("*****  Enter FirstName :  *****");
        String firstName = scan.nextLine();
        System.out.println("*****  Enter LastName :  *****");
        String lastName = scan.nextLine();
        System.out.println("*****  Enter Your Gender 1.MALE / 2.FEMALE:  *****");
        int c = scan.nextInt();
        scan.nextLine();
        switch (c) {
            case 1:
                traveler.setGender(Gender.MALE);
                break;
            case 2:
                traveler.setGender(Gender.FEMALE);
                break;
        }
        System.out.println("*****  Enter 6 digit NationalCode :  *****");
        String nationalCode = scan.nextLine();
        System.out.println("*****  Enter Valied 11 digit Phone :  *****");
        String phone = scan.nextLine();
        System.out.println("*****  Enter Age :  *****");
        int age = scan.nextInt();
        System.out.println("*****  How Many People Are you in Travel? :  *****");
        int travelerCount = scan.nextInt();
        System.out.println("*****  Enter your amount of Money (more than 500 Dollars) :  *****");
        Double travellerWallet = scan.nextDouble();
        System.out.println("*****  Set Your Marriage State with number :  *****");
        System.out.println("1.Married    2.Engaged    3.Singel");
        MarriegeState status;
        int condition = scan.nextInt();
        switch (condition) {
            case 1:
                status = MarriegeState.MARRIED;
                traveler.setMarriegeState(status);
                break;
            case 2:
                status = MarriegeState.ENGAGED;
                traveler.setMarriegeState(status);
                break;
            case 3:
                status = MarriegeState.SINGEL;
                traveler.setMarriegeState(status);
                break;
        }

        System.out.println("*****  Are you a STUDENT? y/n  *****");
        String condition2 = scan.next();

        switch (condition2) {
            case "y":
                Student studentTraveler = new Student(firstName, lastName, nationalCode, phone, age, travelerCount,
                        travellerWallet);
                studentTraveler.setGender(traveler.getGender());
                studentTraveler.setMarriegeState(traveler.getMarriageState());
                System.out.println("*****  Enter 5 digit Student id for Varification : *****");
                String studentId = scan.next();
                studentTraveler.setStudentId(studentId);
                System.out.println("*****  CONGRAGTS; YOU OWN 20% HOTEL DISCOUNT  *****");
                System.out.println(studentTraveler.toString());
                System.out.println("*****  Wanna Continue? y/n/cancel *****");
                String condition3 = scan.next();
                switch (condition3) {
                    case "y":
                        System.out.println("***** Lets reserve a room *****");
                        Double newWallet = studentTraveler.pay(studentTraveler.getWalet(),
                                reserveRoom(studentTraveler) * 0.8);
                        studentTraveler.updateWallet(newWallet);
                        System.out.println(
                                "***** Reservation SUCCESFUL your wallet is now:  " + studentTraveler.getWalet()
                                        + " Dollars");
                        System.out.println("Congracts Your reservation Status is:  "
                                + studentTraveler.reserve(studentTraveler.statusToReserved()));
                        return studentTraveler;
                    case "n":
                        studentTraveler.statusToPending();
                        System.out.println("*****  resrvation Pending, we will wait for your decision  *****");
                        break;
                    case "cancel":
                        studentTraveler.statusToNotReserved();
                        System.out.println("*****  resrvation Canceled  *****");
                        System.exit(0);
                }
                break;

            case "n":
                AveragePeople normalTraveler = new AveragePeople(firstName, lastName, nationalCode, phone, age,
                        travelerCount, travellerWallet);
                normalTraveler.setGender(traveler.getGender());
                normalTraveler.setMarriegeState(traveler.getMarriageState());
                System.out.println("*****  SO SORRY; YOU OWN NO HOTEL DISCOUNT  *****");
                System.out.println("*****  Please Declare your JOB *****");
                String job = scan.next();
                normalTraveler.setJob(job);
                System.out.println(normalTraveler.toString());
                System.out.println("*****  Wanna Continue? y/n/cancel *****");
                String condition4 = scan.next();
                switch (condition4) {
                    case "y":
                        System.out.println("*****  Lets reserve a room *****");
                        Double newWallet = normalTraveler.pay(normalTraveler.getWalet(), reserveRoom(normalTraveler));
                        normalTraveler.updateWallet(newWallet);
                        System.out.println(
                                "***** Reservation SUCCESFUL your wallet is now:  " + normalTraveler.getWalet()
                                        + " Dollars");
                        System.out.println("Congracts Your reservation Status is :  "
                                + normalTraveler.reserve(normalTraveler.statusToReserved()));
                        return normalTraveler;
                    case "n":
                        normalTraveler.statusToPending();
                        System.out.println("*****  resrvation Pending, we will wait for your decision  *****");
                        break;
                    case "cancel":
                        normalTraveler.statusToNotReserved();
                        System.out.println("*****  resrvation Canceled  *****");
                        System.exit(0);
                }
                break;
        }
        return traveler;
    }

    public static Double reserveRoom(Travelers travelers) {
        double totalPrice = 0;
        System.out.println("*****  Choose the bedtype in case of 1 to 5  *****");
        BedType[] bedType = BedType.values();
        int i = 0;
        int bedPrice = 10;
        for (BedType b : bedType) {
            System.out.println(++i + ". " + b + "  " + bedPrice + "  Dollars per night  ");
            bedPrice += 5;
        }
        Scanner scan = new Scanner(System.in);
        int condition = scan.nextInt();
        switch (condition) {
            case 1:
                Room.setBedType(BedType.SINGEL);
                totalPrice = 10;
                break;
            case 2:
                Room.setBedType(BedType.DOUBLE);
                totalPrice = 15;
                break;
            case 3:
                Room.setBedType(BedType.QUEEN);
                totalPrice = 20;
                break;
            case 4:
                Room.setBedType(BedType.KING);
                totalPrice = 25;
                break;
            case 5:
                Room.setBedType(BedType.STUDIO);
                totalPrice = 30;
                break;
            case 6:
                Room.setBedType(BedType.TRIPLE);
                totalPrice = 35;
                break;
        }

        System.out.println("*****  Choose the Roomtype in case of 1 to 4  *****");
        RoomType[] roomType = RoomType.values();
        int j = 0;
        int viewPrice = 20;
        for (RoomType r : roomType) {
            System.out.println(++j + ". " + r + "   " + viewPrice + "  Dollars per night  ");
            viewPrice += 5;
        }
        int condition2 = scan.nextInt();
        switch (condition2) {
            case 1:
                Room.setRoomType(RoomType.NO_VIEW);
                totalPrice += 20;
                break;
            case 2:
                Room.setRoomType(RoomType.STREET_VIEW);
                totalPrice += 25;
                break;
            case 3:
                Room.setRoomType(RoomType.RIVER_VIEW);
                totalPrice += 30;
                break;
            case 4:
                Room.setRoomType(RoomType.JUNGEL_VIEW);
                totalPrice += 35;
                break;
        }
        System.out.println(" Total Price is :  " + totalPrice);
        Room room = new Room(Room.getBedType(), Room.getRoomType());
        travelers.setRoom(room);
        return totalPrice;
    }

    public static void hotelInformation() throws Exception {
        Hotel.getHotelInfo();
        System.out.println("*****  Welcome to INFORMATION Let Us Guide You  *****");
        System.out.println("*****  1. I want to know about the Staff  *****");
        System.out.println("*****  2. I want to know about the Features  *****");
        System.out.println("*****  3. Back *****");
        Scanner scan = new Scanner(System.in);
        int condition = scan.nextInt();
        switch (condition) {
            case 1:
                staffManage();
                break;
            case 2:
                featureManage();
                break;
            case 3:
                break;
        }
    }

    private static void staffManage() throws Exception {

        System.out.println("*****  Welcome to Staff Info Let Us Guide You  *****");
        System.out.println("*****  1. I want to know about the Crew  *****");
        System.out.println("*****  2. I want to know about the Receptionist  *****");
        System.out.println("*****  3. I want to Contact Manager  *****");
        System.out.println("*****  4. Back  *****");
        Scanner scan = new Scanner(System.in);
        int condition = scan.nextInt();
        switch (condition) {
            case 1:
                crewmates();
                break;
            case 2:
                receptionist();
                break;
            case 3:
                manager();
                break;
            case 4:
                break;
        }
    }

    private static void crewmates() throws Exception {

        System.out.println('\n' + "*******************************" + '\n');
        List<Crew> crewList = new ArrayList<Crew>();
        String[] names = { "John", "Mel ", "Rose", "Kai ", "Ray ", "Jeff" };
        String[] familyNames = { "Whick  ", "Son    ", "Qiwei  ", "Johnson", "Pick   ", "Doress " };
        String[] nationalId = { "156324", "147589", "326514", "789521", "632514", "789665" };
        String[] chores = { "DoorMan ", "Maiden  ", "Maiden  ", "Driver  ", "Servant ", "Factotum" };
        String[] crewId = { "D155", "M156", "M157", "DR16", "S158", "F200" };
        PersonneleState[] status = { PersonneleState.AVAILABLE, PersonneleState.AVAILABLE, PersonneleState.NOT_AVAILABE,
                PersonneleState.NOT_AVAILABE, PersonneleState.AVAILABLE, PersonneleState.NOT_AVAILABE };
        for (int i = 0; i < 6; i++) {
            Crew crewmates = new Crew(names[i], familyNames[i], nationalId[i], crewId[i], chores[i]);
            crewList.add(crewmates);
            crewmates.setStatus(status[i]);
        }
        for (int i = 0; i < 6; i++) {
            System.out.println(crewList.get(i).toString());
        }
        System.out.println('\n' + "*******************************" + '\n');
    }

    private static void receptionist() throws Exception {

        Scanner scan = new Scanner(System.in);
        System.out.println('\n' + "*******************************" + '\n');
        List<Reseptionist> reseptionList = new ArrayList<Reseptionist>();
        String[] names = { "Adriene", "Robert ", "Christ ", "Sophie ", "Marrine" };
        String[] familyNames = { "Clarck", "Wisoky", "Qubeck", "Ress  ", "Cheng " };
        String[] nationalId = { "506980", "102030", "918273", "556644", "159366" };
        String[] reseptionId = { "R219", "R220", "R221", "R222", "R223" };
        PersonneleState[] status = { PersonneleState.NOT_AVAILABE, PersonneleState.AVAILABLE,
                PersonneleState.NOT_AVAILABE, PersonneleState.AVAILABLE, PersonneleState.AVAILABLE };
        for (int i = 0; i < 5; i++) {
            Reseptionist reseptions = new Reseptionist(names[i], familyNames[i], nationalId[i], reseptionId[i]);
            reseptionList.add(reseptions);
            reseptions.setStatus(status[i]);
        }
        int checkNum = 1;
        for (int i = 0; i < 5; i++) {
            System.out.println(checkNum + ". " + reseptionList.get(i).toString());
            checkNum++;
        }

        System.out.println("In case of 1 to 5 For the receptionists, choose for the language status");
        int condition = scan.nextInt();
        switch (condition) {
            case 1:
                reseptionList.get(1).translate(LanguageState.BI_LINGUAL, names[0]);
                break;
            case 2:
                reseptionList.get(1).translate(LanguageState.MONO_LINGUAL, names[1]);
                break;
            case 3:
                reseptionList.get(1).translate(LanguageState.MONO_LINGUAL, names[2]);
                break;
            case 4:
                reseptionList.get(1).translate(LanguageState.POLY_LINGUAL, names[3]);
                break;
            case 5:
                reseptionList.get(1).translate(LanguageState.POLY_LINGUAL, names[4]);
                break;
        }
        System.out.println('\n' + "*******************************" + '\n');
    }

    private static void manager() throws Exception {
        System.out.println('\n' + "*******************************" + '\n');
        Manager manager = new Manager("Star", "Noir", "785236");
        System.out.println(" >> In Case of Contacting Manager, Use The Info Below  <<");
        manager.contactManager();
        System.out.println('\n' + "*******************************" + '\n');
    }

    private static void featureManage() {

        HotelFeatures features = new HotelFeatures(null);
        System.out.println("*****  Welcome to Features Info Let Us Guide You  *****");
        System.out.println("*****  1. I want to know about the Cinemas  *****");
        System.out.println("*****  2. I want to know about the Pools  *****");
        System.out.println("*****  3. I want to know about the Restaurants  *****");
        System.out.println("*****  4. Back  *****");
        Scanner scan = new Scanner(System.in);
        int condition = scan.nextInt();
        switch (condition) {
            case 1:
                features = new HotelFeatures("Cinema");
                cinemaManage(features);
                break;
            case 2:
                features = new HotelFeatures("Pool");
                poolManage(features);
                break;
            case 3:
                features = new HotelFeatures("Restaurant");
                restaurantManage(features);
                break;
            case 4:
                break;
        }
    }

    private static void cinemaManage(HotelFeatures hotelFeature) {

        Cinema cinemas = new Cinema(null, null, CinemaType.FIVE_DIMENTIONAL);
        System.out.println('\n' + "*******************************" + '\n');
        Scanner scan = new Scanner(System.in);
        List<Cinema> cinemaList = new ArrayList<Cinema>();
        String[] cinemaNames = { "FILEX   Cinema", "REXONE  Cinema", "Amazing Cinema" };
        String[] movieNames = { "SpiderMan, ToyStory4, Mother  ", "Game Over2016, Spy KIds   ",
                "Jourasic Park, RolerCoaster, Ciren Head2" };
        CinemaType[] cinemaTypes = { CinemaType.NORMAL, CinemaType.THREE_DIMENTIONAL, CinemaType.FIVE_DIMENTIONAL };

        for (int i = 0; i < HotelFeatures.getMAX_CINEMAS(); i++) {
            cinemas = new Cinema(cinemaNames[i], movieNames[i], cinemaTypes[i]);
            cinemaList.add(cinemas);
            hotelFeature.addCinema(cinemas);
        }
        for (int i = 0; i < HotelFeatures.getMAX_CINEMAS(); i++) {
            System.out.println(cinemaList.get(i).toString());
        }

        System.out.println("In case of 1 to 3 For the Cinemas, choose for the Cinema Type");
        int condition = scan.nextInt();
        switch (condition) {
            case 1:
                cinemaList.get(0).haveType(cinemaTypes[0], cinemaNames[0]);
                break;
            case 2:
                cinemaList.get(1).haveType(cinemaTypes[1], cinemaNames[1]);
                break;
            case 3:
                cinemaList.get(2).haveType(cinemaTypes[2], cinemaNames[2]);
                break;
        }
        cinemas.ticket();
        System.out.println('\n' + "*******************************" + '\n');
    }

    private static void poolManage(HotelFeatures hotelFeature) {
        Pool pools = new Pool(null, 0);
        System.out.println('\n' + "*******************************" + '\n');
        List<Pool> poolList = new ArrayList<Pool>();
        String[] poolNames = { "SunMoon Pool", "Ocean Park  " };
        int[] numberOfSlides = { 5, 30 };
        for (int i = 0; i < HotelFeatures.getMAX_POOLS(); i++) {
            pools = new Pool(poolNames[i], numberOfSlides[i]);
            poolList.add(pools);
            hotelFeature.addPool(pools);

        }
        for (int i = 0; i < HotelFeatures.getMAX_POOLS(); i++) {
            System.out.println(poolList.get(i).toString());
        }
        pools.ticket();
        System.out.println('\n' + "*******************************" + '\n');
    }

    private static void restaurantManage(HotelFeatures hotelFeature) {
        Restaurant restaurants = new Restaurant(null, 0, RestaurantType.IRANIAN);
        System.out.println('\n' + "*******************************" + '\n');
        Scanner scan = new Scanner(System.in);
        List<Restaurant> restaurantList = new ArrayList<Restaurant>();

        String[] restaurantName = { "Shrimp House  ", "Safdar Kebaby ", "BlackSwan Lake", "Xiaoling Meng ",
                "Wild Cactuses " };
        int[] MaxGuests = { 100, 50, 65, 120, 35 };
        RestaurantType[] restaurantTypes = { RestaurantType.KOREAN, RestaurantType.IRANIAN, RestaurantType.EUROPEAN,
                RestaurantType.CHINEASE, RestaurantType.VEGAN };

        for (int i = 0; i < HotelFeatures.getMAX_RESTAURANT(); i++) {
            restaurants = new Restaurant(restaurantName[i], MaxGuests[i], restaurantTypes[i]);
            restaurantList.add(i, restaurants);
            hotelFeature.addRestaurant(restaurants);
        }
        for (int i = 0; i < HotelFeatures.getMAX_RESTAURANT(); i++) {
            System.out.println(restaurantList.get(i).toString());
        }

        System.out.println("In case of 1 to 5 For the Restaurants, choose for the Restaurant Type");
        int condition = scan.nextInt();
        switch (condition) {
            case 1:
                restaurantList.get(0).haveType(restaurantTypes[0], restaurantName[0]);
                break;
            case 2:
                restaurantList.get(1).haveType(restaurantTypes[1], restaurantName[1]);
                break;
            case 3:
                restaurantList.get(2).haveType(restaurantTypes[2], restaurantName[2]);
                break;
            case 4:
                restaurantList.get(3).haveType(restaurantTypes[3], restaurantName[3]);
                break;
            case 5:
                restaurantList.get(4).haveType(restaurantTypes[4], restaurantName[4]);
                break;
        }
        restaurants.reserve();
        System.out.println('\n' + "*******************************" + '\n');
    }

    public static void main(String[] args) throws Exception {
        Vector<Travelers> travelers = new Vector<Travelers>();
        Travelers traveler = new Travelers("null", "null", "000000", "00000000000", 89, 1, 500.0);
        traveler.setGender(Gender.MALE);
        traveler.setMarriegeState(MarriegeState.SINGEL);
        travelers.add(0, traveler);
        int i = 1;
        while (true) {

            System.out.println('\n' + "***** Hello, Welcome to SunMoon Hotel Application Let Us Guide You *****");
            System.out.println("***** Please Choose an Option with only number : *****");
            System.out.println("1. I want to RESERVE the Hotel");
            System.out.println("2. I want to Check Hotel INFORMATION");
            System.out.println("3. I want to Exit");

            Scanner scan = new Scanner(System.in);
            int condition = scan.nextInt();
            switch (condition) {
                case 1:
                    travelers.add(i, reservationSection(traveler));
                    System.out.println(travelers.get(i).toString() + "\n");
                    if (travelers.get(i).equals(travelers.get(i - 1))) {
                        traveler.setReserveState(ReservationState.NOT_RESERVED);
                        travelers.remove(i);
                        System.out.println(">>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<");
                        System.out.println(">>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<");
                        throw new Exception(
                                "OOPS ******:::::::: Sorry You are already registered, this account is being removed, Try Again Later :::::::******"
                                        + '\n');
                        // else if the reservation is completed add the room
                    } else {
                        Room travelerRoom = new Room(Room.getBedType(), Room.getRoomType());
                        Hotel.addRoom(travelerRoom);
                        i++;
                    }
                    break;
                case 2:
                    hotelInformation();
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }
    }
}