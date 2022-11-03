package io.github.agbaroni.smdemo.api;

import java.io.Serializable;

import lombok.Data;

@Data
public class AccountKey implements Serializable {
    private static final long serialVersionUID = 973125597195161395L;

    private String id;

    private String user;
}
