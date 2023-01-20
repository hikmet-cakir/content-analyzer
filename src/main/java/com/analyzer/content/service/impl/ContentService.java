package com.analyzer.content.service.impl;

import com.analyzer.content.dto.*;
import com.analyzer.content.entity.ContentEntity;
import com.analyzer.content.mapper.ContentMapper;
import com.analyzer.content.model.Content;
import com.analyzer.content.repository.ContentRepository;
import com.analyzer.content.service.IContentService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Hikmet
 * @since 13-01-2023+03:00
 */
@Service
public class ContentService implements IContentService {

    private final ContentRepository contentRepository;

    public ContentService(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @Override
    public QueryContentResponse queryContent(QueryContentRequest queryContentRequest) {
        ContentEntity contentEntity = contentRepository.findById(queryContentRequest.getId())
                .orElseThrow(() -> new RuntimeException("The id gave was not found!"));

        Content content = ContentMapper.INSTANCE.toContent(contentEntity);
        return QueryContentResponse.builder()
                .id(content.getId())
                .location(content.getLocation())
                .text(content.getText())
                .createdAt(content.getCreatedAt())
                .updatedAt(content.getUpdatedAt())
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
    }
}
