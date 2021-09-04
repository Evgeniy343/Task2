package reader;

import java.io.File;

public interface Reader {
    String read(File file) throws Exception;

    static Reader newInstance() {
        return FileReader.getInstance();
    }
}
