package com.sofka.demo;

import java.util.HashMap;
import java.util.Map;

public class Utils {

	public static Map<String, Object> mapear(boolean status, String msg, Object data) {
		Map<String, Object> respuesta = new HashMap<>();
		respuesta.put("msg", msg);
		respuesta.put("data", data);
		respuesta.put("status", status);
		return respuesta;
	}

}
