package com.analyzer.content.job.impl;

import com.analyzer.content.common.ExternalProvider;
import com.analyzer.content.external.medium.IMediumService;
import com.analyzer.content.external.medium.dto.MediumItemResponse;
import com.analyzer.content.job.IMediumJob;
import com.analyzer.content.mapper.ContentMapper;
import com.analyzer.content.model.Content;
import com.analyzer.content.repository.ContentRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Hikmet
 * @since 28-01-2023+03:00
 */
@Component
public class MediumJob implements IMediumJob {

    private final ContentRepository contentRepository;

    private final IMediumService mediumService;

    public MediumJob(ContentRepository contentRepository, IMediumService mediumService) {
        this.contentRepository = contentRepository;
        this.mediumService = mediumService;
    }

    @Scheduled(cron = "0 * * * *")
    public void scheduleStoryUpdating() {
        List<MediumItemResponse> allStories = mediumService.getAllStories("");
        List<Content> contents = allStories.stream().map(mediumItem -> Content.builder()
                .location(ExternalProvider.MEDIUM.getValue())
                .text(mediumItem.getDescription())
                .build())
                .collect(Collectors.toList());
        contents.stream()
                .map(ContentMapper.INSTANCE::toContentEntity)
                .forEach(contentRepository::save);
    }
}
