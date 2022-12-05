package com.hnm.template;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 12/5/2022.
 */

@Log4j2
public class FileUtils {
    public static List<String> read(String path) {

        List<String> data = new ArrayList<>();

        // try-with-resources
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {

            String line = br.readLine();
            while (line != null) {
                data.add(line);
                line = br.readLine();
            }
        } catch (IOException ex) {
            log.error("(read) read file error -ex: {}", ex);
        }

        return data;
    }

    public static void write(List<String> data, String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (String value : data) {
                bw.write(value);
                bw.write("\n");
            }
            bw.close();
        } catch (Exception ex) {
            log.info("(write) write file error -ex: {}", ex);
        }
    }

    public static void write(List<String> data) throws IOException {
        Path out = Paths.get("output.txt");
        Files.write(out, data, Charset.defaultCharset());
    }
}
