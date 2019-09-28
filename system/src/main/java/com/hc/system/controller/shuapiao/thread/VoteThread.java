package com.hc.system.controller.shuapiao.thread;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;

import com.hc.system.controller.shuapiao.pojo.IpInfo;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;



public class VoteThread extends Thread {
    private BlockingQueue<IpInfo> ipInfoQueue;

    public VoteThread(BlockingQueue<IpInfo> ipInfoQueue) {
        this.ipInfoQueue = ipInfoQueue;
    }
    final String CONTENT_TYPE_TEXT_JSON = "text/json";
    @Override
    public void run() {
        HttpClient client = new DefaultHttpClient();
        HttpParams params = client.getParams();
        HttpConnectionParams.setConnectionTimeout(params, 10000);
        HttpConnectionParams.setSoTimeout(params, 15000);
        HttpResponse response = null;
        HttpPost get = null;
        HttpEntity entity = null;
        HttpHost proxy = null;
        while (true) {
            IpInfo ipInfo = null;
            try {
                ipInfo = ipInfoQueue.take();
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            proxy = new HttpHost(ipInfo.getIpAddress(), ipInfo.getPort());
            client.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY,
                    proxy);
            get = new HttpPost(
                    "https://nctrain.streamsoft.cn/api/vote");
            get.addHeader("Host", "nctrain.streamsoft.cn");
            /*get.addHeader("Connection", "keep-alive");
            get.addHeader("Content-Length", "76");*/
//            get.addHeader("Accept", "application/json, text/javascript, */*; q=0.01");
            /*get.addHeader("Origin", "https://nctrain.streamsoft.cn");*/
            get.addHeader("authorization", "zjVebMa3676uV7g0CTbJcwdFcD)EmX2shAK9n9G8e67yB2L5JVLSa3LyNCF2Jir3)ex51eLUMV3gckV0sQDHMgdPx8hlbaVBnFESMoaNKaqCyYpJo9jkbB)Qt2DsqXmijR5buLoYXvGtIAys4Vosk(3RyakpUszogcL5U5CrdXg!3!d23dc6db90986f16");
            get.addHeader("Referer", "https://nctrain.streamsoft.cn/");
            get.addHeader("User-Agent",
                    "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0");
            get.setHeader("Content-Type", "application/json;charset=UTF-8");
            String js = "{\"activityId\":\"5cb830f324540c17fc04f577\",\"ids\":[\"5cb978c11fbf653dcce5b0a2\"]}";
            try {
                StringEntity se = new StringEntity(js);
                se.setContentType(CONTENT_TYPE_TEXT_JSON);
                get.setEntity(se);
                response = client.execute(get);
                entity = response.getEntity();
                byte[] bytes = EntityUtils.toByteArray(entity);
                // 对响应内容编码格式进行转化，统一成utf-8格式
                String temp = new String(bytes, "gbk");
                byte[] contentData = temp.getBytes("utf-8");
                System.out.println(new String(contentData));
                System.out.println("-----------------------------------");
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
