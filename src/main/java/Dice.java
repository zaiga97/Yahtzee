public class Dice {
    private final int FACES;

    public Dice(int faces) {
        if (faces <= 0) throw new ExceptionInInitializerError("Number of dice faces must be positive");
        FACES = faces;
    }

    public int getFaces() {
        return FACES;
    }
}
