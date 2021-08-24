package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import logic.FileProcessor;

public class Controller
{
	@FXML
	private Button replaceButton;
	@FXML
	private TextField fileTextField;
	@FXML
	private TextField wordTextField;
	@FXML
	private Label message;
	
	public void buttonClicked(ActionEvent e) throws IOException
	{
		FileProcessor fp = new FileProcessor();
		fp.editFile(fileTextField.getText(), wordTextField.getText());
    	fileTextField.clear();
    	wordTextField.clear();
    	message.textProperty().bind(fp.stateProperty());
	}
}
