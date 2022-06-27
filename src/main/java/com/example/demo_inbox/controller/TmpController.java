package com.example.demo_inbox.controller;

import com.example.demo_inbox.domains.message.Message;
import com.example.demo_inbox.domains.message.MessageRepository;
import com.example.demo_inbox.domains.message.MessageStatus;
import com.example.demo_inbox.domains.user.User;

import com.example.demo_inbox.domains.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TmpController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/test")
    public @ResponseBody String test() {


        User sender = userRepository.getReferenceById((long)1);
        User recipient = userRepository.getReferenceById((long)2);


        Message message = new Message();
        message.setSubject("Test subject");
        message.setMessage("Test");
        message.setRecipient(recipient);
        message.setSender(sender);
        message.setStatus(MessageStatus.UNREAD);

        message = messageRepository.save(message);

        //return  "sender: " + sender.getUserName() + " recipient:" + recipient.getUserName() + " message: " + message.get;
        return  "sender: " + sender.getUserName() + " recipient:" + recipient.getUserName() + " message: " + message.getId().toString();
    }

}
