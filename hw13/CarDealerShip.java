import java.util.ArrayList;

public class CarDealerShip extends ArrayList {
    boolean isOpen = true;

    @Override
    public void add(int index, Object o) {
        if (super.size() => 5) {
            return;
        }
        super.add(o);
    }

    public boolean isFull() {
        if (super.size() == 5) return true;
        return false;
    }

    public void setOpen() {
        isOpen = !isOpen;
    }

    public boolean isOpen() {
        return isOpen;
    }
}
