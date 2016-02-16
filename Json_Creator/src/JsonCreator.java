import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonCreator {

	public static JSONObject createNode(JSONObject jsonObject, String key, String value) {
		jsonObject.put(key, value);
		return jsonObject;
	}

	public static JSONArray getChildNodeInArray(JSONObject... objs) {

		JSONArray jsonlist = new JSONArray();
		for(JSONObject obj : objs)
			jsonlist.add(obj);
		
		return jsonlist;
	}

	public static JSONObject createChildNode(JSONObject parentObject, String property, JSONArray arrayList) {

		parentObject.put(property, arrayList);
		return parentObject;

	}

	public static void main(String[] args) {
		JSONObject rootObject = new JSONObject();

		
		rootObject = createNode(rootObject, "text", "Root");
		rootObject = createNode(rootObject, "state", "open");
		
		
		JSONObject childNode = new JSONObject();
		childNode = createNode(childNode, "text", "Fruits");
		childNode = createNode(childNode, "state", "closed");
		
		
		//=========== leafs ==============================
		JSONObject leaf1 = new JSONObject();
		leaf1 = createNode(leaf1, "text", "apple");
		leaf1 = createNode(leaf1, "checked", "false");
		
		JSONObject leaf2 = new JSONObject();
		leaf2 = createNode(leaf2, "text", "banna");
		leaf2= createNode(leaf2, "checked", "false");
		
		JSONArray list = getChildNodeInArray(leaf1, leaf2);
		//===============================================
		
		
		
		JSONObject firstNode = createChildNode(childNode,"children",list);
		list = getChildNodeInArray(firstNode);
		
		JSONObject resultJson = createChildNode(rootObject, "children", list);
		
		
		JSONArray resultJSONList = new JSONArray();
		resultJSONList.add(resultJson);
		
	
		try {

			FileWriter file = new FileWriter("c:\\test.json");
			file.write(resultJSONList.toJSONString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.print(resultJson);

	}

}