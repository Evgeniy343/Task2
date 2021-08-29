package reader;

import java.io.File;
import java.util.List;

public interface Reader {
    List<String> read(File file) throws Exception;
    static Reader newInstance(){
        return FileReader.getInstance();
    }
}
