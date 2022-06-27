package com.example.demo_inbox.domains.message;

import com.example.demo_inbox.domains.user.User;

import javax.persistence.*;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="sender_id", referencedColumnName = "id")
    private User sender;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="recipient_id", referencedColumnName = "id")
    private User recipient;


    @Enumerated(EnumType.STRING)
    @Column
    private MessageStatus status;

    @Column(nullable = false)
    private String subject;

    @Column
    private String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public MessageStatus getStatus() {
        return status;
    }

    public void setStatus(MessageStatus status) {
        this.status = status;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
