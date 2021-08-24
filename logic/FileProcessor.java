package logic;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FileProcessor
{
	StringProperty state;
	
	public FileProcessor()
	{
		this.state = new SimpleStringProperty();
	}

	public void editFile(String path, String parameter)
	{
		Path fp;
		
		try
		{
			fp = Paths.get(path);
		}
		catch(InvalidPathException e)
		{
			this.setState("Invalid path");
			return;
		}
		
		try
		{
			String content = new String (Files.readAllBytes(fp), Charset.forName("UTF-8"));
			// System.out.println(content);
			// count occurrences
			Pattern p = Pattern.compile("(?i)" + parameter); // ?i ignores upper/lower case
			Matcher m = p.matcher(content);
			int counter = 0;
			while (m.find()) counter++;
			
			content = content.replaceAll("(?i)" + Pattern.quote(parameter), parameter.toUpperCase());
			System.out.println(content);
			BufferedWriter bfw = Files.newBufferedWriter(fp, Charset.forName("UTF-8")); // apparently it consumes the file when initialized
			bfw.write(content);
			bfw.close();
			this.setState(Integer.toString(counter) + " occurences found and replaced");
		}
		catch(NoSuchFileException e)
		{
			e.printStackTrace();
			this.setState("File does not exist");
		}
		catch(IOException e)
		{
			e.printStackTrace();
			this.setState("IO Exception");
		}
	}
	
	public StringProperty stateProperty()
	{
		return this.state;
	}
	
	public String getState()
	{
		return this.state.get();
	}

	public void setState(String state)
	{
		this.state.set(state);
	}

}
