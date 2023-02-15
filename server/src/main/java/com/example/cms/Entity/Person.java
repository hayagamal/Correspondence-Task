package com.example.cms.Entity;

import java.util.List;



import jakarta.persistence.*;


@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;

    @OneToMany(mappedBy = "from") private List<Correspondence> sentMessages;
    @OneToMany(mappedBy = "referance") private List<Correspondence> receivedMessages;
    
    public Person() {
    }

    public Person(Long Id, String Name, List<Correspondence> sentMessages, List<Correspondence> receivedMessages) {
        this.Id = Id;
        this.name = Name;
        this.sentMessages = sentMessages;
        this.receivedMessages = receivedMessages;
    }

    public Person(String Name) {
      
        this.name = Name;
    }

    public Long getId() {
        return this.Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

}
