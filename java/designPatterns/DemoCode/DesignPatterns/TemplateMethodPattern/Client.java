package DesignPatterns.TemplateMethodPattern;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Client {

    public static void main(String[] args) throws Exception {
        System.out.println("-----H1 hummer----------");
        System.out.println("input a number: 0 or 1");
        String type = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        HummerH1Model h1 = new HummerH1Model();
        if (type.equals("0")) {
            h1.setAlarm(false);
        }
        h1.run();
        System.out.println("-----H2 hummer----------");
        HummerH2Model h2 = new HummerH2Model();
        h2.run();
    }

}