package Java_basic.OOP.PlantsVSZombies.Zombies;

import Java_basic.OOP.PlantsVSZombies.Plants.Plant;

public class RegularZombie extends Zombie {
    private int attackPower;

    public RegularZombie(int health, int speed, int attackPower) {
        super(health, speed, "Regular Zombie");
        this.attackPower = attackPower;
    }

    @Override
    public void attack(Plant plant) {
        plant.takeDamage(attackPower);
        System.out.println("Regular Zombie attacks with power " + attackPower);
    }
}

