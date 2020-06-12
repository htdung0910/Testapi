package com.example.demo.User;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {
    private Gson gson = new GsonBuilder().disableHtmlEscaping().create();

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> checkLogin(@RequestParam("username") String username,@RequestParam("password") String password) throws SQLException {
        UserDAO uDAO = new UserDAO();
        User user = uDAO.checkLogin(username, password);
        return new ResponseEntity<>(gson.toJson(user),HttpStatus.OK);
    }
}
