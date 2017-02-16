--- Pre-requisites ---

Application is built on spring boot and requires java8 and maven to run.

Application runs on port 8080, please ensure this port isn't taken by navigating to:

http://localhost:8080

--- Build and Run ---

To build, ensure you are in the app-webapp folder, and type the following in the terminal/command prompt:

On a mac:

./run.sh

which has just combined the build and run steps without having to worry about changing version number:

mvn clean package

java -jar target/weather-app-0.0.1-SNAPSHOT.jar

On windows, it will likely be (I have no way to verify this though):

mvn clean package

java -jar target\weather-app-0.0.1-SNAPSHOT.jar

** Nb. Please verify file name in target folder

--- To test --

Navigate to the index page at:

http://localhost:8080/

or 

http://localhost:8080/index

Enter location, and search for the results.

--- To do ---

Unfortunately time was short. Can always improve on an application.

Could do with error handling. Throw exception on missing or invalid location.

Logging is insufficient and incorrectly set up.

Sunrise and Sunset times displayed as GMT. Specification requested times only, but this is unintuitive when searching for a location such as Hong Kong, where sunrise time is after sunset. Ideally to support this requirement, you'd likely want to display time format in the timezone of the location using that locale. For now, times are displayed with date in GMT as it is the most intuitive output.

API Key is a secret and should not be stored in config/code but passed into app as secret and not visible in build logs etc, could be stored encrypted and decrypt by passing into app decryption password...

Incorrect way to retrieve location from form. Spring has a better way. Temporary tactical fix used.