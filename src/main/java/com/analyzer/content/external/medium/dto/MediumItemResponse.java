package com.analyzer.content.external.medium.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author Hikmet
 * @since 21-01-2023+03:00
 */
@Data
@Builder
public class MediumItemResponse {

    private String title;

    private String publicationDate;

    private String url;

    private String author;

    private String thumbnail;

    private String description;

    private List<String> categories;
}
