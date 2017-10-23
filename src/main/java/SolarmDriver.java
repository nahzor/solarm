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
* Driver class to assist in testing the application.
*
* @author roshanmuralidharan
* @version 1.0
* @since   2017-10-21 
*/
public class SolarmDriver {
        public static void main(String[] args) throws IOException {
            YoutubeRetrieveHandler retriever = new YoutubeRetrieveHandler();
            
            HealthCheckModel model = retriever.healthCheck();
            
            System.out.printf(
                "Channel-ID: %s | Title: '%s', and it has %s views.\n",
                model.getId(),
                model.getTitle(),
                model.getViewCount());
            
            VideoModel video = retriever.getUrlForKeyword("hymn for the weekend");
    }
}
