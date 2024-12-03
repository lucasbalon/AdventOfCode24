package day3.part1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Res {
    public static void main(String[] args) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("src/day3/data.txt")));
        Pattern pattern = Pattern.compile("mul\\(\\d{1,3},\\d{1,3}\\)");
        Matcher matcher = pattern.matcher(content);
        ArrayList<String> list = new ArrayList<>();
        int res = 0;

        while (matcher.find()) {
            list.add(matcher.group());
        }

        Pattern pattern1 = Pattern.compile("(\\d{1,3}),(\\d{1,3})");
        Matcher matcher1;
        for (String mul: list) {
            matcher1 = pattern1.matcher(mul);
            if (matcher1.find())
                res += Integer.parseInt(matcher1.group(1)) * Integer.parseInt(matcher1.group(2));
        }
        System.out.println(res);
    }
}
