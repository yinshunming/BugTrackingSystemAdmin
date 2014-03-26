package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.impl.BuginfoDAOImpl;
import dao.impl.ManagedbugsDAOImpl;

public class Helper {

		
	public static void main (String args[]) {
		List<String> list = new ArrayList<String>();
		list.add("abc");
		System.out.println(Helper.convertFromList(list));
	}
	
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
	
	public static <String, T2> JSONArray convertFromMap(Map<String, T2> map) {
		JSONArray ja = new JSONArray();
		
		if (map == null) {
			return ja;
		}

		for (Map.Entry<String, T2> entry : map.entrySet()) {
			   String key = entry.getKey();
			   T2 value = entry.getValue();
			   JSONObject jo = new JSONObject();
			   try {
				jo.put(key.toString(), value);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   ja.put(jo);
		 }
		
		
		return ja;
	}
	
	/**
	 * encrypt in SHA-1
	 * 
	 * @param info 
	 *  before encryption
	 *            
	 * @return String 
	 * after encryption
	 */
	public static  String encryptToSHA(String info) {
		byte[] digesta = null;
		try {
			MessageDigest alga = MessageDigest.getInstance("SHA-1");
			alga.update(info.getBytes());
			digesta = alga.digest();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		String rs = byte2hex(digesta);
		return rs;
	}
	
	/**
	 * convert binary to  hexadecimal string
	 * 
	 * @param b
	 *            binary array
	 * @return String
	 */
	public static  String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1) {
				hs = hs + "0" + stmp;
			} else {
				hs = hs + stmp;
			}
		}
		return hs.toUpperCase();
	}
}
