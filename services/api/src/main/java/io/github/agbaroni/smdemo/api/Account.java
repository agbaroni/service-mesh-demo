package io.github.agbaroni.smdemo.api;

import java.io.Serializable;

import lombok.Data;

@Data
public class Account implements Serializable {
    private static final long serialVersionUID = 1942032248763911129L;

    private AccountKey key;

    private double amount;

    private String agency;
}
