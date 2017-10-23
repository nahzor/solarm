/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlarmHandlers;

import ApiHandlers.YoutubeRetrieveHandler;
import YoutubeDataModels.CommandInputModel;
import YoutubeDataModels.VideoModel;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Handles tracking current time, alarms, and triggering alarms.
 *
 * @author roshanmuralidharan
 * @version 1.0
 * @since 2017-10-21
 */
public class ClockHandler {

    /**
     * One second represented as milli-seconds
     */
    private static final Integer ONE_SECOND_IN_MS = 1000;

    /**
     * One second represented as milli-seconds. 
     * We need not perform a clock-check every iteration as the alarm 
     * is only specific to the minute.
     */
    private static final Integer CLOCK_CHECK_DELAY_IN_SECONDS = 30;

    /**
     * Handle to the SolClock class
     */
    private Clock clock;

    /**
     * Handle to the SolClock class
     */
    private HashMap<String, VideoModel> dateTimeToVideoMap;

    /**
     * Starts the clock thread.
     */
    public void startClock() {
        dateTimeToVideoMap = new HashMap<>();
        clock = new Clock();
        clock.start();
    }

    /**
     * Stores the a newly added alarm in the internal store TODO: Persist
     * externally
     *
     * @param alarm CommandInputModel object processed from user input
     */
    public void addAlarm(CommandInputModel alarm) {

        // Handler to assist in hitting the youtube API
        YoutubeRetrieveHandler retriever = new YoutubeRetrieveHandler();

        // Retrieving the VideoModel object for the keywords in the user input.
        VideoModel video = retriever.getUrlForKeyword(alarm.getSongKeywords());

        // Add the retrieved URL to the store.
        // TODO: Handle case where video was not found for the keywords.
        dateTimeToVideoMap.put(alarm.getDate() + alarm.getTime(), video);
        
        // TODO: Switch to use a print-to-console method / logging framework.
        // TODO: Display time and date. Assume user manually checks that his date time is in valid format.
        if(video != null){
            System.out.println("Successfully added alarm with video: "+video.getTitle());
        }else{
            System.out.println("Video not found for keywords or user not authorized. Try again.");
        }
    }

    /**
     * Remove an alarm that the user does not want anymore or one that was
     * processed already. Note: This requires exact time and date. TODO: Process
     * command for a range. Eg - Remove for a complete day, week, etc.
     *
     * @param alarmKey The key formed using the alarm date and time. Format -
     * mmddyyyyhhmm
     */
    public void removeAlarm(String alarmKey) {

        // Remove alarm from the map
        dateTimeToVideoMap.remove(alarmKey);
    }

    /**
     * Internal class for the clock monitoring thread.
     *
     * @author roshanmuralidharan
     * @version 1.0
     * @since 2017-10-21
     */
    class Clock extends Thread {

        @Override
        public void run() {
            while (true) {

                // Fetch current date and time.
                DateTimeFormatter dtTmFormat = DateTimeFormatter.ofPattern("MMddyyyyHHmm");
                LocalDateTime now = LocalDateTime.now();
                String dateTime = dtTmFormat.format(now);

                // Trigger call to alarm-handler if and alarm exists for the current date and time.
                if (dateTimeToVideoMap != null && dateTimeToVideoMap.containsKey(dateTime)) {

                    // Retrieve the video to be played as the alarm.
                    VideoModel video = dateTimeToVideoMap.get(dateTime);

                    try {
                        // Trigger alarm
                        AlarmTriggerHandler.triggerYoutubeAlarm(video.getId());
                    } catch (URISyntaxException | IOException ex) {
                        Logger.getLogger(ClockHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    // Remove alarm that was already processed.
                    removeAlarm(dateTime);
                }

                try {
                    // We do not perform clock check every iterations.
                    sleep(CLOCK_CHECK_DELAY_IN_SECONDS * ONE_SECOND_IN_MS);
                } catch (InterruptedException e) {
                    //TODO: Handle exception
                }
            }
        }
    }
}
