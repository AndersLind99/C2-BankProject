package domain;

import java.io.*;
import java.util.Date;

public class BankException extends Exception {

    public BankException(String message) {
        super(message);
    }

    public static void addLogMessage(Exception e) throws IOException {

        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        String exceptionAsString = stringWriter.toString();

        File file = new File("bankException.txt");
        Date date = new Date();

        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write(date.toString() + ": " + exceptionAsString + "\n");
        fileWriter.close();

    }

}



