package reader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileReader implements Reader {
    private static FileReader instance;

    FileReader(){
    }

    @Override
    public List<String> read(File file) throws Exception{
        List<String> text = new ArrayList<>();
        String line;
        try (CustomResourceReader resourceReader = CustomResourceReader.of(file)){
            while((line = resourceReader.getBufferedReader().readLine()) != null){
                text.add(line);
            }
        }
        return text;
    }

    public static FileReader getInstance(){
        if(instance != null){
            instance = new FileReader();
        }
        return instance;
    }
}
