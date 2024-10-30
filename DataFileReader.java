import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.List;
import java.util.Arrays;

public class DataFileReader {

    private List<String> fileLines;

    BufferedReader br;

    private String filePath;

    DataFileReader(String filePath)
    {
        this.filePath = filePath;
        fileLines = new ArrayList<>();

        try
        {
            br = new BufferedReader(new FileReader(filePath));
            String line;
            while((line = br.readLine()) != null)
                fileLines.add(line);



        }
        catch(Exception e)
        {
            e.getMessage();
        }

    }

    public List<String> getLines()
    {
        return fileLines;
    }
    
}
