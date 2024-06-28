package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private final File file;

    public Logger(String logFile){
        this.file = new File(logFile);
    }

    public void log(String message){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyy hh:mm:ss a");
        String dateTime = localDateTime.format(formatter);

        try (FileWriter fileWriter = new FileWriter(file, true)){
            fileWriter.append(dateTime).append(" ").append(message).append("\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}