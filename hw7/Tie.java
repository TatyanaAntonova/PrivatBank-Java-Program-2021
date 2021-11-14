public class Tie extends Clothes implements MenClothes{

    public Tie(Size size, int price, String color) {
        super(size, price, color);
    }

    @Override
    public String dressMan() {
        return "Tie: size - " + size + " - " + size.getEuroSize(size) + " (" + size.getDescription(size) +
                "), price - " + price +
                ", color - " + color +
                ".";
    }
}
