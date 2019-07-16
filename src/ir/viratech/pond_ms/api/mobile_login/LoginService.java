package ir.viratech.pond_ms.api.mobile_login;

import ir.viratech.pond_ms.api.mobile_login.dto.OtpToken;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("mobile-login")
public class LoginService {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("token/verification")
    public Response loginWithToken(@RequestBody OtpToken otpToken) {

        try {
            org.jsoup.Connection.Response response = Jsoup
                    .connect("http://justro.me/j_spring_otptoken_security_check")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .data("j_phoneNumber", otpToken.getPhoneNumber())
                    .data("j_otpToken", otpToken.getTokenNumber())
                    .data("_spring_security_remember_me", "on")
                    .method(org.jsoup.Connection.Method.POST).execute();

            if (response.statusCode() == 200) {


                return Response.status(302)
                        .location(new URI("http://localhost:3000/"))
                        .cookie(new NewCookie("JSESSIONID"
                                , makeCorrectJson(response.cookies().toString())))
                        .build();

            } else if (response.statusCode() == 401) {
                return Response.status(401).build();
            }

        } catch (HttpStatusException ex) {
            if (ex.getStatusCode() == 401) {
                return Response.status(401).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return Response.status(500).build();
    }


    private String makeCorrectJson(String cookie) {
        return cookie.substring(cookie.indexOf("JSESSIONID=")
                        + "JSESSIONID=".length()
                , cookie.length() - 1);
    }


}