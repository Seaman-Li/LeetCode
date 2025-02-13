package Java_basic.PlantsVSZombies.Plants;
import Java_basic.PlantsVSZombies.Zombies.Zombie;

public class Peashooter extends Plant {
    private int attackDamage;

    public Peashooter(int health, int cost, int attackDamage) {
        super(health, cost, "Peashooter");
        this.attackDamage = attackDamage;
    }

    @Override
    public void attack(Zombie zombie) {
        zombie.takeDamage(attackDamage);
        System.out.println("Peashooter dealing " + attackDamage + " damage to zombie.");
    }
}

