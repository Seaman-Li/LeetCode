package Java_basic.PlantsVSZombies.Plants;

import Java_basic.PlantsVSZombies.Zombies.Zombie;

public abstract class Plant {
    //Using protected for fields in an abstract class is especially useful in cases where behavior defined in methods of a subclass needs to manipulate or rely on the internal state defined by the superclass.
    //Subclass Accessibility: Protected members are accessible within the same package and by subclasses even if they are in different packages while Private members are completely hidden from other classes, including subclasses.
    //Encapsulation with Flexibility: While protected still restricts access compared to public, it provides more flexibility than private by allowing subclass methods to operate directly on these fields.
    //Facilitates Polymorphism:By allowing subclasses to access superclass fields directly, protected enables more sophisticated polymorphic behaviors. Subclasses can redefine or extend the behavior of superclass methods with direct access to necessary data fields, facilitating a more cohesive and integrated behavior modification. For example, Sunflower can't attack and implementation of attack() function is produceSun()
    protected int health;
    protected int cost;
    protected String plantType;

    public Plant(int health, int cost, String plantType) {
        this.health = health;
        this.cost = cost;
        this.plantType = plantType;
    }

    public abstract void attack(Zombie zombie);

    public void takeDamage(int damage) {
        this.health -= damage;
    }
}

//Encapsulation: Each plant type wraps its own data and behaviors, making the code easier to manage and extend.
//Abstraction: The game interacts with all types of plants through a common interface, simplifying the code that manages the plants.
//Inheritance: Common features are defined in the Plant class and inherited by specific plant types, promoting code reuse.
//Polymorphism: The game can treat all plants uniformly, even as they perform actions specific to their plant type during the attack method.
