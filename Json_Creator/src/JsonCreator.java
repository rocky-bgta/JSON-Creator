import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/*"id":1,
"text":"Foods",
"children":*/

/*"id":2,
"text":"Fruits",
"state":"closed",*/


    
    

public class JsonCreator {

    
    public static void main(String[] args) {


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