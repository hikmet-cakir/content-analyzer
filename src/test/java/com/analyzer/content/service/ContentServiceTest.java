package com.analyzer.content.service;

import com.analyzer.content.dto.*;
import com.analyzer.content.entity.ContentEntity;
import com.analyzer.content.repository.ContentRepository;
import com.analyzer.content.service.impl.ContentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ContentServiceTest {

    public static final String EXISTING_CONTENT_ID = UUID.randomUUID().toString();

    public static final String NON_EXISTING_CONTENT_ID = "99118822773355AAaaBBbbCCccDDdd";

    @InjectMocks
    ContentService contentService;

    @Mock
    ContentRepository contentRepository;

    @BeforeEach
    public void setUp() {
    }

    @Test
    void when_deleteExistingContent_expect_takesSuccess() {
        ContentEntity exampleContent = new ContentEntity();
        when(contentRepository.findById(EXISTING_CONTENT_ID)).thenReturn(Optional.of(exampleContent));

        assertDoesNotThrow(() -> contentService.deleteContent(EXISTING_CONTENT_ID));
    }

    @Test
    void when_deleteNonExistContent_expect_throwsException() {
        ContentEntity exampleContent = new ContentEntity();
        when(contentRepository.findById(EXISTING_CONTENT_ID)).thenReturn(Optional.of(exampleContent));

        assertThrows(RuntimeException.class, () -> contentService.deleteContent(NON_EXISTING_CONTENT_ID));
    }

    @Test
    void when_uploadValidContent_expect_takesSuccess() {
        // Given
        UploadContentRequest request = new UploadContentRequest();
        request.setText("LinkedIn");
        request.setLocation("The economy of the world in the last days");

        ContentEntity savedContent = new ContentEntity();
        String id = UUID.randomUUID().toString();
        savedContent.setId(id);
        savedContent.setText("LinkedIn");
        savedContent.setLocation("The economy of the world in the last days");
        when(contentRepository.save(any())).thenReturn(savedContent);

        // When
        UploadContentResponse actual = contentService.uploadContent(request);

        // Then
        UploadContentResponse expected = UploadContentResponse.builder()
                .id(id)
                .build();
        assertEquals(expected.getId(), actual.getId());
    }

    @Test
    void when_modifyValidContent_expect_takesSuccess() {
        // Given
        String id = UUID.randomUUID().toString();

        ContentEntity exampleContent = new ContentEntity();
        exampleContent.setId(id);
        when(contentRepository.findById(id)).thenReturn(Optional.of(exampleContent));

        ModifyContentRequest request = new ModifyContentRequest();
        request.setText("LinkedIn");
        request.setLocation("The economy of the world in the last days");

        ContentEntity savedContent = new ContentEntity();
        savedContent.setId(id);
        savedContent.setText("LinkedIn");
        savedContent.setLocation("The economy of the world in the last days");
        when(contentRepository.save(any())).thenReturn(savedContent);

        // When
        ModifyContentResponse actual = contentService.modifyContent(id, request);

        // Then
        ModifyContentResponse expected = ModifyContentResponse.builder()
                .id(id)
                .text("LinkedIn")
                .location("The economy of the world in the last days")
                .build();
        assertEquals(expected.getId(), actual.getId());
    }

    @Test
    void when_queryWithValidId_expect_returnExistRecord() {
        // Given
        String id = UUID.randomUUID().toString();

        ContentEntity exampleContent = new ContentEntity();
        exampleContent.setId(id);
        exampleContent.setText("LinkedIn");
        exampleContent.setLocation("The economy of the world in the last days");
        when(contentRepository.findById(id)).thenReturn(Optional.of(exampleContent));

        QueryContentRequest request = new QueryContentRequest();
        request.setId(id);

        // When
        QueryContentResponse actual = contentService.queryContent(request);

        // Then
        QueryContentResponse expected = QueryContentResponse.builder()
                .id(id)
                .text("LinkedIn")
                .location("The economy of the world in the last days")
                .build();
        assertEquals(expected.getId(), actual.getId());
    }
}
