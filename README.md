# Bowling Scoring App

This app allows knowing the complete scoring in a classic bowling game for one or more players. This program receives the file name where the players are with the rolls for each, and, process it in the following way:

1. Read the text file
2. Load the data in a HashMap
3. Initialize a Game with the limits
4. Build the players with the rolls in each Frame
5. Calculate the score for each Frame
6. Set the score for each player
7. Show the scoring in the console

## Requirements

1. Java -v 8 (or higher) [Check the docs](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html)
2. Maven -v 3.8.1  [Check the docs](https://maven.apache.org/download.cgi)

### Verify Requirements
```bash
java --version
javac --version
mvn --version
```

## Team

[@sahydo ](https://sahydo.com)

[Jobsity Remote Repo](https://git.jobsity.com/sahydo/JavaChallenge/-/tree/develop)

## Notes

All commands must be executed at the root of the project.
```
cd WORKSPACE
```

## Development

When you make changes, you have to clean the /target dir, run tests, and install dependencies, with the following maven command:

```
mvn clean install
```

## Testing

To run Unit and Integrations tests, you have to run the following maven command:

```
mvn test
```

## Packing

When you've finished changes, you can compile the source code and package it in a .jar file with the following maven command:

```
mvn package
```

## Run the App

To run the App, first, you have to package your code with the previous command, and next, you have to run the following java command:

```
java -cp target/bowling-scoring-1.0-SNAPSHOT.jar com.jobsity.app.App FILE_PATH
```

**FILE_PATH** could be a relative path or an absolute path. e.g:

/Users/sahydo/Documents/rolls.txt

or move the file to the root of the project:

rolls.txt

## Maven site

To know about the project you can generate and visite the project's local site:

```
mvn site
```
Open the [project site](./target/site/index.html) 
