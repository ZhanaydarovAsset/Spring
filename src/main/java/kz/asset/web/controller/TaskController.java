package kz.asset.web.controller;

import kz.asset.web.domain.User;
import kz.asset.web.service.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private DataProcessingService service;

    @GetMapping
    public List<String> getAllTasks()
    {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return  tasks;
    }

    @GetMapping("/sort")//localhost:8080/tasks/sort
    public List<User> sortUsersByAge()
    {
        return service.sortUsersByAge(service.getRepository().getUsers());
    }

    //метод filterUsersByAge
    @GetMapping("/filter/{age}")
    public List<User> filterUserByAgeWithPathVariable(@PathVariable int age){
        return service.filterUsersByAge(service.getRepository().getUsers(), age);
    }

    @GetMapping("/filter")
    public List<User> filterUserByAge(@RequestParam("0") int age){
        return service.filterUsersByAge(service.getRepository().getUsers(), age);
    }

    //метод calculateAverageAge
    @GetMapping("/calc")
    public double calculateAverageAge(){
        return service.calculateAverageAge(service.getRepository().getUsers());
    }
}
