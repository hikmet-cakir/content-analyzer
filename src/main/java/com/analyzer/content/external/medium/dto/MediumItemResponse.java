package com.analyzer.content.external.medium.dto;

import lombok.Data;

import java.util.List;

@Data
public class MediumItemResponse {

    private String title;

    private String publicationDate;

    private String url;

    private String author;

    private String thumbnail;

    private String description;

    private List<String> categories;
}
