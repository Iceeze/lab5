package z2;

public class MeowHandler {
    public static void makeAllMeow(Meowable[] meowables) {
        for (Meowable meowable : meowables) {
            meowable.meow();
        }
    }
}
