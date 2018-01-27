package modellayer;

public enum Location {
    TIMBER ("Timber"), DIY("Do It Yourself");

    private String name = "";
    private Location(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}