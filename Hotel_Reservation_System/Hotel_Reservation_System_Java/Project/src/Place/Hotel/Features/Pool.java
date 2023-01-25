package Place.Hotel.Features;

public class Pool implements NeedTicket {

    private String name;
    // we want to make different objects so slides are not a static variable
    private final int NUMBER_OF_SLIDES;

    public Pool(String name, int numberOfSlides) {
        this.name = name;
        this.NUMBER_OF_SLIDES = numberOfSlides;
    }

    // getters
    public String getName() {
        return name;
    }

    public int getNUMBER_OF_SLIDES() {
        return NUMBER_OF_SLIDES;
    }

    @Override
    public String toString() {
        String s;
        s = ("Pool name: " + name + "    Number Of Slides  " + NUMBER_OF_SLIDES);
        return s;
    }

    @Override
    public void ticket() {
        System.out.println("each Pool requiers ticket for the Entrance");
    }

}
