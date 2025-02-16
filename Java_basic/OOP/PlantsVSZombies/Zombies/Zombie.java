package Java_basic.OOP.PlantsVSZombies.Zombies;
import Java_basic.OOP.PlantsVSZombies.Plants.Plant;

public abstract class Zombie {
    protected int health;
    protected int speed;
    protected String zombieType;

    public Zombie(int health, int speed, String zombieType) {
        this.health = health;
        this.speed = speed;
        this.zombieType = zombieType;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        System.out.println(zombieType + " takes " + damage + " damage, remaining health: " + this.health);
        if (this.health <= 0) {
            System.out.println(zombieType + " is defeated!");
        }
    }

    public abstract void attack(Plant plant);

    public void move() {
        System.out.println(zombieType + " moves forward at speed " + speed);
    }
}

