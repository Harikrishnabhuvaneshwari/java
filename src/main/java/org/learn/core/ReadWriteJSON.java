package org.learn.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadWriteJSON {
public static void main(String[] args) throws IOException, ParseException {
	FileReader reader = new FileReader(new File("/Users/hprakash/work/sts/java/src/main/java/org/learn/core/budget.json"));
    JSONParser jsonParser = new JSONParser();
    JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
    System.out.println(jsonObject);

    JSONObject idObj = (
             (JSONObject) (
                (JSONObject)
                   jsonObject.get("variables")
             ).get("add_data")
    );

    idObj.put("budget_name", "eee");
    
    FileWriter fileWriter = new FileWriter(new File("/Users/hprakash/work/sts/java/src/main/java/org/learn/core/budget.json"));
    jsonObject.writeJSONString(fileWriter);
    fileWriter.close();
    
    System.out.println("After ID value updated : "+jsonObject);
}
}
