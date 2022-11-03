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
	@NamedQuery(name = Agency.SELECT_ALL, query = "SELECT a FROM Agency a"),
	@NamedQuery(name = Agency.SELECT_ONE, query = "SELECT a FROM Agency a WHERE a.id = :id")
})
@Table(name = "AGENCIES")
public class Agency implements Serializable {
    private static final long serialVersionUID = 865328358263059235L;

    public static final String SELECT_ALL = "Account.selectAll";
    public static final String SELECT_ONE = "Account.selectOne";

    @Column(name = "AGENCY_ID")
    @Getter
    @Id
    @Setter
    private String id;

    @EqualsAndHashCode.Exclude
    private String city;

    @EqualsAndHashCode.Exclude
    @JsonbTransient
    @Version
    private int version;
}
