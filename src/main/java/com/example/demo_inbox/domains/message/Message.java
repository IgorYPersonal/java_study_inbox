package com.example.demo_inbox.domains.message;

import com.example.demo_inbox.domains.user.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
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
}
