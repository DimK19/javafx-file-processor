package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.FileProcessor;


public class Main extends Application
{
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		FileProcessor fp = new FileProcessor();
		
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 400, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		HBox fileRow = new HBox(5);
		// equivalent to new HBox(); setSpacing(5), where spacing is the distance between objects within the box
		TextField fileTextField = new TextField();
		Label fileLabel = new Label("File path:");
		fileRow.getChildren().add(fileLabel);
        fileRow.getChildren().add(fileTextField);
		
		HBox wordRow = new HBox(5);
		TextField wordTextField = new TextField();
		Label wordLabel = new Label("Word to search:");
		wordRow.getChildren().add(wordLabel);
        wordRow.getChildren().add(wordTextField);
		
        Button btn = new Button("Button");
        
        Label message = new Label("");
        //StringProperty sp = new SimpleStringProperty(fp.getState());
        //sp.bind(fp.stateProperty());
        message.textProperty().bind(fp.stateProperty());
        
        VBox content = new VBox(5);
        
        content.getChildren().add(fileRow);
        content.getChildren().add(wordRow);
        content.getChildren().add(btn);
        content.getChildren().add(message);
        
        //root.getChildren().add(row); // does not display components properly, but rather squeezed
        root.setCenter(content);
		
        btn.setOnAction(lambda -> {
        	fp.editFile(fileTextField.getText(), wordTextField.getText());
        	fileTextField.clear();
        	wordTextField.clear();
        });
        
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
