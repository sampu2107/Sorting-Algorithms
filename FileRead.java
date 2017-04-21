import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class FileRead {

	String fileName;
	public String[] OpenRandomFile() throws IOException{
		fileName = "C:/random_list.txt";
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		int numberOfLines = readLines();
		String[] textData = new String[numberOfLines];
		String line;
		for(int i=0;i<numberOfLines;i++){
			line = br.readLine();
			textData[i] = line.trim();
		}
		br.close();
		return textData;
	}

	public String[] OpenReverseFile() throws IOException{
		fileName = "C:/reverse_list.txt";
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		int numberOfLines = readLines();
		String[] textData = new String[numberOfLines];
		String line;
		for(int i=0;i<numberOfLines;i++){
			line = br.readLine();
			textData[i] = line.trim();
		}
		br.close();
		return textData;
	}
	
	public String[] OpenSortedFile() throws IOException{
		fileName = "C:/sorted_list.txt";
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		int numberOfLines = readLines();
		String[] textData = new String[numberOfLines];
		String line;
		for(int i=0;i<numberOfLines;i++){
			line = br.readLine();
			textData[i] = line.trim();
		}
		br.close();
		return textData;
	}
	
	public int readLines() throws IOException{
		int numberOfLines = 0;
		FileReader f = new FileReader(fileName);
		BufferedReader b = new BufferedReader(f);
		while((b.readLine() != null)){
			numberOfLines++;
		}
		b.close();
		return numberOfLines;
	}
}