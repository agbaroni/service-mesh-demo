package io.github.agbaroni.smdemo.service1;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Version;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@EqualsAndHashCode
public class AccountKey implements Serializable {
    private static final long serialVersionUID = 1069277072837331727L;

    @Column(name = "ACCOUNT_ID", nullable = false)
    @Getter
    @Setter
    private String id;

    @Column(nullable = false)
    @Getter
    @Setter
    private String user;
}
