package com.analyzer.content.external.medium.impl;

import com.analyzer.content.external.medium.IMediumService;
import com.analyzer.content.external.medium.dto.MediumItemResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediumService implements IMediumService {

    @Override
    public List<MediumItemResponse> getAllStories() {
        return null;
    }
}
