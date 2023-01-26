package com.analyzer.content.dto;

import com.analyzer.content.model.Content;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author Hikmet
 * @since 13-01-2023+03:00
 */
@Data
@Builder
public class QueryContentResponse {

    List<Content> contents;
}
