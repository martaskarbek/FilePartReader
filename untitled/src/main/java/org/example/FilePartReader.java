package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilePartReader {

    private String filePath;
    private int fromLine;
    private int toLine;

    public FilePartReader() {
        this.filePath = "filePath";
        this.fromLine = 0;
        this.toLine = 0;
    }

    public void setup(String filePath, int fromLine, int toLine) {
        if (toLine < fromLine || fromLine < 0) {
            throw  new IllegalArgumentException("You are putting here invalid values.");
        }
        setFilePath(filePath);
        setFromLine(fromLine);
        setToLine(toLine);
    }

    public String read(String filePath) throws IOException {
        StringBuilder filecontent= new StringBuilder();
        String fileLine = "";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        if (toLine == 0) {
            while ((fileLine = reader.readLine()) != null){
                filecontent.append(fileLine);
                filecontent.append(" ");
                fromLine += 1;
            }
            reader.close();
        return filecontent.toString();
        }
        if (toLine != 0){
            fromLine = fromLine - 1;
            while (fromLine < toLine) {
                fileLine = Files.readAllLines(Paths.get(filePath)).get(fromLine);
                filecontent.append(fileLine);
                filecontent.append(" ");
                fromLine += 1;
            }
        }
        reader.close();
        return filecontent.toString();
    }

    public String readLines(String filePath, int fromLine, int toLine) throws IOException {
        setup(filePath, fromLine, toLine);
        return read(filePath);
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setFromLine(int fromLine) {
        this.fromLine = fromLine;
    }

    public void setToLine(int toLine) {
        this.toLine = toLine;
    }

    public String getFilePath() {
        return filePath;
    }

    public int getFromLine() {
        return fromLine;
    }

    public int getToLine() {
        return toLine;
    }
}
