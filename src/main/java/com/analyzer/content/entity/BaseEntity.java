package com.analyzer.content.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Hikmet
 * @since 13-01-2023+03:00
 */
@Getter
@Setter
@FieldNameConstants
@MappedSuperclass
public class BaseEntity {

    @Id
    @Column(name = "id")
    private String id;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
}
