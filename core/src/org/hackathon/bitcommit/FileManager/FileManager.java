package org.hackathon.bitcommit.FileManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by codecadet on 25/11/16.
 */
public class FileManager {

    public FileManager() {
    }

    public static String readFile(String path) {

        BufferedReader breader = null;
        String line = "";
        String result = "";

        try {
            breader = new BufferedReader(new FileReader("core/assets/scores.txt"));

            while ((line = breader.readLine()) != null) {
                result += line;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }



    public static void writeFile(String highScore, String path) throws IOException {

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(path);
            //para escrever, o método recebe um array de chars
            fileWriter.write(highScore);
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            //so se o ficheiro for aberto é que pode ser fechado
            if (fileWriter != null) {
                fileWriter.close();
            }
        }
    }
}
