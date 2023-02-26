package com.epam.mjc.nio;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Path path = Paths.get(file.getPath());
        Profile profile = new Profile();

        try(BufferedReader reader = Files.newBufferedReader(path)){
            String currLine = null;
            while ((currLine = reader.readLine()) != null){
                String[] str = currLine.split(": ");
                switch (str[0]) {
                    case "Name":
                        profile.setName(str[1]);
                        break;
                    case "Age":
                        profile.setAge(Integer.parseInt(str[1]));
                        break;
                    case "Email":
                        profile.setEmail(str[1]);
                        break;
                    case "Phone":
                        profile.setPhone(Long.parseLong(str[1]));
                        break;
                    default:
                        break;
                }
            }
            return profile;
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
