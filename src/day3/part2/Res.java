package day3.part2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Res {
    public static void main(String[] args) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("src/day3/data.txt")));
        Pattern pattern = Pattern.compile("mul\\(\\d{1,3},\\d{1,3}\\)|do\\(\\)|don't\\(\\)");
        Pattern pMul = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");
        Matcher matcher = pattern.matcher(content);
        int res = 0;
        boolean state = true;

        while (matcher.find()) {
            String match = matcher.group();

            if (match.equals("do()")) {
                state = true;
            }else if (match.equals("don't()")) {
                state = false;
            } else if (state) {
                Matcher mMul = pMul.matcher(match);
                if (mMul.find()) {
                    res += Integer.parseInt(mMul.group(1)) * Integer.parseInt(mMul.group(2));
                }
            }
        }
        System.out.println(res);
    }
}
