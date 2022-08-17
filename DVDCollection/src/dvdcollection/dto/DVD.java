package dvdcollection.dto;

public class DVD {
	//fields
	final String title;
	private String releaseDate;
	private String mpaa;
	private String directorName;
	private String studio;
	private String userReview;
	
	
	//constructor with title
	public DVD(String title) {
		this.title = title;
		
	}
	
	/* TODO:
	 * set getter/setter for each field
	 */
	public String getTitle() {
		return title;
	}
	
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	
	public void setMpaa(String mpaa) {
		this.mpaa = mpaa;
	}
	public String getMpaa() {
		return mpaa;
	}
	
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	public String getDirectorName() {
		return directorName;
	}
	
	public void setStudio(String studio) {
		this.studio = studio;
	}
	public String getStudio() {
		return studio;
	}
	
	public void setUserReview(String userReview) {
		this.userReview = userReview;
	}
	public String getUserReview() {
		return userReview;
	}
}
