package pl.emil7f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class WebReader {

    public static void main(String[] args) throws IOException {

        URL url = new URL("https://www.otodom.pl/sprzedaz/mieszkanie/gliwice/");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
        in.close();


    }
}
