package tw.ibm.gbs.poc.springcloud.votebackend.model;

public class Link {
	
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
	
}
