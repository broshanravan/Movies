package bl;

import java.util.Date;
import java.util.List;

import bl.Enums.MovieType;

public class UItem {
	private int UItemId; 
	private String movieTitle;
	 
	private Date releaseDate;
	private Date videoReleaseDate;
    private String IMDbURL;
    private List<MovieType> movieTypeList;
    
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Date getVideoReleaseDate() {
		return videoReleaseDate;
	}
	public void setVideoReleaseDate(Date videoReleaseDate) {
		this.videoReleaseDate = videoReleaseDate;
	}
	public String getIMDbURL() {
		return IMDbURL;
	}
	public void setIMDbURL(String iMDbURL) {
		IMDbURL = iMDbURL;
	}
	public int getUItemId() {
		return UItemId;
	}
	public void setUItemId(int uItemId) {
		UItemId = uItemId;
	}
	public List<MovieType> getMovieTypeList() {
		return movieTypeList;
	}
	public void setMovieTypeList(List<MovieType> movieTypeList) {
		this.movieTypeList = movieTypeList;
	}
	
	public void Show(){		
		
		 System.out.println("releaseDate is: "+releaseDate);
		 System.out.println("IMDbURL is: "+IMDbURL);
		 System.out.println("movieTitle is: "+movieTitle);
		 System.out.println("UItemId is: "+UItemId);
	     
		 System.out.println("MovieTypes are: ");
	     for( MovieType movieType :movieTypeList){
	    	 System.out.print(movieType.name() +" , ");
	     }
	     System.out.println("");
	}
	
    
    
}
