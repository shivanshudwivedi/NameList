package com.NameList.rest.webservices.NameList;

public class Name {

    private Integer id;
    private String name;

    public Name(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String toString(){
        return "User [id = " + id + ", name = " + name + "]";
    }
}
