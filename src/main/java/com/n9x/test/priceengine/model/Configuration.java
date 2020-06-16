package com.n9x.test.priceengine.model;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "key", name = "keyColUniqueConstraint")})
public class Configuration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    @Column(unique=true)
    private String key;

    @Column
    private String value;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
