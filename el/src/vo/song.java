package vo;

public class song {
	
	private String title;
	private Artist artist;
	private int runningTime;
	private String company;
	
	public song() {}

	public song(String title, Artist artist, int runningTime, String company) {
		super();
		this.title = title;
		this.artist = artist;
		this.runningTime = runningTime;
		this.company = company;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public int getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}
	
	public String getRunningTime2() {
		int minute = runningTime/60;
		int second = runningTime%60;
		return minute + ":" + second;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
}
