package beakjoon;

import java.io.IOException;

/**
 * Created by ds on 2020/08/30.
 */

public class Main {

    public static void main(String... args) throws IOException {
        String instanceId = "a_e6z";
        long receiverUid = Long.parseLong(instanceId.replaceFirst("a_", ""), Character.MAX_RADIX);
        System.out.println(receiverUid);

        System.out.println(calcChunkSize(300, SPEED.MIDDLE));

    }

    public static int calcChunkSize(int chunkSize, SPEED speed) {
        System.out.println(speed.ordinal());
        return (int) (chunkSize * (Math.pow(3, speed.ordinal()) / 3));
    }

    public static enum SPEED {
        LOW, MIDDLE, HIGH;

        public static SPEED parse(int speedLevel) {
            for (SPEED speed : SPEED.values()) {
                if (speed.ordinal() == speedLevel) {
                    return speed;
                }
            }
            return LOW;
        }
    }

}