package match;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class HrefMatch {
    public static void main(String[] args) {
        try {
            String urlString = "https://powiatleczynski.pl/";
//            if(args.length > 0) urlString = args[0];
//            else urlString = "http://java.sun.com";

            InputStreamReader in = new InputStreamReader(new URL(urlString).openStream(), StandardCharsets.UTF_8);

            StringBuilder input = new StringBuilder();
            int ch;

            while( (ch = in.read()) != -1)
                input.append((char) ch);

            String patternString = "<a\\s+href\\s*=\\s*(\"[^\"]*\"|[^\\d>]*)\\s*>";
            Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);

            Matcher matcher = pattern.matcher(input);

            while (matcher.find())
            {
                String match = matcher.group();
                System.out.println(match);

            }
        }
        catch (IOException| PatternSyntaxException e) {
            e.printStackTrace();
        }
    }
}
