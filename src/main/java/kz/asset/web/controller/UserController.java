package kz.asset.web.controller;

import kz.asset.web.domain.User;
import kz.asset.web.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user)
    {
        service.getDataProcessingService().getRepository().getUsers().add(user);
        return "User added from body!";
    }

    @PostMapping
    public String addUserFromParam(
            @RequestParam("defaultName") String name,
            @RequestParam("0") int age,
            @RequestParam("non@nan") String email
    ){
        service.processRegistration(name, age, email);
        return "User added";
    }

}