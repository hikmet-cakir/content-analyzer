package com.analyzer.content.external.medium;

import com.analyzer.content.external.medium.impl.MediumService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MediumServiceTest {

    MediumService mediumService;

    @Test
    void when_getAllStories_expect_takeAllStories() {
    }

    @Test
    void when_failedConnectionInGettingAllStories_expect_throwsException() {
    }
}
