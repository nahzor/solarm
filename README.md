# solarm
* Short for song alarm.
* A simple command-line application to set alarms to play youtube vdeos.
* Once an alarm is set, the application triggers that youtube video in the default browser.
* The user is in control of having a browser on the system and to have the youtube/system volume set at the required level.

## Versions Used
* [Gradle 4.2.1](https://gradle.org/install/)
* [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

## API Access
* Refer to the [quickstart](https://developers.google.com/youtube/v3/quickstart/java) documentation to create a project and create keys.
* Download the json with the client secret, rename it to 'client_secret.json' and save it under '<path>/solarm/src/main/resources'. (Replace the existing one, if there is one, that is added as a template.)

## Use with command-line
* > gradle -q run

## Use with Netbeans
* Get [Netbeans](https://netbeans.org/downloads/)
* Add the Gradle plugin from 'Tools > Plugins > Available plugins > Gradle (Search for it if you don't find it in the list)'
* Import project using 'File > Open project > ...'
* Thats it! Build and Run the project.

## Usage example
![solarm usage](https://github.com/rosh89/solarm/blob/master/solarm_usage.png "Solarm Usage")

## TODO
* Functionality to list and delete alarms, setting alarms with a duration value, providing URLs directly instead of keywords, setting repeating alarms.
* Unit tests
* Error Logging.
* Address TODOs in the comments in the code.
* Serializing alarm data to a file so that they can be retrieved when the application is reopened.
* Bug: lock dateTimeToVideoMap.



