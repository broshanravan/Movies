package dl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import bl.Movie;
import bl.Rating;
import bl.UItem;
import bl.User;
import bl.Enums.MovieType;

public class CSVWriter {
	
	RowTxtReader rowTxtReader = new RowTxtReader();
	
	public void createUserCSV(String filePath,String uDataFilePath, String outPutfilenamePath){		
		 List<User> userList= rowTxtReader.readUsersFile(filePath, uDataFilePath);
		 File file = new File(outPutfilenamePath);  
	      
		 BufferedWriter writer=null;
		 FileWriter fw = null;	
		 try {
			 if ( !file.exists() )				
					file.createNewFile();

		     fw = new FileWriter(file);
		    
		     writer = new BufferedWriter( fw );
		
		    writer.append("userId");
			writer.append(',');
			writer.append("TwitterId"); 
			writer.append(',');
			writer.append("Age"); 
			writer.append(',');
			writer.append("Gender"); 
			writer.append(',');
			writer.append("Occopation"); 
			writer.append(',');
			writer.append("ZipCode"); 
			writer.append('\n');
			for(User user: userList){				
				writer.append(String.valueOf(user.getUserId()));
				writer.append(',');
				writer.append(String.valueOf(user.getTwiterId()));
				writer.append(',');
				writer.append(String.valueOf(user.getAge()));
				writer.append(',');
				writer.append(user.getGender());
				writer.append(',');
				writer.append(user.getOccupation().toString());
				writer.append(',');
				writer.append(user.getZipCode());
				writer.append('\n');
			}
			writer.flush();
	        
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				writer.close();
		        fw.close();;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void createMovieCSV(String filePath, String outPutfilenamePath){
		List<Movie> movieList= rowTxtReader.readMoviesFile(filePath);
		 File file = new File(outPutfilenamePath);  
	      
		 BufferedWriter writer=null;
		 FileWriter fw = null;	
		 try {
			 if ( !file.exists() )				
					file.createNewFile();

		     fw = new FileWriter(file);
		    
		     writer = new BufferedWriter( fw );
		
		    writer.append("Movie Id");
			writer.append(',');
			writer.append("MovieTitle"); 
			writer.append(',');
			writer.append("Release Year"); 
			writer.append(',');
			writer.append("Movie Types"); 
			writer.append('\n');
			for(Movie movie: movieList){
				writer.append(String.valueOf(movie.getMovieId()));
				writer.append(',');
				writer.append(movie.getMovieTitle());
				writer.append(',');
				writer.append(movie.getReleaseYear());
				writer.append(',');
				
				String movieTypeStr="";
				List<MovieType> typeList=movie.getMovieTypeList();
				int i=0;
				for(MovieType movieType:typeList){
					String enumVal=movieType.toString();
					
					if(i>0){
						enumVal="-"+enumVal;
					}
					movieTypeStr+=enumVal;
					
					i++;
				}
				
				writer.append(movieTypeStr);
				writer.append('\n');
			}
			writer.flush();
	        
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				writer.close();
		        fw.close();;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void createUItemCSV(String filePath, String outPutfilenamePath){
		List<UItem> uItemList= rowTxtReader.readItemsFile(filePath);
		 File file = new File(outPutfilenamePath);  
		 DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
		 BufferedWriter writer=null;
		 FileWriter fw = null;	
		 try {
			 if ( !file.exists() )				
					file.createNewFile();

		     fw = new FileWriter(file);
		    
		    writer = new BufferedWriter(fw);
		    writer.append("Movie Id");
			writer.append(',');
			writer.append("MovieTitle"); 
			writer.append(',');
			writer.append("Release Date"); 
			writer.append(',');
			writer.append("Video Release Date"); 
			writer.append(',');
			writer.append("URL");
			writer.append(',');
			writer.append("Movie Type");
			writer.append('\n');
			for(UItem uItem: uItemList){
				writer.append(String.valueOf(uItem.getUItemId()));
				writer.append(',');
				String movieTitle=uItem.getMovieTitle();
				movieTitle=	movieTitle.replaceAll(",", "");		
				writer.append(movieTitle);
				writer.append(',');
				writer.append(df.format(uItem.getReleaseDate()));
				writer.append(',');
				writer.append(uItem.getIMDbURL());
				writer.append(',');				
				String movieTypeStr="";
				List<MovieType> typeList=uItem.getMovieTypeList();
				int i=0;
				for(MovieType movieType:typeList){
					String enumVal=movieType.toString();
					
					if(i>0){
						enumVal="-"+enumVal;
					}
					movieTypeStr+=enumVal;
					
					i++;
				}
				
				writer.append(movieTypeStr);
				writer.append('\n');
			}
			writer.flush();
	        
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				writer.close();
		        fw.close();;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void createRatingCSV(String filePath, String outPutfilenamePath){
		List<Rating> ratingList= rowTxtReader.readRatingsFile(filePath);
		 File file = new File(outPutfilenamePath);  
	      
		 BufferedWriter writer=null;
		 FileWriter fw = null;	
		 try {
			 if ( !file.exists() )				
					file.createNewFile();

		     fw = new FileWriter(file);
		    
		     writer = new BufferedWriter( fw );
		
		    writer.append("userId");
			writer.append(',');
			writer.append("Movie Id"); 
			writer.append(',');
			writer.append("Rating"); 
			writer.append(',');
			writer.append("Rating Timestamp");  
			writer.append('\n');
			for(Rating rating: ratingList){				
				writer.append(String.valueOf(rating.getUserId()));
				writer.append(',');
				writer.append(String.valueOf(rating.getMovieId()));
				writer.append(',');
				writer.append(String.valueOf(rating.getRating()));
				writer.append(',');
				writer.append(String.valueOf(rating.getTimeStamp()));
				writer.append('\n');
			}
			writer.flush();
	        
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				writer.close();
		        fw.close();;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

