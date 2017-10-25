package com.test.spring.boot.model;

import javax.persistence.*;

@MappedSuperclass
abstract class BaseEntity {
    @Id
    @SequenceGenerator(name="seg_gen",
            sequenceName="seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="seg_gen")
    protected Long id;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }
}
