package io.github.agbaroni.smdemo.service1;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EmbeddedId;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode
@NamedQueries({
	@NamedQuery(name = Account.SELECT_ALL, query = "SELECT a FROM Account a WHERE a.key.agency = :agency"),
	@NamedQuery(name = Account.SELECT_ONE, query = "SELECT a FROM Account a WHERE a.key.id = :id AND a.key.user = :user")
})
@Table(name = "ACCOUNTS")
public class Account implements Serializable {
    private static final long serialVersionUID = 2767132695127695164L;

    public static final String SELECT_ALL = "Account.selectAll";
    public static final String SELECT_ONE = "Account.selectOne";

    @EmbeddedId
    @Getter
    @Setter
    private AccountKey key;

    @EqualsAndHashCode.Exclude
    @Getter
    @Setter
    private double amount;

    @EqualsAndHashCode.Exclude
    @Getter
    @Setter
    private String agency;

    @EqualsAndHashCode.Exclude
    @JsonbTransient
    @Version
    private int version;
}
