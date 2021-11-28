public class NumBox<T extends Number> {
    private final T[] numBoxes;
    private int size = 0;

    public NumBox(int maxArrayLength) {
        numBoxes = (T[]) new Number[maxArrayLength];
    }

    public void add(T num) {
        if (size == numBoxes.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        numBoxes[size] = num;
        size++;
    }

    public T get(int index) {
        if (size == 0) return null;
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return numBoxes[index];
    }

    public int length() {
        return size;
    }

    public double average() {
        if (size == 0) return 0;

        return sum() / size;
    }

    public double sum() {
        if (size == 0) return 0;

        double sum = 0;

        for (int i = 0; i < size; i++) {
            if (numBoxes[i] instanceof Short) {
                sum += numBoxes[i].shortValue();
            } else if (numBoxes[i] instanceof Integer) {
                sum += numBoxes[i].intValue();
            } else if (numBoxes[i] instanceof Long) {
                sum += numBoxes[i].longValue();
            } else if (numBoxes[i] instanceof Double) {
                sum += numBoxes[i].doubleValue();
            } else if (numBoxes[i] instanceof Float) {
                sum += numBoxes[i].floatValue();
            }
        }

        return sum;
    }

    public T max() {
        if (size == 0) {
            return null;
        }

        int indexMaxValue = 0;
        for (int i = 0; i < size; i++) {
            if (numBoxes[indexMaxValue].doubleValue() < numBoxes[i].doubleValue()) {
                indexMaxValue = i;
            }
        }

        return numBoxes[indexMaxValue];
    }
}
