package reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CustomResourceReader implements AutoCloseable {

    private final FileReader fileReader;
    private final BufferedReader bufferedReader;

    public CustomResourceReader(File file) throws FileNotFoundException {
        this.fileReader = new FileReader(file);
        this.bufferedReader = new BufferedReader(fileReader);
    }

    @Override
    public void close() throws Exception {
        fileReader.close();
        bufferedReader.close();
    }

    public static CustomResourceReader of(File file) throws FileNotFoundException {
        return new CustomResourceReader(file);
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }
}
