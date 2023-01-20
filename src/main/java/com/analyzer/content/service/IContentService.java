package com.analyzer.content.service;

import com.analyzer.content.dto.*;

/**
 * @author Hikmet
 * @since 13-01-2023+03:00
 */
public interface IContentService {

    QueryContentResponse queryContent(QueryContentRequest queryContentRequest);

    UploadContentResponse uploadContent(UploadContentRequest uploadContentRequest);

    ModifyContentResponse modifyContent(String id, ModifyContentRequest modifyContentRequest);

    void deleteContent(String id);
}
