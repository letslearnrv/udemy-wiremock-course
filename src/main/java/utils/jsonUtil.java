package utils;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class jsonUtil {

    public JSONObject jsonObject;
    private File file;

    public JSONObject getJSON()
    {
        return  jsonObject;
    }

    public jsonUtil setJSON(String filename)
    {
        file= new File(System.getProperty("user.dir") +"/src/main/resources/__files/"+filename);
        InputStream inputStream =null;

        try{
            inputStream=new FileInputStream(file);
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        JSONTokener jsonTokener= new JSONTokener(inputStream);

        jsonObject=new JSONObject(jsonTokener);
        return this;
    }

}
