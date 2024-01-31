package com.redhat.training.ejb;

import javax.ejb.Stateless;

@Stateless
public class HelloBean {

    public String sayHello(String name) {

    // respond back with Hello, {name}.
    return "Hello, " + name;
    }
}
