/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import ApiHandlers.YoutubeRetrieveHandler;
import YoutubeDataModels.HealthCheckModel;
import YoutubeDataModels.VideoModel;

/**
* A Test driver class to assist in testing the application.
*
* @author roshanmuralidharan
* @version 1.0
* @since   2017-10-21 
*/
public class SolarmTestDriver {
        public static void main(String[] args) throws IOException {
            // Handler to retrieve different types of data from the Youtube API.
            YoutubeRetrieveHandler retriever = new YoutubeRetrieveHandler();
            
            // Call to perform a health check to confirm that authentication and retrieval works. 
            HealthCheckModel model = retriever.healthCheck();
            
            // Displaying the resul retrieved from the health check
            System.out.printf(
                "Channel-ID: %s | Title: '%s', and it has %s views.\n",
                model.getId(),
                model.getTitle(),
                model.getViewCount());
            
            // Test obtaining a video model for a keyword.
            // TODO: Switch to unit tests.
            VideoModel video = retriever.getUrlForKeyword("hymn for the weekend");
    }
}
