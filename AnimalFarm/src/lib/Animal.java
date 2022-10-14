package lib;

public class Animal {
    private String name;
    private AnimalType animalType;
    private MorphType morphType;
    private boolean predator;

    public Animal(String name, AnimalType animalType, MorphType morphType, boolean predator) {
        setName(name);
        setAnimalType(animalType);
        setMorphType(morphType);
        setPredator(predator);
    }

    public Animal(Animal other)
    {
        if(other != null) {
            setName(other.getName());
            setAnimalType(other.getAnimalType());
            setMorphType(other.getMorphType());
            setPredator(other.isPredator());
        }
        else {
            setName(null);
            setAnimalType(null);
            setMorphType(null);
            setPredator(false);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null) {
            this.name = name;
        }
        else {
            this.name = "Unknown name";
        }
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        if(animalType != null) {
            this.animalType = animalType;
        }
        else {
            this.animalType = AnimalType.BOZAINIK;
        }
    }

    public MorphType getMorphType() {
        return morphType;
    }

    public void setMorphType(MorphType morphType) {
        if(morphType != null) {
            this.morphType = morphType;
        }
        else {
            this.morphType = MorphType.ЕARTH;
        }
    }

    public boolean isPredator() {
        return predator;
    }

    public void setPredator(boolean predator) {
        this.predator = predator;
    }

    @Override
    public String toString() {
        return String.format("Животно{  %s, тип=    %s, морфология=    %s, хищник=  %s}",
                name, animalType.getTypeName(), morphType.getTypeName(), predator ? "Да" : "Не");
    }

}
