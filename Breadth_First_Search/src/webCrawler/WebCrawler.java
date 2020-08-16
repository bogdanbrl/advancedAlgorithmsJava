package webCrawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {
	
	private Queue<String> queue;
	private List<String> discoverWebsitesList;
	
	public WebCrawler() {
		this.queue=new LinkedList<String>();
		this.discoverWebsitesList=new ArrayList<String>();
	}
	
	public void discoverWeb(String root) {
		this.queue.add(root);
		this.discoverWebsitesList.add(root);
		
		while(!queue.isEmpty()) {
			String v = this.queue.remove();
			String rawHtml = readURL(v);
			
			String regex = "https://(\\w+\\.)*(\\w+)";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(rawHtml);
			
			while(matcher.find()) {
				String actualUrl = matcher.group();
				if(!discoverWebsitesList.contains(actualUrl)) {
					discoverWebsitesList.add(actualUrl);
					System.out.println("Website was found with url: "+actualUrl);
					queue.add(actualUrl);
				}
			}
		}
	}

	private String readURL(String v) {
		// TODO Auto-generated method stub
		String rawHtml ="";
		
		try {
			URL url = new URL(v);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			
			String inputLine = "";
			
			while((inputLine = in.readLine()) != null) {
				rawHtml += inputLine;
			}
			in.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rawHtml;
	}
	
}















