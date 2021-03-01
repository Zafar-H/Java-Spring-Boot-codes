package com.zafar.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningControl {

    //uri versioning
    @GetMapping("v1/person")
    public PersonV1 personV1() {
        return  new PersonV1("Bob marley");
    }

    @GetMapping("v2/person")
    public PersonV2 personV2() {
        return new PersonV2(new Name("Bob", "Marley"));
    }

    //parameter versioning
    @GetMapping(value = "person/param",params = "version=1")
    public PersonV1 paramV1() {
        return new PersonV1("Bob Marley");
    }

    @GetMapping(value = "person/param",params = "version=2")
    public PersonV2 paramV2() {
        return new PersonV2(new Name("Bob", "Marley"));
    }

    //header versioning
    @GetMapping(value = "person/header",headers = "X-API-VERSION=1")
    public PersonV1 headerV1() {
        return new PersonV1("Bob Marley");
    }

    @GetMapping(value = "person/header",headers = "X-API-VERSION=2")
    public PersonV2 headerV2() {
        return new PersonV2(new Name("Bob", "Marley"));
    }

    //media type versioning
    @GetMapping(value = "person/producers",produces = "application/vnd.company.app-v1+json")
    public PersonV1 producersV1() {
        return new PersonV1("Bob Marley");
    }

    @GetMapping(value = "person/producers",produces = "application/vnd.company.app-v2+json")
    public PersonV2 producersV2() {
        return new PersonV2(new Name("Bob", "Marley"));
    }
}
