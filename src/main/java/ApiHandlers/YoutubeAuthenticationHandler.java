/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApiHandlers;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;

import com.google.api.services.youtube.YouTubeScopes;
import com.google.api.services.youtube.YouTube;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

/**
 * Handles authentication to the Youtube API Note - Adapted from the Quickstart
 * code provided in the API documentation.
 *
 * @author roshanmuralidharan
 * @version 1.0
 * @since 2017-10-21
 */
public class YoutubeAuthenticationHandler {

    /**
     * Application name.
     */
    private static final String APPLICATION_NAME = "solarm";

    /**
     * Directory to store user credentials for this application.
     */
    private static final java.io.File DATA_STORE_DIR = new java.io.File(
            System.getProperty("user.home"), ".credentials/solarm-credentials");

    /**
     * Global instance of the {@link FileDataStoreFactory}.
     */
    private static FileDataStoreFactory DATA_STORE_FACTORY;

    /**
     * Global instance of the JSON factory.
     */
    private static final JsonFactory JSON_FACTORY
            = JacksonFactory.getDefaultInstance();

    /**
     * Global instance of the HTTP transport.
     */
    private static HttpTransport HTTP_TRANSPORT;

    /**
     * Service handle.
     */
    private static YouTube youtube = null;

    /**
     * Global instance of the scopes required by this project.
     *
     * If modifying these scopes, delete your previously saved credentials at
     * ~/.credentials/drive-java-solarm
     */
    private static final List<String> SCOPES
            = Arrays.asList(YouTubeScopes.YOUTUBE_READONLY);

    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
        } catch (IOException | GeneralSecurityException t) {
            // TODO: Handle to use a default alarm in cade of failure. Display a failure message.
            System.exit(1);
        }
    }

    /**
     * Create an authorized Credential object.
     *
     * @return an authorized Credential object.
     * @throws IOException
     */
    private static Credential authorize() throws IOException {
        // Load client secrets.
        InputStream in
                = YoutubeAuthenticationHandler.class.getResourceAsStream("/client_secret.json");

        GoogleClientSecrets clientSecrets
                = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow
                = new GoogleAuthorizationCodeFlow.Builder(
                        HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                        .setDataStoreFactory(DATA_STORE_FACTORY)
                        .setAccessType("offline")
                        .build();

        Credential credential = new AuthorizationCodeInstalledApp(
                flow, new LocalServerReceiver()).authorize("user");

        return credential;
    }

    /**
     * Build and return an authorized API client service, such as a YouTube Data
     * API client service.
     *
     * @return an authorized API client service
     * @throws IOException
     */
    private static YouTube initService() throws IOException {
        Credential credential = authorize();

        return new YouTube.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    /**
     * Fetch the Youtube API client service handler.
     *
     * @return an authorized API client service
     * @throws IOException
     */
    public static YouTube getServiceHandler() throws IOException {
        // Lazy initialize the service handle.
        if (youtube == null) {
            youtube = initService();
        }

        return youtube;
    }
}
