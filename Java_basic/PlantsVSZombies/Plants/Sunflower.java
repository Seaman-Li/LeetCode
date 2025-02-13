package Java_basic.PlantsVSZombies.Plants;

import Java_basic.PlantsVSZombies.Zombies.Zombie;

public class Sunflower extends Plant {
    private int sunProductionRate;

    public Sunflower(int health, int cost, int sunProductionRate) {
        super(health, cost, "Sunflower");
        this.sunProductionRate = sunProductionRate;
    }

    @Override
    public void attack(Zombie zombie) {
        // Sunflower doesn't attack; it produces sun points instead.
        produceSun();
    }

    public void produceSun() {
        System.out.println("Producing " + sunProductionRate + " sun points.");
    }
}

