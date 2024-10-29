package edu.kh.data.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class APIController {
	
	private static final String serviceKey = "xsaCR6AKxIsM3IwyTXLRQr7nNSw5e0Eb0ehRnSDZ%2FrurJHZg6jwkcbe%2Bmz4N%2BQrQSHDdR%2BSCgJAT2JqqNLJYSw%3D%3D";
	
	@ResponseBody
	@RequestMapping(value="busInfo", produces="application/json; charset=utf-8")
	public String busInfo() throws Exception{
		
		String url = "http://apis.data.go.kr/1613000/BusRouteInfoInqireService/getRouteAcctoThrghSttnList";
		url += "?serviceKey=" + serviceKey;
		url += "&cityCode=25";
		url += "&routeId=DJB30300004";
		url += "&_type=json";
		
		URL requestUrl = new URL(url);

		HttpURLConnection urlConnection = (HttpURLConnection)requestUrl.openConnection();

		urlConnection.setRequestMethod("GET");

		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

		String responseData = "";
		String line; 

		while((line = br.readLine()) != null) {
			responseData += line;
		}
		
		br.close();

		urlConnection.disconnect(); 

		System.out.println("responseData::" + responseData);
				
		return responseData;

		
	}
	
}
