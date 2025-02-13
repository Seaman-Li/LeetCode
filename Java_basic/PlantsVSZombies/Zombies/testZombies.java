package Java_basic.PlantsVSZombies.Zombies;

import Java_basic.PlantsVSZombies.Plants.Sunflower;

import java.util.ArrayList;
import java.util.List;

public class testZombies {

    public static void main(String[] args) {
        List<Zombie> horde = new ArrayList<>();
        horde.add(new RegularZombie(150, 1, 10));
        horde.add(new ConeheadZombie(250, 1, 15));

        Sunflower sunflower = new Sunflower(100, 20, 2);

        for (Zombie zombie : horde) {
            zombie.move();  // Zombies move towards the plants
            zombie.attack(sunflower);  // Zombies attack the plant they encounter
        }

    }
}
