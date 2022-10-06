import java.util.Random;

public class Ugg {
    public enum UggRockSize {

        BIGUN(5),
        QUITE_BIGUN(3),
        NOT_SO_BIGUN(1);

        private final int multiplierValue;

        UggRockSize(int multiplierValue) {
            this.multiplierValue = multiplierValue;
        }

        public int getMultiplierValue() {
            return this.multiplierValue;
        }
    }

    public enum UggRockType {

        SPECKILY(7),
        OUCHY_BLACK(20),
        FLOATY(2),
        HOT_HOT_HOT(15);

        private final int multiplierValue;

        UggRockType(int multiplierValue) {
            this.multiplierValue = multiplierValue;
        }

        public int getMultiplierValue() {
            return multiplierValue;
        }
    }

    static class UggRock {
        private final UggRockSize size;
        private final UggRockType type;

        UggRock(UggRockSize s, UggRockType t) {
            this.size = s;
            this.type = t;
        }

        int rockValue() {
            return this.size.getMultiplierValue() * this.type.getMultiplierValue();
        }

        UggRockType getRockType() {
            return this.type;
        }

        UggRockSize getRockSize() {
            return this.size;
        }

        public String getRockInformation() {
            return this.getRockSize().toString() + ", " + this.getRockType().toString();
        }
    }

    static Random randomNumberGen = new Random();

    private static boolean isBetween(double x, double lower, double upper) {
        return lower <= x && x <= upper;
    }

    public UggRock drawRock() {
        int i, j;
        UggRockSize size;
        UggRockType type;
        double number = randomNumberGen.nextDouble();

        if (isBetween(number, 0.0, 6.0 / 9.0)) {
            size = UggRockSize.NOT_SO_BIGUN;
        } else if (isBetween(number, 6.0 / 9.0, 8.0 / 9.0)) {
            size = UggRockSize.QUITE_BIGUN;
        } else {
            size = UggRockSize.BIGUN;
        }

        number = randomNumberGen.nextDouble();
        if (isBetween(number, 0.0, 1.0 / 4.0)) {
            type = UggRockType.SPECKILY;
        } else if (isBetween(number, 1.0 / 4.0, 1.0 / 2.0)) {
            type = UggRockType.FLOATY;
        } else if (isBetween(number, 1.0 / 2.0, 3.0 / 4.0)) {
            type = UggRockType.HOT_HOT_HOT;
        } else {
            type = UggRockType.OUCHY_BLACK;
        }

        return new UggRock(size, type);
    }
}
