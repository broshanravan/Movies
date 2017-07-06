package dl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import bl.Movie;
import bl.Rating;
import bl.UItem;
import bl.User;
import bl.Enums.MovieType;
import bl.Enums.Occupation;

public class RowTxtReader {
	
	BufferedReader bufferedReader=null;
	BufferedReader bufferedReader1=null;
	
	public List<Movie> readMoviesFile(String filePath){
		List<Movie> movieList = new LinkedList<Movie>();
		try{
			FileReader fileReader = new FileReader(filePath);
			bufferedReader = new BufferedReader(fileReader);
			
				
			for(String line; (line = bufferedReader.readLine()) != null; ){
				String movieTxt=line.substring(3);
				
				Movie movie= this.packageMovieTxt(movieTxt);
				movieList.add(movie);	
			}
			
		} catch (FileNotFoundException e){
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}		 
		
		
		
		
		return movieList;
		
		
	}		
	
	public List<User> readUsersFile(String filePath,String uDataFilePath){
		List<User> userList = new LinkedList<User>();
		try{
			FileReader fileReader = new FileReader(filePath);
			bufferedReader = new BufferedReader(fileReader);
						
			for(String line; (line = bufferedReader.readLine()) != null; ){
				String userTxt=line;
				
				User user=packageUserTxt(userTxt, uDataFilePath);
				userList.add(user);	
			}
			
		} catch (FileNotFoundException e){
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}		 
		
		
		
		return userList;		
		
	}
		
	public List<UItem> readItemsFile(String filePath){
		List<UItem> uItemList = new LinkedList<UItem>();
		try{
			FileReader fileReader = new FileReader(filePath);
			bufferedReader = new BufferedReader(fileReader);			
			int i=0;	
			for(String line; (line = bufferedReader.readLine()) != null; ){
				String uItemTxt=line;				
				UItem uItem= packageUItemTxt(uItemTxt); 
				uItemList.add(uItem);				
				i++;
			}
			
		} catch (FileNotFoundException e){
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}			
		
		return uItemList;		
		
	}
	
	
	public List<Rating> readRatingsFile(String filePath){
		List<Rating> ratingList= new LinkedList<Rating>();		
		
		try{
			FileReader fileReader = new FileReader(filePath);
			bufferedReader = new BufferedReader(fileReader);
						
			for(String line; (line = bufferedReader.readLine()) != null; ){
				String ratingTxt=line;
				
				Rating rating =packageRating(ratingTxt);
				ratingList.add(rating);	
			}
			
		} catch (FileNotFoundException e){
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}	
		
		
		
		
		
		return ratingList;
	}
	
	private User packageUserTxt(String userTxt,String uDataFilename){
		
		User user = new User();
		StringTokenizer st = new StringTokenizer(userTxt,"|");
		 int i=0;
		 while (st.hasMoreTokens()) {
			 
			 if(i==0){
				 String userId=st.nextToken();
				 user.setUserId(Integer.parseInt(userId));
				 String twitterId=getUserTWitterId(Long.parseLong(userId), uDataFilename);
				 user.setTwiterId(Long.parseLong(twitterId));
				 
			 }else if(i==1){
				 user.setAge(Integer.parseInt(st.nextToken()));
			 }else if(i==2){
				 user.setGender(st.nextToken());
			 }else if(i==3){
				 user.setOccupation(Occupation.valueOf(st.nextToken()));
			 }else if(i==4){
				 user.setZipCode(st.nextToken());
			 }
			 i++;
		 }
		
		return user;
	}
	
	private String getUserTWitterId(long userIdIn, String uDataFilename){
		String twitterId="";
		try{
			FileReader fileReader = new FileReader(uDataFilename);
			bufferedReader1 = new BufferedReader(fileReader);
			
			for(String line; (line = bufferedReader1.readLine()) != null; ){
				String userTxt=line;
				StringTokenizer st = new StringTokenizer(userTxt,"::");				
				long uDataUserId=0;				
				int i=0;				 
				while (st.hasMoreTokens()) {	
					 if(i==0){						 
						 uDataUserId=Long.parseLong(st.nextToken());
					 }else if(i==1){
						 twitterId=st.nextToken();
					 }
					 i++;					 
				}
				
				if(uDataUserId==userIdIn){
					 break;
				}
				
			}
			
			
			
		} catch (FileNotFoundException e){
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				bufferedReader1.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}		 
		
		return twitterId;
		
	}
	
	private Movie packageMovieTxt(String movieTxt){
		
		Movie movie = new Movie();
		StringTokenizer st = new StringTokenizer(movieTxt,"::");
		List<MovieType> movieTypeList= new LinkedList<MovieType>(); 
		int i=0;
		 while (st.hasMoreTokens()) {			 
			 if(i==0){
				 String idStr=st.nextToken();
				 movie.setMovieId(Integer.parseInt(idStr));
			 }else if(i==1){
				 
				 String movieTitleYear=st.nextToken();
				 
				 StringTokenizer st1 = new StringTokenizer(movieTitleYear,"(");
				 int j=0;
				 while (st1.hasMoreTokens()) {
					 if(j==0){
						 String movieTitle=st1.nextToken();
						 movie.setMovieTitle(movieTitle.trim());
					 }else if (j==1){
						 String releaseYear=st1.nextToken();
						 releaseYear=releaseYear.substring(0,releaseYear.length()-1);
						 movie.setReleaseYear(releaseYear);
					 }
					 j++;
				 }
			 }else if(i==2){
				 String types=st.nextToken();
				 if(types.contains("|")){
					 StringTokenizer st2 = new StringTokenizer(types,"|");
					 while (st2.hasMoreTokens()) {	
						 MovieType movieType=MovieType.valueOf(st2.nextToken());
						 movieTypeList.add(movieType);
					 }
				 }else{
					 MovieType movieType=MovieType.valueOf(types);
					 movieTypeList.add(movieType);
				 }
			 }
			 
			 i++;
			 
		 }
		 movie.setMovieTypeList(movieTypeList);
		return movie;
	}
	
	private UItem packageUItemTxt(String uItemTxt){
		
		UItem uItem = new UItem();
		List<MovieType> movieTypeList= new LinkedList<MovieType>();
		StringTokenizer st = new StringTokenizer(uItemTxt,"|");
		 int i=0;
		 while (st.hasMoreTokens()) {
			
			 if(i==0){	 				 
				 uItem.setUItemId(Integer.parseInt(st.nextToken()));
			 }else if(i==1){
				 uItem.setMovieTitle(st.nextToken());
			 }else if(i==2){
				 String dateStr=st.nextToken();
				 SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
				 try {
					Date date =formatter.parse(dateStr);
					uItem.setReleaseDate(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			 }else if(i==3){
				 uItem.setIMDbURL(st.nextToken());
			 }else if(i==4){
				int val= Integer.parseInt(st.nextToken());
				if(val==1){
					movieTypeList.add(MovieType.unknown);
				}
				
			 }else if(i==5){
				int val= Integer.parseInt(st.nextToken());
				if(val==1){
					movieTypeList.add(MovieType.Action);
				}
				 
			 }else if(i==6){
				int val= Integer.parseInt(st.nextToken());
				if(val==1){
					movieTypeList.add(MovieType.Adventure);
				}
				 
			 }else if(i==7){
				 int val= Integer.parseInt(st.nextToken());
					if(val==1){
						movieTypeList.add(MovieType.Animation);
					}				 
			 }else if(i==8){
				 int val= Integer.parseInt(st.nextToken());
					if(val==1){
						movieTypeList.add(MovieType.Children);
					}				 
			 }else if(i==9){
				 int val= Integer.parseInt(st.nextToken());
					if(val==1){
						movieTypeList.add(MovieType.Comedy);
					}				 
			 }else if(i==10){
				 int val= Integer.parseInt(st.nextToken());
					if(val==1){
						movieTypeList.add(MovieType.Crime);
					}
			 }else if(i==11){
				 int val= Integer.parseInt(st.nextToken());
					if(val==1){
						movieTypeList.add(MovieType.Documentary);
					}
			 }else if(i==12){
				 int val= Integer.parseInt(st.nextToken());
					if(val==1){
						movieTypeList.add(MovieType.Drama);
					}
			 }else if(i==13){
				 int val= Integer.parseInt(st.nextToken());
					if(val==1){
						movieTypeList.add(MovieType.Fantasy);
					}
			 }else if(i==14){
				 int val= Integer.parseInt(st.nextToken());
					if(val==1){
						movieTypeList.add(MovieType.FilmNoir);
					}
			 }else if(i==15){
				 int val= Integer.parseInt(st.nextToken());
					if(val==1){
						movieTypeList.add(MovieType.Horror);
					}
			 }else if(i==16){
				 int val= Integer.parseInt(st.nextToken());
					if(val==1){
						movieTypeList.add(MovieType.Musical);
					}
			 }else if(i==17){
				 int val= Integer.parseInt(st.nextToken());
					if(val==1){
						movieTypeList.add(MovieType.Mystery);
					}
			 }else if(i==18){
				 int val= Integer.parseInt(st.nextToken());
					if(val==1){
						movieTypeList.add(MovieType.Romance);
					}
			 }else if(i==19){
				 int val= Integer.parseInt(st.nextToken());
					if(val==1){
						movieTypeList.add(MovieType.SciFi);
					}
			 }else if(i==20){
				 int val= Integer.parseInt(st.nextToken());
					if(val==1){
						movieTypeList.add(MovieType.Thriller);
					}
			 }else if(i==21){
				 int val= Integer.parseInt(st.nextToken());
					if(val==1){
						movieTypeList.add(MovieType.War);
					}
			 }else if(i==22){
				 int val= Integer.parseInt(st.nextToken());
					if(val==1){
						movieTypeList.add(MovieType.Western);
					}
			 }
			 
			 i++;
		 }
		 
		 uItem.setMovieTypeList(movieTypeList);
		
		return uItem;
	}
	
	private Rating packageRating(String retingTxt){
		Rating rating = new Rating();
		StringTokenizer st = new StringTokenizer(retingTxt,"::");		
		int i=0;
		 while (st.hasMoreTokens()) {			 
			 if(i==0){
				 String userIdStr=st.nextToken();
				 rating.setUserId(Integer.parseInt(userIdStr));			 
			 }else if(i==1){
				 String movieId=st.nextToken();	
				 rating.setMovieId(Long.parseLong(movieId));
			 }else if(i==2){
				 String ratingStr=st.nextToken();
				 rating.setRating(Integer.parseInt(ratingStr));
			 }else if(i==3){
				 String timeStampStr=st.nextToken();
				 rating.setTimeStamp(Long.parseLong(timeStampStr));
			 }			 
			 i++;		
		 }
		
		return rating;
		
	}
	
	public static void main(String[] args){
		String userDatPath="C:\\Users\\Behrooz\\movies_project_documentations\\users.dat";
		String userFilePath="C:\\Users\\Behrooz\\movies_project_documentations\\u.user";
		String uItemFilePath="C:\\Users\\Behrooz\\movies_project_documentations\\u-item.txt";
		String movieFilePath="C:\\Users\\Behrooz\\movies_project_documentations\\movies.dat";
		String ratingFilePath="C:\\Users\\Behrooz\\movies_project_documentations\\ratings.dat";
		
		RowTxtReader rowTxtReader = new RowTxtReader();
		
		List<User> userList= rowTxtReader.readUsersFile(userFilePath,userDatPath);
		
		for(User user :userList){
			user.show();
		}
		System.out.println("===================================================================================================");
		List<UItem> userItemList=rowTxtReader.readItemsFile(uItemFilePath);
		
		for(UItem uItem :userItemList){
			uItem.Show();
		}
		
		System.out.println("===================================================================================================");
		
		List<Movie> movieItemList=rowTxtReader.readMoviesFile(movieFilePath);
		for(Movie movie :movieItemList){
			movie.Show();
		}
		
		System.out.println("=====================================RATING==============================================================");
		List<Rating> ratingList=rowTxtReader.readRatingsFile(ratingFilePath);
		
		for(Rating rating: ratingList){
			rating.show();
		}
		
	}
}
