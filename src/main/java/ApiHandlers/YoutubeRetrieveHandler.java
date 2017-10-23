/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApiHandlers;

import YoutubeDataModels.HealthCheckModel;
import YoutubeDataModels.VideoModel;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Channel;
import com.google.api.services.youtube.model.ChannelListResponse;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import java.io.IOException;
import java.util.List;

/**
 * Handles functionality to retrieve the Youtube video to play as the alarm.
 *
 * @author roshanmuralidharan
 * @version 1.0
 * @since 2017-10-21
 */
public class YoutubeRetrieveHandler {

    /**
     * Maximum number of URLs to fetch. Note - Sticking to one URL to keep it
     * seamless for the user.
     */
    private static final long MAX_URL_COUNT = 1;

    /**
     * Health check to see if authentication and retrieval works. This is used
     * only from the test driver. Note - Borrowed and adapted from the
     * Quickstart guide.
     *
     * @return HealthCheckModel returns the data retrieved by the health check
     * op. Null if nothing was retrieved.
     * @throws java.io.IOException
     */
    public HealthCheckModel healthCheck() throws IOException {
        // Health check model that is populated by the retriever. 
        HealthCheckModel healthCheck = null;

        try {
            // Handler to perform the authentication.
            YouTube handler = YoutubeAuthenticationHandler.getServiceHandler();

            // Channel content that needs to be fetched.
            YouTube.Channels.List channelsListByUsernameRequest = handler.channels().list("snippet,contentDetails,statistics");

            // Name of youtube channel to be fetched.
            channelsListByUsernameRequest.setForUsername("GoogleDevelopers");

            // Retrieve response.
            ChannelListResponse response = channelsListByUsernameRequest.execute();
            Channel channel = response.getItems().get(0);

            // Building the healthcheck model.
            healthCheck = HealthCheckModel.newBuilder().setId(channel.getId())
                    .setTitle(channel.getSnippet().getTitle()).
                    setViewCount(channel.getStatistics().getViewCount().longValue())
                    .build();

        } catch (GoogleJsonResponseException e) {
            System.err.println("There was a service error: "
                    + e.getDetails().getCode() + " : " + e.getDetails().getMessage());
        }

        return healthCheck;
    }

    /**
     * Retrieve a Youtube URL for the keyword passed in.
     *
     * @param keywords A set of keywords that related to the video required.
     * @return VideoModel Information about the video for the keyword.
     */
    public VideoModel getUrlForKeyword(String keywords) {
        // Video model that is retrieved by the retriever.
        VideoModel video = null;

        try {
            // Handler to authenticate to the service.
            YouTube handler = YoutubeAuthenticationHandler.getServiceHandler();

            // Define the API request and search criteria for retrieving search results.
            YouTube.Search.List search = handler.search().list("id,snippet");
            search.setQ(keywords);
            search.setType("video");
            search.setFields("items(id/kind,id/videoId,snippet/title)");
            search.setMaxResults(MAX_URL_COUNT);

            // Call the API and print results.
            SearchListResponse searchResponse = search.execute();
            List<SearchResult> searchResultList = searchResponse.getItems();

            if (searchResultList != null || searchResultList.isEmpty()) {
                // We assume that only one video exists.
                SearchResult result = searchResultList.get(0);

                video = VideoModel.newBuilder().setId(result.getId().getVideoId())
                        .setTitle(result.getSnippet().getTitle())
                        .build();
            } else {
                // Return null if video was not found.
                return null;
            }
        } catch (GoogleJsonResponseException e) {
            System.err.println("There was a service error: " + e.getDetails().getCode() + " : "
                    + e.getDetails().getMessage());
        } catch (IOException e) {
            System.err.println("There was an IO error: " + e.getCause() + " : " + e.getMessage());
        }

        return video;
    }
}
