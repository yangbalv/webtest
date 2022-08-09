package com.webapp.util;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class HttpHelper {
    public static Logger logger = LoggerFactory.getLogger(HttpHelper.class);

    public static String post(Map<String, Object> message, String path) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        URL url = new URL(path);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
        httpURLConnection.connect();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
        bufferedWriter.write(JSONObject.toJSONString(message));
        bufferedWriter.close();

        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            logger.info("bed request for: {},responseCode is: {}, and the request is: {}", path, responseCode, JSONObject.toJSONString(message));
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuffer.append(line + "\n");
        }
        logger.info(" end the postRequest of url: {}", path);
        return stringBuffer.toString();
    }

}
