package kz.asset.web.service;

import kz.asset.web.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private DataProcessingService dataProcessingService;

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;

    public void processRegistration (String name, int age, String email){
        User user = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(user);
        notificationService.sendNotification("Added" + user);
    }

    public DataProcessingService getDataProcessingService(){
        return dataProcessingService;
    }
}
