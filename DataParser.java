import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class DataParser {
    
    private List<String> fileData;

    private List<List<Double>> dataPoints;



    DataParser(String filePath)
    {
        DataFileReader DataFileRead = new DataFileReader(filePath);
        fileData = DataFileRead.getLines();

        dataPoints = new ArrayList<>();

        for(int i = 0; i < fileData.size(); i++)
        {
            List<Double> dataLineDouble = new ArrayList<>();
            List<String> dataLineString = Arrays.asList( fileData.get(i).split(";") );
            for(int j = 0; j < dataLineString.size(); j++)
            {
                dataLineDouble.add( Double.parseDouble(dataLineString.get(j)) );
            }
            dataPoints.add(dataLineDouble);
        }
    }

    public List<List<Double>> getDataPoints()
    {
        return dataPoints;
    }
}
