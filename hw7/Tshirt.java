public class Tshirt extends Clothes implements MenClothes, WomenClothes{

    public Tshirt(Size size, int price, String color) {
        super(size, price, color);
    }

    @Override
    public String dressMan() {
        return "Man Tshirt: size - " + size + " - " + size.getEuroSize(size) + " (" + size.getDescription(size) +
                "), price - " + price +
                ", color - " + color +
                ".";
    }

    @Override
    public String dressWoman() {
        return "Woman Tshirt: size - " + size + " - " + size.getEuroSize(size) + " (" + size.getDescription(size) +
                "), price - " + price +
                ", color - " + color +
                ".";
    }
}
