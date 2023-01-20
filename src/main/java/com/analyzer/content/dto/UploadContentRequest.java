package com.analyzer.content.dto;

import lombok.Data;

/**
 * @author Hikmet
 * @since 13-01-2023+03:00
 */
@Data
public class UploadContentRequest {

    private String location;

    private String text;
}
