public class Pants extends Clothes implements MenClothes, WomenClothes {

    public Pants(Size size, int price, String color) {
        super(size, price, color);
    }

    @Override
    public String dressMan() {
        return "Man pants: size - " + size + " - " + size.getEuroSize(size) + " (" + size.getDescription(size) +
                "), price - " + price +
                ", color - " + color +
                ".";
    }

    @Override
    public String dressWoman() {
        return "Woman pants: size - " + size + " - " + size.getEuroSize(size) + " (" + size.getDescription(size) +
                "), price - " + price +
                ", color - " + color +
                ".";
    }
}
