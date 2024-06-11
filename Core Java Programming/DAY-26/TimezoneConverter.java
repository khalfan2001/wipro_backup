package com.day26;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimezoneConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        System.out.println("Enter the date and time (yyyy-MM-dd HH:mm): ");
        String dateTimeString = scanner.nextLine();
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeString, formatter);

        System.out.println("Enter the source timezone (e.g., America/New_York): ");
        String sourceTimeZone = scanner.nextLine();
        ZonedDateTime sourceZonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of(sourceTimeZone));

        System.out.println("Enter the target timezone (e.g., Europe/London): ");
        String targetTimeZone = scanner.nextLine();
        ZonedDateTime targetZonedDateTime = sourceZonedDateTime.withZoneSameInstant(ZoneId.of(targetTimeZone));

        System.out.println("Converted time: " + targetZonedDateTime.format(formatter));
    }
}