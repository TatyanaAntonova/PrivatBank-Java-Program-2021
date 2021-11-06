public class Veterinarian {
    public void treatAnimal(Animal animal){
        System.out.println(animal.getName() + " usually eats " + animal.getFood() + ".");
        System.out.println(animal.getName() + " lives in " + animal.getLocation() + ".");
    }
}
