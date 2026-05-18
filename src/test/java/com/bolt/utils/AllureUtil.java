package com.bolt.utils;

import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
public class AllureUtil {


    public static void attachLog(String filePath) {
        try {
            Path path = Paths.get(filePath);

            if (Files.exists(path)) {
                byte[] content = Files.readAllBytes(path);

                Allure.addAttachment(
                        "Execution Log",
                        "text/plain",
                        new ByteArrayInputStream(content),
                        ".log"
                );
            } else {
                log.warn("Log file not found: {}", filePath);
            }

        } catch (Exception e) {
            log.error("Failed to attach execution log file: {}", filePath, e);
        }
    }
}
