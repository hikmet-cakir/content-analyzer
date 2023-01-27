package com.analyzer.content.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author Hikmet
 * @since 13-01-2023+03:00
 */
@Data
public class QueryContentRequest {

    private String id;

    private String location;

    private String text;

    private Date createdAt;

    private Date updatedAt;
}
