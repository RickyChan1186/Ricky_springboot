package com.ricky.example.util;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@Component
public class HttpUtil {

	public static String token = "";
	public static String get(String url,Map<String,String> map) {
		if(!login())return "";
		if(!token.equals("")){
			url+="?access_token="+token;
		}
		if(map!=null){
			for(Entry<String,String> entry : map.entrySet()){
				if(entry.getValue()!=null){
					url+="&"+entry.getKey()+"="+entry.getValue();
				}

			}
		}
		Connection con=Jsoup.connect(url);
		con.header("Accept", "application/json");
		con.timeout(60000);
		con.ignoreContentType(true);
		try {
			Document doc=con.get();
			return doc.text();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 处理没有登录的请求
	 * @param url
	 * @param map
	 * @return
	 */
	public static String getByNoLogin(String url,Map<String,String> map) {
		url+="?1=1";
		if(map!=null){
			for(Entry<String,String> entry : map.entrySet()){
				if(entry.getValue()!=null){
					url+="&"+entry.getKey()+"="+entry.getValue();
				}

			}
		}
		Connection con=Jsoup.connect(url);
		con.header("Accept", "application/json");
		con.timeout(60000);
		con.ignoreContentType(true);
		try {
			Document doc=con.get();
			return doc.text();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static String Post(String url,Map<String,String> map) {
		if(!login())return "";

		if(!token.equals("")){
			url+="?access_token="+token;
		}
		Connection con=Jsoup.connect(url);
		con.header("Accept", "application/json");
		con.timeout(60000);
		con.ignoreContentType(true);
		try {
			
			if(map!=null){
				for(Entry<String,String> entry : map.entrySet()){
					if(entry.getValue()!=null){
						con.data(entry.getKey(), entry.getValue());
					}
				}
			}
			Document doc=con.post();
			return doc.text();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 处理没有登录的POST请求
	 * @param url
	 * @param map
	 * @return
	 */
	public static String PostNoLogin(String url,Map<String,String> map) {
		Connection con=Jsoup.connect(url);
		con.header("Accept", "application/json");
		con.timeout(60000);
		con.ignoreContentType(true);
		try {
			if(map!=null){
				for(Entry<String,String> entry : map.entrySet()){
					if(entry.getValue()!=null){
						con.data(entry.getKey(), entry.getValue());
					}
				}
			}
			Document doc=con.post();
			return doc.text();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	
	public static boolean login() {
		Map<String,String> map = new HashMap<>();
		map.put("grant_type","password");
		map.put("client_id","demoApp1");
		map.put("client_secret","demoAppSecret");

		Connection con=Jsoup.connect("http://68.34.21.8:8888/sso-server/sso/oauth/token");
		con.header("Accept", "application/json");
		con.timeout(60000);
		con.ignoreContentType(true);
		try {
			if(map!=null){
				for(Entry<String,String> entry : map.entrySet()){
					if(entry.getValue()!=null){
						con.data(entry.getKey(), entry.getValue());
					}
				}
			}
			Document doc=con.post();
			String str =  doc.text();
			JSONObject userObj = JSONObject.parseObject(str);
			HttpUtil.token = userObj.getString("access_token");
			System.out.println("启动Http Init 获取token成功(登录成功)" );
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public static String postRequst(String url, String jsonStr) {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();

		HttpPost httpPost = new HttpPost(url);
		httpPost.addHeader("content-type", "application/json");
		httpPost.addHeader("Accept", "application/json");
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000).setSocketTimeout(100000).build();
		httpPost.setConfig(requestConfig);

		StringEntity entity = new StringEntity(jsonStr, ContentType.APPLICATION_JSON);
		httpPost.setEntity(entity);
		CloseableHttpResponse response = null;

		try {
			response = httpClient.execute(httpPost);

			String statusCode = response.getStatusLine().getStatusCode() + "";


			String content = EntityUtils.toString(response.getEntity(), "utf-8");

			System.out.println("code[" + statusCode + "]:" + content);

			return content;
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Http请求失败："+e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Http请求失败："+e.getMessage());
		}
//		return null;
	}

	public static String postRequst(String url,Map<String,Object>map){
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost httpPost = new HttpPost(url);
		HttpEntity entity=null;

		List<BasicNameValuePair> pairList = createParam(map);

		try {
			httpPost.setEntity(new UrlEncodedFormEntity(pairList,"utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		CloseableHttpResponse response = null;

		try {
			response = httpClient.execute(httpPost);

			String statusCode = response.getStatusLine().getStatusCode() + "";
			String content = EntityUtils.toString(response.getEntity(), "utf-8");
			System.out.println("code[" + statusCode + "]:" + content);
			return content;
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Http请求失败："+e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Http请求失败："+e.getMessage());
		}
	}

	public static String getRequst(String url) {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();

		HttpGet httpGet = new HttpGet(url);
		httpGet.addHeader("content-type", "application/json");
		httpGet.addHeader("Accept", "application/json");
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000).setSocketTimeout(100000).build();
		httpGet.setConfig(requestConfig);

		CloseableHttpResponse response = null;

		try {
			response = httpClient.execute(httpGet);

			String statusCode = response.getStatusLine().getStatusCode() + "";


			String content = EntityUtils.toString(response.getEntity(), "utf-8");

			System.out.println("code[" + statusCode + "]:" + content);

			return content;
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Http请求失败："+e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Http请求失败："+e.getMessage());
		}
//		return null;
	}

	//
	public static String upload(String url,String localFile){
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		try {
			httpClient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(url);
			FileBody bin = new FileBody(new File(localFile));
			File file = new File(localFile);
			HttpEntity httpEntity = MultipartEntityBuilder.create()
					.addPart("filedata",bin)
					.build();

			httpPost.setEntity(httpEntity);

			response = httpClient.execute(httpPost);

			//获取相应对象
			HttpEntity resEntity = response.getEntity();
			String returnS="";
			if(resEntity != null){
				returnS =  EntityUtils.toString(resEntity, Charset.forName("UTF-8"));
			}else{
				returnS = "";
			}
			EntityUtils.consume(resEntity);
			return returnS;
		}catch (Exception e){
			e.printStackTrace();
			throw new RuntimeException("文件上传失败："+e.getMessage());
		}finally {
			try{
				if(response != null){
					response.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				if(httpClient != null ){
					httpClient.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	private static List<BasicNameValuePair> createParam(Map<String,Object> param){
		//建立一个NamevaluePair数组，用于存储传送的参数
		List<BasicNameValuePair> nvps = new ArrayList<>();
		if(param != null){
			for(String k : param.keySet()){
				nvps.add(new BasicNameValuePair(k,param.get(k).toString()));
			}
		}
		return nvps;
	}
}
