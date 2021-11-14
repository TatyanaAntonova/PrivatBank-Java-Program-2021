public class Skirt extends Clothes implements WomenClothes {

    public Skirt(Size size, int price, String color) {
        super(size, price, color);
    }

    @Override
    public String dressWoman() {
        return "Skirt: size - " + size + " - " + size.getEuroSize(size) + " (" + size.getDescription(size) +
                "), price - " + price +
                ", color - " + color +
                ".";
    }
}
