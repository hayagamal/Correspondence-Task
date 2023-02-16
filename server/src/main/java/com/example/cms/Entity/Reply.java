package com.example.cms.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;
import java.time.ZonedDateTime;

@Entity
public class Reply {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String Message;
private long AttachmentID;
private long correspondence_id;
private Date date;
@ManyToOne @JoinColumn(name = "correspondence_id",referencedColumnName = "id", insertable = false ,updatable = false)
@JsonIgnore private Correspondence correspondence;


   

    public Reply() {
    }


    public Reply( String Message, long AttachmentID, long correspondeance_id) {
        this.Message = Message;
        this.AttachmentID = AttachmentID;
        this.correspondence_id = correspondeance_id;
        this.date = Date.from(ZonedDateTime.now().toInstant());
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
   

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return this.Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public long getCorrespondeance_id() {
        return this.correspondence_id;
    }

    public void setCorrespondeance_id(long correspondeance_id) {
        this.correspondence_id = correspondeance_id;
    }

    public long getAttachmentID() {
        return this.AttachmentID;
    }

    public void setAttachmentID(long AttachmentID) {
        this.AttachmentID = AttachmentID;
    }

    public Correspondence getCorrespondence() {
        return this.correspondence;
    }

    public void setCorrespondence(Correspondence correspondence) {
        this.correspondence = correspondence;
    }
    

}
