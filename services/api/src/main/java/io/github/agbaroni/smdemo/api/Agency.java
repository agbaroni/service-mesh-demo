package io.github.agbaroni.smdemo.api;

import java.io.Serializable;

import lombok.Data;

@Data
public class Agency implements Serializable {
    private static final long serialVersionUID = 2351660411241820919L;

    private String id;

    private String city;
}
