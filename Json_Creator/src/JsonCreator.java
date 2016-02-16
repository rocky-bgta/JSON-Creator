import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonCreator {

    public static JSONObject createParent(JSONObject jsonObject,String key, String value) {
	jsonObject.put(key, value);
	return jsonObject;
    }
    
    public static JSONArray createJsonList(List list){
	
	JSONArray jsonlist = new JSONArray();
	for(int i=0; i<list.size(); i++){
	    jsonlist.add(list.get(i));
	}
	return jsonlist;
    }
    
    public static JSONObject createChild(JSONObject parentObject, String property,  JSONArray arrayList) {
	
	parentObject.put(property, arrayList);
   	return parentObject;
   	
       }
       
    

    public static void main(String[] args) {
	JSONObject mainObject = new JSONObject();
	
	mainObject = createParent(mainObject,"id", "1");
	mainObject = createParent(mainObject,"text", "Foods");
	mainObject = createParent(mainObject,"state", "closed");
	
	
	
	
	JSONObject obj = new JSONObject();
	obj.put("name", "mkyong.com");
	obj.put("age", new Integer(100));

	JSONObject childObjec = new JSONObject();
	childObjec.put("id", 2);
	childObjec.put("text", "Vegetables");
	childObjec.put("state", "open");

	JSONObject childObjec3 = new JSONObject();
	childObjec3.put("id", 3);
	childObjec3.put("text", "Fruits");
	childObjec3.put("state", "closed");

	JSONArray list = new JSONArray();
	list.add(childObjec);
	list.add(childObjec3);
	list.add("msg 3");

	obj.put("messages", list);

	try {

	    FileWriter file = new FileWriter("c:\\test.json");
	    file.write(obj.toJSONString());
	    file.flush();
	    file.close();

	} catch (IOException e) {
	    e.printStackTrace();
	}

	System.out.print(obj);

    }

}