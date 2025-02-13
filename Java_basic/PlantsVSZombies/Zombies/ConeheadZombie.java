package Java_basic.PlantsVSZombies.Zombies;
import Java_basic.PlantsVSZombies.Plants.Plant;

public class ConeheadZombie extends Zombie {
    private int attackPower;

    public ConeheadZombie(int health, int speed, int attackPower) {
        super(health, speed, "Conehead Zombie");
        this.attackPower = attackPower;
    }

    @Override
    public void attack(Plant plant) {
        plant.takeDamage(attackPower);
        System.out.println("Conehead Zombie attacks with power " + attackPower);
    }
}

