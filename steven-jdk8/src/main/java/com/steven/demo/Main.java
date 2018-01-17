package com.steven.demo;

/**
 * Created by Steven on 2017/6/15.
 */
public class Main {

    public static void main(String[] args) {
        Person p = new Person();
        p.setAge(123);
        p.setPsersonName("Steven");
        NodeMessage<Person> noPerson = new NodeMessage<>();
        noPerson.setMessage("erroe");
        noPerson.setNodeName("nodeName");
        noPerson.add(p);

    }

}
