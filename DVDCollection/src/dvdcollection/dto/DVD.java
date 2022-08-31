package dvdcollection.dto;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(directorName, mpaa, releaseDate, studio, title, userReview);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DVD other = (DVD) obj;
		return Objects.equals(directorName, other.directorName) && Objects.equals(mpaa, other.mpaa)
				&& Objects.equals(releaseDate, other.releaseDate) && Objects.equals(studio, other.studio)
				&& Objects.equals(title, other.title) && Objects.equals(userReview, other.userReview);
	}

	@Override
	public String toString() {
		return "DVD [title=" + title + ", releaseDate=" + releaseDate + ", mpaa=" + mpaa + ", directorName="
				+ directorName + ", studio=" + studio + ", userReview=" + userReview + "]";
	}
}
