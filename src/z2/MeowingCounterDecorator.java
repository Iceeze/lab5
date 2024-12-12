package z2;

public class MeowingCounterDecorator implements Meowable {
    private final Meowable cat;
    private int meowCount = 0;

    public MeowingCounterDecorator(Meowable cat) {
        this.cat = cat;
    }

    @Override
    public void meow() {
        cat.meow();  // Вызов метода мяукания
        meowCount++; // Увеличение счетчика мяуканий
    }

    public int getMeowCount() {
        return meowCount;
    }
}
