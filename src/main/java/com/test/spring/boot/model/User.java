package com.test.spring.boot.model;


import javax.persistence.*;

@Entity
@Table(name = "APP_USER")
public class User  {

    @Id
    @SequenceGenerator(name="seg_gen",
            sequenceName="seq_user",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="seg_gen")
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    private UserType type;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
