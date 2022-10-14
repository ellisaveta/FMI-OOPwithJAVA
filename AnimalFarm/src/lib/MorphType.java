package lib;

public enum MorphType {
    ЕARTH("Сухоземно"),
    WATER("Водно"),
    EARTH_WATER("Водно/Сухоземно");

    private final String morphType;

    MorphType(String morphType) {
        if(morphType != null) {
            this.morphType = morphType;
        }
        else {
            this.morphType = "Сухоземно";
        }
    }

    public String getTypeName() {
        return morphType;
    }
}
