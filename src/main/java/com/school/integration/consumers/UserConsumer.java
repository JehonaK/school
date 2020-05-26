package com.school.integration.consumers;

import com.school.entity.User;
import com.school.integration.models.SerializableUser;
import com.school.service.UserServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class UserConsumer {

    private UserServiceImpl userService;

    public UserConsumer(UserServiceImpl userService) {
        this.userService = userService;
    }

    @RabbitListener(queues = {"${queue.user.new.teacher}", "${queue.user.new.student}", "${queue.user.new.admin}"})
    public void handleNewUserReception(SerializableUser user) {
        userService.save(new User(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getRole()));
    }

}
