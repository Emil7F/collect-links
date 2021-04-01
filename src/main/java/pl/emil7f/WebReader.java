package pl.emil7f;

import java.io.*;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class WebReader {

    public static void main(String[] args) {
        String link = "https://www.otodom.pl/sprzedaz/mieszkanie/gliwice/";
        String fileName = "links.txt";
        String linkPrefix = "https://www.otodom.pl/pl/oferta/";

        createFileWithLinksFromURLAddress(link, linkPrefix,fileName);

    }


    private static Set<String> createFileWithLinksFromURLAddress(String urlAdress, String linkPrefix, String fileName) {

        String inputLine;
        StringBuilder builder = new StringBuilder();

        try {
            URL url = new URL(urlAdress);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream()));
            while ((inputLine = in.readLine()) != null) {
                builder.append(inputLine);
                builder.append(System.lineSeparator());
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Set<String> links = new HashSet<>();
        String content = builder.toString();


        for (int i = 0; i < content.length(); i++) {
            i = content.indexOf(linkPrefix, i);
            if (i < 0) {
                break;
            }
            String[] split = content.substring(i).split(".html");
            String link = split[0];
            boolean added = links.add(link);

            try (BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(fileName, true))) {
                if (added) {
                    bufferedWriter.write(link + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return links;

    }
}
