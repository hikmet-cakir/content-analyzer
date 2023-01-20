package com.analyzer.content.external.linkedin;

import com.analyzer.content.external.linkedin.impl.LinkedInService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LinkedInServiceTest {

    LinkedInService linkedInService;

    @Test
    void when_getAllPosts_expect_takeAllPosts() {
    }

    @Test
    void when_failedConnectionInGettingAllPosts_expect_throwsException() {
    }
}
