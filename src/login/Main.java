package login;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Grit Academy Login");
			primaryStage.setResizable(false);
			
			// Layout for scene 1
			GridPane layout1 = new GridPane();
			layout1.setPadding(new Insets(20));
			layout1.setVgap(10);
			layout1.setHgap(10);
			layout1.setAlignment(Pos.CENTER);
			
			Scene scene1 = new Scene(layout1, 450, 500);
			
			// Welcome text
			Text welcomeText = new Text("Welcome on login page for Grit Academy");
			welcomeText.setFont(Font.font("Tahoma", FontWeight.LIGHT, 18));
			welcomeText.setFill(Color.DARKGOLDENROD);
			GridPane.setConstraints(welcomeText, 1, 0);
			
			// Name label
			Label nameLabel = new Label("Username: ");
			GridPane.setConstraints(nameLabel, 0, 1);
			
			// Name field input
			TextField username = new TextField();
			username.setPromptText("email");
			GridPane.setConstraints(username, 1, 1);
			
			// Password label
			Label passLabel = new Label("Password: ");
			GridPane.setConstraints(passLabel, 0, 2);
						
			// Password field input
			PasswordField password = new PasswordField();
			password.setPromptText("password");
			GridPane.setConstraints(password, 1, 2);
			
			// Login button
			Button loginButton = new Button("Login");						
			GridPane.setConstraints(loginButton, 1, 3);
			
			// Image with Grit Academy logo
			Image image = new Image("file:gritLogo.jpg");
	        ImageView imageView = new ImageView();
	        GridPane.setConstraints(imageView, 1, 5);
	        imageView.setImage(image);
	        imageView.setFitWidth(250);
	        imageView.setPreserveRatio(true);
	        imageView.setSmooth(true);
	        imageView.setCache(true);

	        // Message label
	     	Label messageLabel = new Label("Write email and password to login");
	     	GridPane.setConstraints(messageLabel, 1, 6);
			
			layout1.getChildren().addAll(welcomeText, nameLabel, username, passLabel, password, loginButton, imageView, messageLabel);
						
			scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());		
			
			// Layout for scene 2
			VBox layout2 = new VBox(20);
			layout2.setPadding(new Insets(10, 10, 10, 10));
			Scene scene2 = new Scene(layout2, 450, 500);
			Label userInfo = new Label("");
			Label labelInfo = new Label("You are successfully logged in!");
			Button logoutButton = new Button("Logout");
			layout2.getChildren().addAll(userInfo, labelInfo, logoutButton);
			
			// Login button action event with lambda
			loginButton.setOnAction((event) -> {
				//check if email address and password are valid ones
				if (username.getText().equals("") || password.getText().equals("")) messageLabel.setText("Username and password can't be empty");
				else if (!Validate.validateEmail(username.getText()) && !Validate.validatePassword(password.getText())) messageLabel.setText("Please enter a valid email adress and password");
				else if(!Validate.validateEmail(username.getText())) messageLabel.setText("Please enter a valid email adress");
				else if (!Validate.validatePassword(password.getText())) messageLabel.setText("Please enter a valid password: \nUse at least 2 digits, 2 lower case letters, \n2 upper case letters and 1 special character");
				else primaryStage.setScene(scene2); String name = username.getText(); userInfo.setText("Welcome " + name);
			});	
			
			// Logout button action event with lambda
			logoutButton.setOnAction((event) -> {
				messageLabel.setText("Write email and password to login");
				primaryStage.setScene(scene1);
			});
			
			primaryStage.setScene(scene1);
			primaryStage.show();
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}