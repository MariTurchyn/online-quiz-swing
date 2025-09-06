package model;

/** Quiz categories available in the app. */
public enum Category {
    CAPITALS("World Capitals"),
    CURRENCIES("National Currencies"),
    LANGUAGES("Official Languages"),
    FLAGS("National Flags"),
    CONTINENTS("Continents");

    private final String displayName;

    Category(String displayName) { this.displayName = displayName; }

    public String displayName() { return displayName; }
}
