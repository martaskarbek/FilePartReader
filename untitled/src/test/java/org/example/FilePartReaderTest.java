package org.example;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

class FilePartReaderTest {

    FilePartReader filePartReader = Mockito.mock(FilePartReader.class);

    @Test
    public void isPathToFileSettingPropertly() {
        String path = "testPath.exe";
        filePartReader.setFilePath(path);
        filePartReader.getFilePath();
        Mockito.verify(filePartReader).getFilePath();
    }

    @Test
    public void isFromLineValueSettingPropertly() {
        filePartReader.setFromLine(6);
        filePartReader.getFromLine();
        Mockito.verify(filePartReader).getFromLine();
    }

    @Test
    public void isToLineValueSettingPropertly() {
        filePartReader.setToLine(7);
        filePartReader.getToLine();
        Mockito.verify(filePartReader).getToLine();
    }

    @Test
    public void isFileReadedPropertly() throws IOException {
        String expected = "First line second line third line";
        Mockito.when(filePartReader.read("src/main/java/org/example/test.txt")).thenReturn(expected);
        filePartReader.read("src/main/java/org/example/test.txt");
        Mockito.verify(filePartReader).read("src/main/java/org/example/test.txt");
    }

    @Test
    public void isFileReadedPropertlyWithLinesGiven() throws IOException {
        String expected = "second line third line";
        Mockito.when(filePartReader.readLines("src/main/java/org/example/test.txt", 2, 3))
                .thenReturn(expected);
        filePartReader.readLines("src/main/java/org/example/test.txt", 2, 3);
        Mockito.verify(filePartReader).readLines("src/main/java/org/example/test.txt", 2, 3);
    }

    @Test
    public void isWrongDataGivenThrowingException() {
        FilePartReader filePartReader = new FilePartReader();
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            filePartReader.setup("path", 4, 1);
        });

        String expectedMessage = "You are putting here invalid values.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}