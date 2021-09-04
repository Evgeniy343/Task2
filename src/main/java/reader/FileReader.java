package reader;

import java.io.File;

public class FileReader implements Reader {
    private static FileReader instance;

    FileReader() {
    }

    @Override
    public String read(File file) throws Exception {
        String text = "";
        String line;
        try (CustomResourceReader resourceReader = CustomResourceReader.of(file)) {
            while ((line = resourceReader.getBufferedReader().readLine()) != null) {
                if (line.equals("")) {
                    line = "\n";
                }
                text += line;
            }
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
