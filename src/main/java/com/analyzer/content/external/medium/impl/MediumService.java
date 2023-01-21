package com.analyzer.content.external.medium.impl;

import com.analyzer.content.external.medium.IMediumService;
import com.analyzer.content.external.medium.dto.MediumItemResponse;
import com.sun.syndication.feed.synd.SyndContentImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.fetcher.FeedFetcher;
import com.sun.syndication.fetcher.impl.HttpURLFeedFetcher;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Hikmet
 * @since 21-01-2023+03:00
 */
@Service
public class MediumService implements IMediumService {

    private static class PATHS {
        public static final String GET_ALL_STORIES = "https://medium.com/feed/@";
    }

    @Override
    public List<MediumItemResponse> getAllStories(String userName) {
        try {
            String path = PATHS.GET_ALL_STORIES + userName;
            URL url = new URL(path);
            FeedFetcher feedFetcher = new HttpURLFeedFetcher();
            SyndFeed feed = feedFetcher.retrieveFeed(url);
            return ((List<?>) feed.getEntries()).stream()
                    .filter(SyndEntry.class::isInstance)
                    .map(SyndEntry.class::cast)
                    .map(this::toMediumItemResponse)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("fetching all stories of the user from Medium was failed!");
        }
    }

    private MediumItemResponse toMediumItemResponse(SyndEntry syndEntry) {
        String storyDescription = ((SyndContentImpl) syndEntry.getContents().get(0)).getValue();
        return MediumItemResponse.builder()
                .title(syndEntry.getTitle())
                .author(syndEntry.getAuthor())
                .description(storyDescription)
                .build();
    }
}
