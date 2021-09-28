package com.leo.backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Quiz {

    @Id
    @GeneratedValue
    private Long id;
    private String mail;
    private String genre;

    public Quiz() {
    }

    public Quiz(Long id, String mail, String genre) {
        this.id = id;
        this.mail = mail;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", mail='" + mail + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
