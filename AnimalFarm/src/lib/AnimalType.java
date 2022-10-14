package lib;

public enum AnimalType {
    BOZAINIK("Бозайник"),
    PTICA("Птица"),
    BEZGRABNACHNO("Безгръбначно"),
    VLECHUGO ("Влечуго"),
    RIBA("Риба");

    private final String typeName;

    AnimalType(String typeName) {
        if(typeName != null) {
            this.typeName = typeName;
        }
        else {
            this.typeName = "Бозайник";
        }
    }

    public String getTypeName() {
        return typeName;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", AnimalType.valueOf(typeName), typeName);
    }
}
