package bl;

public class Rating {
	private int userId;
	private long movieId;
	private int rating;
	private long timeStamp;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public long getMovieId() {
		return movieId;
	}
	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
	public void show(){
		 System.out.println("userId is: "+userId);
		 System.out.println("movieId is: "+movieId);
		 System.out.println("rating is: "+rating);
		 System.out.println("timeStamp is: "+timeStamp);
		
	}
	
}
