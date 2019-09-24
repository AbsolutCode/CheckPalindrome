package dad.javafx.CheckPalindrome;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckPalindrome extends Application {
	
	private Label solucionLabel;
	private Button comprobarButton;
	private TextField palabraText;
	boolean palindrome(String str){
		int largo=str.length();
		for(int i=0;i<=largo/2;i++) {
			if(str.charAt(i) != str.charAt(largo-1-i)) {
				return false;
			}
		}
		return true;
	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		palabraText = new TextField();
		palabraText.setPrefColumnCount(5);
		palabraText.setPromptText("Introduce una sentencia");
		palabraText.setMaxWidth(150);
		
		solucionLabel = new Label();
		solucionLabel.setText("Aquí saldrá la solución");
		
		comprobarButton = new Button();
		comprobarButton.setText("Comprobar");
		comprobarButton.setOnAction(e -> onComprobarButtonAction(e));
		comprobarButton.setDefaultButton(true);
		
		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(palabraText, comprobarButton, solucionLabel);

		Scene escena = new Scene(root, 320, 200);
		
		primaryStage.setScene(escena);
		primaryStage.setTitle("CheckPalindrome");
		primaryStage.show();
		
	}
	
	private void onComprobarButtonAction(ActionEvent e) {
		String palabra = palabraText.getText();
		if(palindrome(palabra)) {
			solucionLabel.setText("Es palíndrome.");
			solucionLabel.setStyle("-fx-text-fill: green; -fx-font: italic bold 30 sans-serif;");
		}
		else {
			solucionLabel.setText("No es palíndrome.");
			solucionLabel.setStyle("-fx-text-fill: red; -fx-font: italic bold 30 sans-serif;");
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
