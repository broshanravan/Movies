package bl;

import java.util.List;

import bl.Enums.MovieType;

public class Movie {
	
	private int movieId ;	
	private String movieTitle; 
	String releaseYear;
    private List<MovieType> movieTypeList;
    
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public List<MovieType> getMovieTypeList() {
		return movieTypeList;
	}
	public void setMovieTypeList(List<MovieType> movieTypeList) {
		this.movieTypeList = movieTypeList;
	}
	

	public String getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}
	public void Show(){		
		
		 System.out.println("movieId is: "+movieId);
		 System.out.println("movieTitle is: "+movieTitle);
		 System.out.println("releaseYear is: "+releaseYear);	     
		 System.out.println("MovieTypes are: ");
	     for( MovieType movieType :movieTypeList){
	    	 System.out.print(movieType.name() +" , ");
	     }
	     System.out.println("");
	}
	

}
