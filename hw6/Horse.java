import java.util.Objects;

public class Horse extends Animal {
    private int age;
    final private String color;

    public Horse(String name, int age, String food, String location, String color) {
        super(name, food, location);
        this.age = age;
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void makeNoise() {
        if (color.equals("black")) {
            super.makeNoise();
        } else {
            System.out.println(getName() + " isn't making noise");
        }
    }

    @Override
    public void eat() {
        if (age <= 2) {
            super.eat();
        } else {
            System.out.println(getName() + " eats every 6 hours.");
        }
    }

    @Override
    public String toString() {
        return "Horse{" +
                "name = " + getName() +
                ", age = " + age +
                ", color = " + getColor() +
                ", location = " + getLocation() +
                "}.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return Objects.equals(super.getName(), horse.getName()) && 
                age == horse.age &&
                Objects.equals(color, horse.color) && 
                Objects.equals(super.getLocation(), horse.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getName(), age, color, super.getLocation());
    }
}
