package logic;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		Path fp = Paths.get("C:\\Users\\KYRIAKOS\\Desktop\\internet.txt");
		String parameter = "sentence";

		try
		{
			String content = new String (Files.readAllBytes(fp), Charset.forName("UTF-8"));
			System.out.println(content);
			// count occurrences
			Pattern p = Pattern.compile("(?i)" + parameter); // ?i ignores upper/lower case
			Matcher m = p.matcher(content);
			int counter = 0;
			while (m.find()) counter++;
			System.out.println(counter); 
			
			content = content.replaceAll("(?i)" + Pattern.quote(parameter), parameter.toUpperCase());
			System.out.println(content);
			BufferedWriter bfw = Files.newBufferedWriter(fp, Charset.forName("UTF-8")); // apparently it consumes the file when initialized
			bfw.write(content);
			bfw.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
