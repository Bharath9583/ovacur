package webservice;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import model.SecurityManager;

@Path("/WebService")
public class LoginService {

    @POST
    @Path("/userlogin")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String login(@FormParam("username") String username,
            @FormParam("password") String password) {

        return getAllUsersList(username, password);

    }

    public String getAllUsersList(String username, String password) {
        try {
            SecurityManager securityManager = new SecurityManager();
            boolean user = securityManager.getAllUsersList(username,password);
            return "Logged in User:" + username;           
        } catch (Exception e) {
            System.out.println("error");
        }
        return "You are not a Valid User";
    }
}
