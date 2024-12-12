package z2;

public class MeowManager {
    public void makeThemMeow(Meowable[] meowables) {
        for (Meowable meowable : meowables) {
            meowable.meow();
        }
    }
}