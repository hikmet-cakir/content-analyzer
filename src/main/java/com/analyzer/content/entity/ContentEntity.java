package com.analyzer.content.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Hikmet
 * @since 13-01-2023+03:00
 */
@Getter
@Setter
@Entity
@FieldNameConstants
@Table(name = "content")
public class ContentEntity extends BaseEntity {

    @Column(name = "location")
    private String location;

    @Column(name = "text")
    private String text;
}
