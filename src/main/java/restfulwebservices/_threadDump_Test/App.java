package restfulwebservices._threadDump_Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created : 2026-08-14 23:04:53
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Application Started ....... ");

        List<User> users = new ArrayList<>();
        for(int i=1;i<=1000;i++){
            users.add(new User());
        }

        System.out.println("Application Ended ....... ");

    }
}
