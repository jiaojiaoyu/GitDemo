package com.vae.domain;
/**
 * Person类就是领域模型，表示是对它（数据库表）进行增删改查。
 * @author DELL
 *
 */

public class Person {
    private int id;
    private String name;
    private int age;
    private String description;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Person(int id, String name, int age, String description) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.description = description;
    }
    public Person(String name, int age, String description) {
        super();
        this.name = name;
        this.age = age;
        this.description = description;
    }
    public Person() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", age=" + age
                + ", description=" + description + "]";
    }
    
    
}