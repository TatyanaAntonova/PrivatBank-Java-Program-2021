public class Main {
    public static void main(String[] args) {
        System.out.println("******************* NumBox<Integer> demonstration *******************");
        NumBox<Integer> integerNumBox = new NumBox<Integer>(3);
        System.out.println("The average method for empty array returns: " + integerNumBox.average());
        integerNumBox.add(50);
        integerNumBox.add(5);
        integerNumBox.add(8);
        System.out.println("The get method returns: " + integerNumBox.get(1));
        System.out.println("The length method returns: " + integerNumBox.length());
        System.out.println("The average method returns: " + integerNumBox.average());
        System.out.println("The sum method returns: " + integerNumBox.sum());
        System.out.println("The max method returns: " + integerNumBox.max());

        System.out.println("******************* NumBox<Float> demonstration ******************* ");
        NumBox<Float> floatNumBox = new NumBox<>(5);
        floatNumBox.add(508f);
        floatNumBox.add(-5f);
        floatNumBox.add(-500f);
        System.out.println("The get method returns: " + floatNumBox.get(2));
        System.out.println("The length method returns: " + floatNumBox.length());
        System.out.println("The average method returns: " + floatNumBox.average());
        System.out.println("The sum method returns: " + floatNumBox.sum());
        System.out.println("The max method returns: " + floatNumBox.max());

        System.out.println("******************* NumBox<> demonstration ******************* ");
        NumBox mixedNumBox = new NumBox(5);
        mixedNumBox.add(5);
        mixedNumBox.add(555.5);
        mixedNumBox.add(55.5F);
        System.out.println("The get method returns: " + mixedNumBox.get(2));
        System.out.println("The length method returns: " + mixedNumBox.length());
        System.out.println("The average method returns: " + mixedNumBox.average());
        System.out.println("The sum method returns: " + mixedNumBox.sum());
        System.out.println("The max method returns: " + mixedNumBox.max());
    }
}
