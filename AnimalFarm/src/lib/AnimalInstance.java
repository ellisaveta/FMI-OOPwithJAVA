package lib;

public class AnimalInstance {
    private int animalKey;
    private String animalName;
    private int animalAge;
    public final String INSTANCE_ID;
    private static int cnt = 1;

    public AnimalInstance(int animalKey, String animalName, int animalAge) {
        setAnimalKey(animalKey);
        setAnimalName(animalName);
        setAnimalAge(animalAge);
        INSTANCE_ID = String.format("%s  %03d", animalName, cnt++);
    }

    public int getAnimalKey() {
        return animalKey;
    }

    public void setAnimalKey(int animalKey) {
        this.animalKey = animalKey;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        if(animalName != null) {
            this.animalName = animalName;
        }
        else {
            this.animalName = "No name";
        }
    }

    public int getAnimalAge() {
        return animalAge;
    }

    public void setAnimalAge(int animalAge) {
        this.animalAge = animalAge;
    }

    @Override
    public String toString() {
        return String.format("%s, Възраст: %d", INSTANCE_ID, animalAge);
    }
}
