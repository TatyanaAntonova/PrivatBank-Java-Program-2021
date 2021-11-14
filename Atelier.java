public class Atelier {
    public static String dressMan(Clothes[] clothes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Clothes clothes1: clothes){
            if (clothes1 instanceof MenClothes){
                stringBuilder.append(((MenClothes) clothes1).dressMan() + "\n");
            }
        }
        return stringBuilder.toString();
    }

    public static String dressWomen(Clothes[] clothes) {
        StringBuilder stringBuilder = new StringBuilder();
        for(Clothes clothes1: clothes){
            if(clothes1 instanceof WomenClothes){
                stringBuilder.append(((WomenClothes) clothes1).dressWoman() + "\n");
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Clothes[] clothes = {new Skirt(Size.XS, 1000, "red"),
                new Tie(Size.L, 200, "black"),
                new Pants(Size.S, 600, "grey"),
                new Tshirt(Size.XXS, 450, "green")};

        System.out.println(dressMan(clothes));
        System.out.println(dressWomen(clothes));
    }
}
