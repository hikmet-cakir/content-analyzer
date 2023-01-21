package com.analyzer.content.external.medium;

import com.analyzer.content.external.medium.dto.MediumItemResponse;

import java.util.List;

/**
 * @author Hikmet
 * @since 21-01-2023+03:00
 */
public interface IMediumService {

    List<MediumItemResponse> getAllStories(String userName);
}
