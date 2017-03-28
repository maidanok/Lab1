package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Pasha on 23.03.2017.
 */
public class KeyboardController {

    public String getUserInput() {
        String inputLine = null;
        BufferedReader is;
        try {
            is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return "0";
        } catch (IOException e) {
            System.out.println("IOException" + e);
        }
        return inputLine;
    }
}
