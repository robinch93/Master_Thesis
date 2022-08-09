package demo.parser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Globals {
    public static String cwd = System.getProperty("user.dir");

    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yy H:mm");
    static LocalDateTime now = LocalDateTime.now();
    public static String timeNow = dtf.format(now);

}
