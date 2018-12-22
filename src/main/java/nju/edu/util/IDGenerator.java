package nju.edu.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class IDGenerator {
    private static final Random seed = new Random();
    private static final char[] code = {'a', 'e', 'f', 'g', 'h', 'i', 'l', 'n', 'o', 'r', 'u', 'v', 'w', 'x', 'y', 'z', '2', '3', '4', '5', '6', '7', '8', '9'};

    private static int num(int min, int max) {
        return min + seed.nextInt(max - min);
    }

    public static char generate() {
        return code[num(0, code.length)];
    }

    public static String generate(String prefix) {
        char[] temp = new char[6];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = generate();
        }
        StringBuffer result = new StringBuffer();
        Random random = new Random();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        result.append(prefix.toUpperCase());
        result.append(sdf.format(Calendar.getInstance().getTime()));
        result.append(new String(temp));
        result.append(random.nextInt(99));
        return result.toString();
    }
}
