package io.github.agbaroni.smdemo.api;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class AgencyAccounts implements Serializable {
    private static final long serialVersionUID = 3751269402074020482L;

    private String agency;

    private List<Account> accounts;
}
