package com.analyzer.content.controller;

import com.analyzer.content.dto.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Hikmet
 * @since 13-01-2023+03:00
 */
public interface ContentApi {

    @GetMapping
    ResponseEntity<QueryContentResponse> queryContent(@RequestBody QueryContentRequest queryContentRequest);

    @PostMapping
    ResponseEntity<UploadContentResponse> uploadContent(@RequestBody UploadContentRequest uploadContentRequest);

    @PutMapping("/{id}")
    ResponseEntity<ModifyContentResponse> modifyContent(@PathVariable String id, @RequestBody ModifyContentRequest modifyContentRequest);

    @DeleteMapping("/{id}")
    void deleteContent(@PathVariable String id);
}
