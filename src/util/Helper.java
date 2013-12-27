package util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Helper {
	
	public static <T> JSONArray convertFromList(List<T> list) {
		JSONArray ja = new JSONArray();
		
		if (list == null) {
			return ja;
		}
		
		for (T t : list) {
			ja.put(new JSONObject(t));
		}
		
		return ja;
	}
	
	public static <T1, T2> JSONArray convertFromMap(Map<T1, T2> map) {
		JSONArray ja = new JSONArray();
		
		if (map == null) {
			return ja;
		}

		
		 for (Map.Entry<T1, T2> entry : map.entrySet()) {
			   T1 key = entry.getKey();
			   T2 value = entry.getValue();
			   JSONObject jo = new JSONObject();
			   try {
				jo.put(new JSONObject(key).toString(), value);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   ja.put(jo);
		 }
		
		return ja;
	}
}
