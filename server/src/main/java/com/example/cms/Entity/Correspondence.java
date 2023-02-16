package com.example.cms.Entity;
import com.example.cms.Entity.Enum.*;

import java.util.Date;
import java.util.List;
import java.time.ZonedDateTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


//@Data
@Entity
public class Correspondence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    //private long From;
    //private long Referance;
    private String Subject;
    private String Description;
    private Date date;
    private Priority Priority;// High, Medium, Low
    private long AttachmentID;
    private long from_id;
    private long referance_id;
    private String toText;
    private String fromText;



    @ManyToOne @JoinColumn(name = "from_id",referencedColumnName = "id", insertable = false ,updatable = false)
    @JsonIgnore
    private Person from;
    @ManyToOne @JoinColumn(name = "referance_id",referencedColumnName = "id", insertable = false,updatable = false)
    @JsonIgnore
    private Person referance;

 
    @OneToMany(mappedBy = "correspondence") 
    @JsonIgnore
    private List<Reply> correspondeanceMessage;
    
    public Correspondence() {
    }



    public Correspondence(
                        String Subject, 
                        String Description, 
                        Priority Priority, 
                        long AttachmentID, 
                        long from_id, 
                        long referance_id) {
        this.Subject = Subject;
        this.Description = Description;
        this.date = Date.from(ZonedDateTime.now().toInstant());
        this.Priority = Priority;
        this.AttachmentID = AttachmentID;
        this.from_id = from_id;
        this.referance_id = referance_id;
    }
    public Correspondence(String Subject, 
                        String Description, 
                        Priority Priority, 
                        long from_id, 
                        long referance_id) {
        this.Subject = Subject;
        this.Description = Description;
        this.date = Date.from(ZonedDateTime.now().toInstant());
        this.Priority = Priority;
        this.from_id = from_id;
        this.referance_id = referance_id;
    }

    public Correspondence(String Subject, 
                        String Description, 
                        Priority Priority, 
                        long AttachmentID, 
                        long from_id, 
                        long referance_id,
                        String toTexString,
                        String FromText) {
        this.Subject = Subject;
        this.Description = Description;
        this.date = Date.from(ZonedDateTime.now().toInstant());
        this.Priority = Priority;
        this.AttachmentID = AttachmentID;
        this.from_id = from_id;
        this.referance_id = referance_id;
        this.toText=toTexString;
        this.fromText= FromText;
    }

    public long getID() {
        return this.ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }
  

    public String getSubject() {
        return this.Subject;
    }

    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

    public String getDescription() {
        return this.Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }


    public long getAttachmentID() {
        return this.AttachmentID;
    }

    public void setAttachmentID(long AttachmentID) {
        this.AttachmentID = AttachmentID;
    }
    

    public Priority getPriority() {
        return this.Priority;
    }

    public void setPriority(Priority Priority) {
        this.Priority = Priority;
    }
 

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

 

    public Person getFrom() {
        return this.from;
    }

    public void setFrom(Person from) {
        this.from = from;
    }

    public Person getReferance() {
        return this.referance;
    }

    public void setReferance(Person referance) {
        this.referance = referance;
    }


    public long getFrom_id() {
        return this.from_id;
    }

    public void setFrom_id(long from_id) {
        this.from_id = from_id;
    }

    public long getReferance_id() {
        return this.referance_id;
    }

    public void setReferance_id(long referance_id) {
        this.referance_id = referance_id;
    }

    public void setFromText(String referance) {
            this.fromText = referance;
    }

    public String getToText() {
        return this.toText;
    }

    public void setToText(String toText) {
        this.toText = toText;
    }

    public List<Reply> getCorrespondeanceMessage() {
        return this.correspondeanceMessage;
    }

    public void setCorrespondeanceMessage(List<Reply> correspondeanceMessage) {
        this.correspondeanceMessage = correspondeanceMessage;
    }

    public String getFromText() {
        return this.fromText;
    }

}
