public class VetClinic {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];
        animals[0] = new Dog("Rex", 10, "meat", "Odessa", false, 555);
        animals[1] = new Horse("Black", 6, "grass", "Poltava", "black");
        animals[2] = new Cat("Garfield", 4, "Purina", "Dnepr", true, 555);

        Veterinarian veterinarian = null;
        try {
            Class tempClass = Class.forName(Veterinarian.class.getName());
            veterinarian = (Veterinarian) tempClass.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println("*********** Check work of superclass. ***********");
        for (Animal animal : animals) {
            veterinarian.treatAnimal(animal);
        }

        System.out.print(System.lineSeparator());

        System.out.println("***** Checking work of subclasses methods. *****");
        System.out.println("*** " + animals[0].getClass() + " is being checked. ***");
        System.out.println(animals[0]);
        animals[0].sleep();
        animals[0].eat();
        animals[0].makeNoise();

        System.out.print(System.lineSeparator());
        System.out.println("*** " + animals[1].getClass() + " is being checked. ***");
        System.out.println(animals[1]);
        animals[1].sleep();
        animals[1].eat();
        animals[2].makeNoise();

        System.out.print(System.lineSeparator());
        System.out.println("*** " + animals[2].getClass() + " is being checked. ***");
        System.out.println(animals[2]);
        animals[2].sleep();
        animals[2].makeNoise();
        animals[2].eat();

        System.out.print(System.lineSeparator());
        System.out.println("*** equals() and hashCode() are being checked. ***");
        System.out.println(animals[0].hashCode() == animals[1].hashCode());
        System.out.println(animals[0].equals(animals[1]));

        Dog testDog = new Dog("Rex", 10, "meat", "Odessa", false, 555);
        if (animals[0].hashCode() == testDog.hashCode()) {
            if (animals[0].equals(testDog))
                System.out.println(animals[0].getName() + " and " + testDog.getName() + " equals.");
        }
    }
}
