package com.analyzer.content.external.medium;

import com.analyzer.content.external.medium.dto.MediumItemResponse;

import java.util.List;

public interface IMediumService {

    List<MediumItemResponse> getAllStories();
}
