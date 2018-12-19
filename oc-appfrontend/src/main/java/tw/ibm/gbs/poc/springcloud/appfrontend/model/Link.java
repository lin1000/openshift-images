package tw.ibm.gbs.poc.springcloud.appfrontend.model;

import org.springframework.data.annotation.Id;

public class Link {
	
    @Id
    public String id;
	private String url;
	private int score;
	
	public Link(String url, int score) {
		this.url = url;
		this.score = score;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
    @Override
    public String toString() {
        return String.format(
                "Link[id=%s, url='%s', score='%d']",
                id, url, score);
    }	
	
}
