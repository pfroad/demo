package sample.web.ui;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class AppTest {
	@Test
	public void testAddUser() {
		String url = "http://localhost:8443/user/add";
		CloseableHttpClient httpclient = null;
		CloseableHttpResponse response = null;
		
		
		try {
			httpclient = HttpClients.createDefault();
			
			HttpPost post = new HttpPost(url);
			StringEntity entity = new StringEntity("{\"username\": \"2nd user\", \"password\": \"testpw\"}", "UTF-8");
			entity.setContentEncoding("UTF-8");    
            entity.setContentType("application/json");    
			post.setEntity(entity);
			response = httpclient.execute(post);
			
			StatusLine status = response.getStatusLine();
			HttpEntity res = response.getEntity();
			if (status.getStatusCode() == 200) {
				System.out.println(EntityUtils.toString(res));
				EntityUtils.consume(entity);
			} else {
				System.out.println("Failed!");
			}
		} catch (ClientProtocolException | UnsupportedEncodingException e) {
		} catch (IOException e) {
		} finally {
			if (httpclient != null) {
				try {
					httpclient.close();
				} catch (IOException e) {
				}
			}
			
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
				}
			}
		}
	}
}
