package Java_basic.PlantsVSZombies.Plants;

import Java_basic.PlantsVSZombies.Zombies.RegularZombie;

import java.util.ArrayList;
import java.util.List;

public class testPlants {
    public static void main(String[] args) {
        List<Plant> garden = new ArrayList<>();
        garden.add(new Sunflower(100, 50, 25));
        garden.add(new Peashooter(100, 100, 20));

        RegularZombie regularZombie = new RegularZombie(100, 2, 20);

        for (Plant plant : garden) {
            plant.attack(regularZombie);  // The specific attack is dependent on the plant type
        }

    }
}
