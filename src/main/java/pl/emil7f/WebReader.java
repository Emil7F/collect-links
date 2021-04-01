package pl.emil7f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class WebReader {

    public static void main(String[] args) throws IOException {

        URL url = new URL("https://www.otodom.pl/sprzedaz/mieszkanie/gliwice/");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream()));
        String inputLine;
        StringBuilder builder = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            builder.append(inputLine);
            builder.append(System.lineSeparator());
        }
        in.close();

        Set<String> links = new HashSet<>();
        String content = builder.toString();

        for (int i = 0; i < content.length(); i++) {
            i = content.indexOf("https://www.otodom.pl/pl/oferta/", i);
            if(i < 0){
                break;
            }
            String[] split = content.substring(i).split(".html");
            String link = split[0];
            links.add(link);

        }

        links.forEach(string -> System.out.println(string));

    }
}
