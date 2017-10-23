/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import AlarmHandlers.ClockCheckHandler;
import YoutubeDataModels.CommandInputModel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.regex.Pattern;

/**
 * Acts as the interface for the user and handles user input.
 *
 * @author roshanmuralidharan
 * @version 1.0
 * @since 2017-10-21
 */
public class CommandInterface {

    /**
     * Type of command entered. TODO: Switch to using an enum.
     */
    private static final String COMMAND_SET = "set";
    private static final String COMMAND_HELP = "help";
    private static final String COMMAND_EXIT = "exit";

    /**
     * ClockCheckHandler handler.
     */
    private static ClockCheckHandler clockCheckHandler;

    /**
     * Class main
     *
     * @param args Command-line arguments
     * @throws java.io.IOException
     * @throws java.net.URISyntaxException
     */
    public static void main(String[] args) throws IOException, URISyntaxException {

        // Print the header for the tool interface.
        printHeader();

        // Type of command entered. TODO: Switch to using an enum.
        String commandType = "";

        // Initialize clock check handler.
        clockCheckHandler = new ClockCheckHandler();
        clockCheckHandler.startClock();

        do {
            // Break command into tokens.
            //TODO: Fil nullpoint warning.
            String[] commandTokens = readUserInput().split(Pattern.quote("|"));

            // Store the type of command entered.
            commandType = commandTokens[0].toLowerCase().replace(" ", "");

            // Process different type of commands.
            switch (commandType) {
                case COMMAND_SET:
                    processSetCommand(commandTokens);
                    break;
                case COMMAND_HELP:
                    printUsage();
                    break;
                case COMMAND_EXIT:
                    break;
                default:
                    System.out.println("Invalid Command. Check 'help' to view format for  command.");
            }
            
            //Exit if 'exit' is entered as user input.
        } while (!COMMAND_EXIT.equals(commandType));
    }

    /**
     * Read input from user
     *
     * @return String entered by the user
     */
    private static String readUserInput() throws IOException {
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = reader.readLine();
        return userInput;
    }

    /**
     * Print the header for the command-line interface.
     *
     */
    private static void printHeader() {
        System.out.println("====== ----------------------------------------------------------- ======");
        System.out.println("======                        solarm                               ======");
        System.out.println("====== ----------------------------------------------------------- ======");
        System.out.println("====== A simple command-line alarm clock that plays youtube videos ======");
        System.out.println("====== ----------------------------------------------------------- ======");

        printUsage();
    }

    /**
     * Print a help to show usage.
     *
     */
    private static void printUsage() {
        System.out.println("====== ----------------------------------------------------------- ======");
        System.out.println("Set an alarm > set | <mmddyyyy> | <hhhh> | <Keywords for song>");
        System.out.println("Exit out     > exit");
        System.out.println("Print usage  > help");
        System.out.println("====== ----------------------------------------------------------- ======");
    }

    /**
     * Print a help to show usage.
     *
     */
    private static void processSetCommand(String[] commandTokens) {
        if (commandTokens.length == 4) {
            // Build command object from user input
            CommandInputModel command
                    = CommandInputModel.newBuilder()
                            .setCommand(commandTokens[0].replace(" ", ""))
                            .setDate(commandTokens[1].replace(" ", ""))
                            .setTime(commandTokens[2].replace(" ", ""))
                            .setSongKeywords(commandTokens[3].replace(" ", ""))
                            .build();

            clockCheckHandler.addAlarm(command);
        } else {
            System.out.println("Invalid Command. Check 'help' to view format for set command.");
        }
    }
}
