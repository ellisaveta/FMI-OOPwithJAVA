package app;

import lib.Animal;
import lib.AnimalInstance;
import lib.AnimalType;
import lib.MorphType;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class AnimalStatistics {
    private static Animal[] animals;
    private static List<AnimalInstance> data;

    public AnimalStatistics() {
        data = new ArrayList<>();
        Random random = new Random();
        random = new Random();
        data.add(new AnimalInstance(random.nextInt(50), "Папагал", random.nextInt(100)));
        data.add(new AnimalInstance(random.nextInt(50), "Котка", random.nextInt(100)));
        data.add(new AnimalInstance(random.nextInt(50), "Прасе", random.nextInt(100)));
        data.add(new AnimalInstance(random.nextInt(50), "Динозавър", random.nextInt(100)));
        data.add(new AnimalInstance(random.nextInt(50), "Муха", random.nextInt(100)));
        data.add(new AnimalInstance(random.nextInt(50), "Октопод", random.nextInt(100)));

        animals = new Animal[10];
        animals[0] = new Animal("Лъв", AnimalType.BOZAINIK, MorphType.ЕARTH, true);
        animals[1] = new Animal("Куче", AnimalType.BOZAINIK, MorphType.ЕARTH, false);
        animals[2] = new Animal("Гълъб", AnimalType.PTICA, MorphType.ЕARTH, false);
        animals[3] = new Animal("Змия", AnimalType.VLECHUGO, MorphType.EARTH_WATER, true);
        animals[4] = new Animal("Гущер", AnimalType.VLECHUGO, MorphType.EARTH_WATER, false);
        animals[5] = new Animal("Комар", AnimalType.BEZGRABNACHNO, MorphType.ЕARTH, false);
        animals[6] = new Animal("Пъстърва", AnimalType.RIBA, MorphType.WATER, false);
        animals[7] = new Animal("Акула", AnimalType.RIBA, MorphType.WATER, true);
        animals[8] = new Animal("Делфин", AnimalType.BOZAINIK, MorphType.WATER, false);
        animals[9] = new Animal("Костенурка", AnimalType.VLECHUGO, MorphType.EARTH_WATER, false);
    }

    public static void generateData() {
        data.clear();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int index = random.nextInt(10);
            data.add(new AnimalInstance(index, animals[index].getName(), random.nextInt(5) + 1));
        }
        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
        }
    }

    public static boolean hasManyPredators() {
        long numberOfPredators = data.stream()
                .filter((a) -> animals[a.getAnimalKey()].isPredator())
                .count();
        return numberOfPredators > data.size() - numberOfPredators;
    }

    public static void groupByAnimalCountingInstances() {
        data.stream()
                .collect(Collectors.groupingBy(AnimalInstance::getAnimalKey, Collectors.counting()))
                .forEach((a1, a2) -> System.out.printf("Animal: %s  has %d instances in data.%n",
                        animals[a1].getName(), a2));
    }

    public static String animalWithMinAge()
    {
        int minAge = data.stream()
                .mapToInt(AnimalInstance::getAnimalAge)
                .min()
                .orElse(Integer.MAX_VALUE);
        List<AnimalInstance> minAgeAnimals = data.stream()
                .filter((a) -> a.getAnimalAge() == minAge)
                .collect(Collectors.toList());
        return minAgeAnimals.toString();
    }

    public static void main(String[] args) {
        new AnimalStatistics();
        System.out.println("generateData():");
        generateData();
        System.out.println("\nhasManyPredators():");
        if(hasManyPredators()) {
            System.out.println("There are too many predators!");
        }
        else {
            System.out.println("There are not too many predators!");
        }
        System.out.println("\ngroupByAnimalCountingInstances():");
        groupByAnimalCountingInstances();
        System.out.println("\nanimalWithMinAge():");
        System.out.println(animalWithMinAge());
    }
}
