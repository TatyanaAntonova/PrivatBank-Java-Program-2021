import java.util.Objects;

public class Cat extends Animal {
    private int age;
    final int chipNumber;
    private boolean fluffy;
    private boolean hungry = true;

    public Cat(String name, int age, String food, String location, boolean fluffy, int chipNumber) {
        super(name, food, location);
        this.age = age;
        this.fluffy = fluffy;
        this.chipNumber = chipNumber;
    }

    public int getAge() {
        return age;
    }

    @Override
    public void makeNoise() {
        if (hungry) {
            super.makeNoise();
        } else {
            System.out.println(this.getName() + " isn't making noise.");
        }
    }

    @Override
    public void eat() {
        super.eat();
        hungry = false;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name = " + getName() +
                ", age = " + age +
                ", hungry = " + hungry +
                ", fluffy = " + fluffy +
                ", location = " + getLocation() +
                "}.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(super.getName(), cat.getName()) && age == cat.age && chipNumber == cat.chipNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getName(), age, chipNumber);
    }
}
