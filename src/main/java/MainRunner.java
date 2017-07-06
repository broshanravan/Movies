import dl.CSVWriter;


public class MainRunner {
	public static void main(String[] args){
		String userDatPath="C:\\Users\\Behrooz\\movies_project_documentations\\users.dat";
		String userFilePath="C:\\Users\\Behrooz\\movies_project_documentations\\u.user";
		String uItemFilePath="C:\\Users\\Behrooz\\movies_project_documentations\\u-item.txt";
		String movieFilePath="C:\\Users\\Behrooz\\movies_project_documentations\\movies.dat";
		String ratingFilePath="C:\\Users\\Behrooz\\movies_project_documentations\\ratings.dat";
		
		String outPutPath="C:\\Users\\Behrooz\\movies_project_documentations\\CSV\\";
				
		CSVWriter cSVWriter = new CSVWriter();
		
		String userCSVFileName=outPutPath +"user.csv";		
		cSVWriter.createUserCSV(userFilePath,userDatPath, userCSVFileName);
		
		
		String  movieCSVFileName=outPutPath +"movie.csv";
		
		cSVWriter.createMovieCSV(movieFilePath, movieCSVFileName);
		
		String  uItemCSVFileName=outPutPath +"uItem.csv";
		
		cSVWriter.createUItemCSV(uItemFilePath, uItemCSVFileName);
		
		String ratingCSVFileName=outPutPath +"rating.csv";
		
		cSVWriter.createRatingCSV(ratingFilePath,ratingCSVFileName);
		
	}

}
