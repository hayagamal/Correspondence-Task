package com.example.cms.DTO;


import com.example.cms.Entity.Enum.Priority;
import com.example.cms.Entity.Enum.Type;
import lombok.Data;

@Data
public class CDTO {
    private String Subject;
    private String Description;
    private Type Type;
    private Priority Priority;
    private String from;
    private String to;

//    public CDTO(String Subject, String Description, Type Type, Priority Priority, String from, String to) {
//        this.Subject = Subject;
//        this.Description = Description;
//        this.Type = Type;
//        this.Priority = Priority;
//        this.from = from;
//        this.to = to;
//    }
//    public CDTO() {
//
//    }
//
//    public String getSubject() {
//        return this.Subject;
//    }
//
//    public void setSubject(String Subject) {
//        this.Subject = Subject;
//    }
//
//    public String getDescription() {
//        return this.Description;
//    }
//
//    public void setDescription(String Description) {
//        this.Description = Description;
//    }
//
//    public Type getType() {
//        return this.Type;
//    }
//
//    public void setType(Type Type) {
//        this.Type = Type;
//    }
//
//    public Priority getPriority() {
//        return this.Priority;
//    }
//
//    public void setPriority(Priority Priority) {
//        this.Priority = Priority;
//    }
//
//    public String getFrom() {
//        return this.from;
//    }
//
//    public void setFrom(String from) {
//        this.from = from;
//    }
//
//    public String getTo() {
//        return this.to;
//    }
//
//    public void setTo(String to) {
//        this.to = to;
//    }

}
