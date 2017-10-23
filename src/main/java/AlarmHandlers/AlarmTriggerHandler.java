/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlarmHandlers;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Handles functionality to trigger an alarm. TODO: Extend for services other
 * than Youtube. 
 * TODO: Move config to external file(yaml)
 *
 * @author roshanmuralidharan
 * @version 1.0
 * @since 2017-10-21
 */
public class AlarmTriggerHandler {

    /**
     * Base url to which the video ID is attached to.
     */
    private static final String YOUTUBE_BASE_URL = "http://www.youtube.com/watch?v=";

    /**
     * Triggers the Youtube video in the default browser as the alarm.
     *
     * @param videoId The unique id of the video that is attached to the base
     * Youtube URL.
     * @throws URISyntaxException
     * @throws java.io.IOException
     */
    public static void triggerYoutubeAlarm(String videoId) throws URISyntaxException, IOException {

        // Handle to access desktop functionality
        Desktop desktop = Desktop.getDesktop();

        // Trigger video in a browser
        desktop.browse(new URI(YOUTUBE_BASE_URL + videoId));
    }
}
