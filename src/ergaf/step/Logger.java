package ergaf.step;

import java.io.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Logger {
    File file = new File("application.log");

    public void log(Enum<LogOrError> whyThis, String info) {
        createFileIfNotExist();
        LocalDateTime logDateTime = new Timestamp(System.currentTimeMillis()).toLocalDateTime();

        try {
            FileWriter writer = new FileWriter(file.getAbsoluteFile(), true);
            writer.append(String.valueOf(logDateTime.getDayOfMonth()))
                    .append("/")
                    .append(String.valueOf(logDateTime.getMonthValue()))
                    .append("/")
                    .append(String.valueOf(logDateTime.getYear()))
                    .append(" ")
                    .append(String.valueOf(logDateTime.getHour()))
                    .append(":")
                    .append(String.valueOf(logDateTime.getMinute())).append("   [").append(String.valueOf(whyThis)).append("]   ")
                    .append("[").append(info).append("]")
                    .append("\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void createFileIfNotExist() {
        if (file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
