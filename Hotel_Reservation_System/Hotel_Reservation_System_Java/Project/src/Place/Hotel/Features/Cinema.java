package Place.Hotel.Features;

public class Cinema implements NeedTicket {
    private String name;
    private String nameOfTheMovie;
    // cinema has a immutable and a must type
    private final CinemaType CINEMA_TYPE;

    public Cinema(String name, String nameOfTheMovie, CinemaType CINEMA_TYPE) {
        this.name = name;
        this.nameOfTheMovie = nameOfTheMovie;
        this.CINEMA_TYPE = CINEMA_TYPE;
    }

    // getters
    public String getName() {
        return name;
    }

    public CinemaType getCINEMA_TYPE() {
        return CINEMA_TYPE;
    }

    public String getMovie() {
        return nameOfTheMovie;
    }

    public void haveType(CinemaType type, String cinemaName) {
        switch (type) {
            case NORMAL:
                System.out.println(cinemaName + ":  ** Is Normall Cinema **");
                break;
            case THREE_DIMENTIONAL:
                System.out.println(cinemaName + ":  ** Is 3D Cinema **");
                break;
            case FIVE_DIMENTIONAL:
                System.out.println(cinemaName + ":  ** Is 5D!!! **");
                break;
        }
    }

    @Override
    public String toString() {
        String s;
        s = ("Cinema name: " + name + "    This week Movies:  " + nameOfTheMovie);
        return s;
    }

    @Override
    public void ticket() {
        System.out.println("Cinema requiers ticket for the Entrance");
    }

}
