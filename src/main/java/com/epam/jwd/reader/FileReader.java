package com.epam.jwd.reader;

import java.io.File;
import java.io.IOException;

public class FileReader implements Reader {
    private static FileReader instance;

    FileReader() {
    }

    @Override
    public String read(File file) throws Exception {
        String text = "";
        try (CustomResourceReader resourceReader = CustomResourceReader.of(file)) {
            text = readText(text, resourceReader);
        }
        return text;
    }

    private String readText(String text, CustomResourceReader resourceReader) throws IOException {
        String line;
        while ((line = resourceReader.getBufferedReader().readLine()) != null) {
            if (line.equals("")) {
                line = "\n";
            }
            text += line;
        }
        return text;
    }

    public static FileReader getInstance() {
        if (instance == null) {
            instance = new FileReader();
        }
        return instance;
    }
}
