package com.analyzer.content.service.impl;

import com.analyzer.content.dto.*;
import com.analyzer.content.entity.ContentEntity;
import com.analyzer.content.mapper.ContentMapper;
import com.analyzer.content.model.Content;
import com.analyzer.content.repository.ContentRepository;
import com.analyzer.content.service.IContentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Hikmet
 * @since 13-01-2023+03:00
 */
@Slf4j
@Service
public class ContentService implements IContentService {

    private final ContentRepository contentRepository;

    public ContentService(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @Override
    public QueryContentResponse queryContent(QueryContentRequest queryContentRequest) {
        List<ContentEntity> contentEntities = contentRepository.queryContent(queryContentRequest);
        List<Content> contents = contentEntities.stream()
                .map(ContentMapper.INSTANCE::toContent)
                .collect(Collectors.toList());
        return QueryContentResponse.builder()
                .contents(contents)
                .build();
    }

    @Override
    public UploadContentResponse uploadContent(UploadContentRequest uploadContentRequest) {
        Content content = Content.builder()
                .id(UUID.randomUUID().toString())
                .location(uploadContentRequest.getLocation())
                .text(uploadContentRequest.getText())
                .build();
        ContentEntity contentEntity = ContentMapper.INSTANCE.toContentEntity(content);
        ContentEntity savedContent = contentRepository.save(contentEntity);
        log.info("content was successfully saved. Content ID:{}", savedContent.getId());
        return UploadContentResponse.builder()
                .id(savedContent.getId())
                .build();
    }

    @Override
    public ModifyContentResponse modifyContent(String id, ModifyContentRequest modifyContentRequest) {
        ContentEntity contentEntity = contentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("The id gave was not found!"));
        contentEntity.setLocation(modifyContentRequest.getLocation());
        contentEntity.setText(modifyContentRequest.getText());
        contentRepository.save(contentEntity);
        log.info("content was successfully modified. Content ID:{}", id);
        return ModifyContentResponse.builder()
                .id(contentEntity.getId())
                .location(contentEntity.getLocation())
                .text(contentEntity.getText())
                .createdAt(contentEntity.getCreatedAt())
                .updatedAt(contentEntity.getUpdatedAt())
                .build();
    }

    @Override
    public void deleteContent(String id) {
        contentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("The id gave was not found!"));
        contentRepository.deleteById(id);
        log.info("Delete operation was successfully completed. Content ID:{}", id);
    }
}
