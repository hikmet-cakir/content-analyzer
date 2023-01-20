package com.analyzer.content.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Hikmet
 * @since 13-01-2023+03:00
 */
@Getter
@Setter
@Entity
@Table(name = "content")
public class ContentEntity {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "location")
    private String location;

    @Column(name = "text")
    private String text;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}
