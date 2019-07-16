package ir.viratech.pond_ms.core.behnevis;

import ir.viratech.base.SuppressWarningsOption;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

@SuppressWarnings(SuppressWarningsOption.ALL)
public class BehnevisPinglishToEnglishConverter {

    private static final String BASE_URL = "http://www.behnevis.com/php/convert.php";

    public String map(String str) {
        String requestBody = makeRequestBody(str);
        Connection.Response response = null;
        try {
            response = connect(requestBody);
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Connection.Response connect(String requestBody) throws IOException {
        return Jsoup.connect(BASE_URL).method(Connection.Method.POST)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .requestBody(requestBody).execute();
    }

    private String makeRequestBody(String str) {
        StringBuilder builder = new StringBuilder();
        builder.append("farsi=");
        builder.append(str);
        return builder.toString();
    }

}
