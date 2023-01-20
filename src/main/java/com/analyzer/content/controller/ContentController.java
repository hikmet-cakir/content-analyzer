package com.analyzer.content.controller;

import com.analyzer.content.dto.*;
import com.analyzer.content.service.IContentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hikmet
 * @since 13-01-2023+03:00
 */
@RestController
@RequestMapping("/content")
public class ContentController implements ContentApi {

    private final IContentService contentService;

    public ContentController(IContentService contentService) {
        this.contentService = contentService;
    }

    @Override
    public ResponseEntity<QueryContentResponse> queryContent(QueryContentRequest queryContentRequest) {
        return ResponseEntity.ok(contentService.queryContent(queryContentRequest));
    }

    @Override
    public ResponseEntity<UploadContentResponse> uploadContent(UploadContentRequest uploadContentRequest) {
        return ResponseEntity.ok(contentService.uploadContent(uploadContentRequest));
    }

    @Override
    public ResponseEntity<ModifyContentResponse> modifyContent(String id, ModifyContentRequest modifyContentRequest) {
        return ResponseEntity.ok(contentService.modifyContent(id, modifyContentRequest));
    }

    @Override
    public void deleteContent(String id) {
        contentService.deleteContent(id);
    }
}
