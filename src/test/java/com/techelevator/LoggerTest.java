package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LoggerTest {

    @Test
    public void test_Logs_Correct_Time() throws IOException {
        File testLog = new File("logs/testLog.txt");
        if(!(testLog.createNewFile())){//Creates a Blank testLog
            testLog.delete();
            testLog.createNewFile();
        }

        Logger logger = new Logger("logs/testLog.txt");
        logger.log("");

        try (Scanner input = new Scanner(testLog)){
            String s = input.nextLine();
            var localDateTime = java.time.LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyy hh:mm:ss a");
            String date = localDateTime.format(formatter) + " ";

            Assert.assertEquals(date.toLowerCase(), s.toLowerCase());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}