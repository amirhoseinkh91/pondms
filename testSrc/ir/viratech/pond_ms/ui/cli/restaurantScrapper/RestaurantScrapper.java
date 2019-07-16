package ir.viratech.pond_ms.ui.cli.restaurantScrapper;

import ir.viratech.just_ro.core.cache.proxy.ProxyCacher;
import ir.viratech.just_ro.manager.website.proxy.ProxyManager;
import ir.viratech.just_ro.model.calendar.CalendarTool;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.ui.cli.proxy_test.ProxyTEST;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

public class RestaurantScrapper {


    private String ip = "52.8.172.72";
    private int port = 4002;
    private final String baseURL = "https://api.foursquare.com/v2/venues/explore";
    private final String clientId = "LWSXOFD1UCNGMYLW0PHAPM3PV5CKSC4MLATYK2LVCNO1GSAG";
    private final String clientSecret = "s";
    public static void main(String[] args) {
//        ApplicationContextUtil.initializeCliApplicationContext();
        new RestaurantScrapper().start();

    }

    private void start() {
        String city = "تهران";
        String url = makeUrl(city);
        try {
            Connection.Response response = connect(url);
            JSONObject jsonObject = new JSONObject(response.body());
            System.out.println(jsonObject);
//            System.out.println(response.body());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    private String makeUrl(String city) {
        StringBuilder  builder = new StringBuilder(baseURL).append("?");
        builder.append("client_id=" + clientId);
        builder.append("&client_secret=" + clientSecret);
        builder.append("&v=20171106");
        builder.append("&near=" + city);
        builder.append("&intent=global");
        return builder.toString();
    }

    private Connection.Response connect(String url) throws IOException, IllegalAccessException, InstantiationException {
//        Proxy p = ProxyManager.newInstance().getRandomProxy();
//        Proxy p = new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(ip, port));
        return Jsoup.connect(url).ignoreContentType(true).method(Connection.Method.GET).execute();
    }

}
