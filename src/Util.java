import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Util {
    final static Random r = new Random();
    public static String makeName(int length){
        return IntStream.generate(Util::makeNumber).limit(length).
                mapToObj(Character::toString).collect(Collectors.joining());
    }
    public static int makeNumber(){return r.nextInt(25)+65;}
}
