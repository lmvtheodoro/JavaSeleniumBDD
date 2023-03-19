package Util;
import java.time.Duration;

//Selenium Behavior Driven-Development Example
//Author: Lucas Magnani Vikar Theodoro
public class Utils {
    static final Duration duration = Duration.ofSeconds(10);
    public static Duration getMaxWaitTime(){
        return duration;
    }
}
