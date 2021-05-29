package dlg.menue;

import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.Optional;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.event.EventHandler;

public class Hauptmenue extends Application{
	
    private Stage mainStage;
    private static HauptmenueService awkService; //agiert wie kundenmanger / kreditverwaltermanager aus oop2
    
    
    
	public static final String MAIN_SCREEN = "main";
	public static final String MAIN_SCREEN_FXML = "dlg/menue/Hauptmenue.fxml";
	
	public static final String PATIENTENERSTELLEN_SCREEN = "PatientenErstellenScreen";
	public static final String PATIENTENERSTELLEN_SCREEN_FXML = "dlg/patientenverwaltung/PatientenErstellen.fxml";
	

	public static final String VAKZINEERSTELLEN_SCREEN = "VakzineErstellenScreen";
	public static final String VAKZINEERSTELLEN_SCREEN_FXML = "dlg/vakzineverwaltung/VakzineLieferungErfassen.fxml";

	public static final String TERMINERSTELLEN_SCREEN = "TerminErstellenScreen";
	public static final String TERMINERSTELLEN_SCREEN_FXML = "dlg/terminverwaltung/TerminAnlegen.fxml";
	
	public static final String IMPFUNGEINTRAGEN_SCREEN = "ImpfungEintragenScreen";
	public static final String IMPFUNGEINTRAGEN_SCREEN_FXML = "dlg/terminverwaltung/ImpfungEintragen.fxml";
	
	
	
	
	@SuppressWarnings("static-access")
	@Override
	public void start(Stage primaryStage) throws Exception {

		this.mainStage = primaryStage;
		

		ScreensController mainContainer = new ScreensController();
		
		mainContainer.setAwkService(this.awkService);
		mainContainer.loadScreen(Hauptmenue.MAIN_SCREEN, Hauptmenue.MAIN_SCREEN_FXML);
		mainContainer.loadScreen(Hauptmenue.PATIENTENERSTELLEN_SCREEN, Hauptmenue.PATIENTENERSTELLEN_SCREEN_FXML);
		mainContainer.loadScreen(Hauptmenue.VAKZINEERSTELLEN_SCREEN, Hauptmenue.VAKZINEERSTELLEN_SCREEN_FXML);
		mainContainer.loadScreen(Hauptmenue.TERMINERSTELLEN_SCREEN, Hauptmenue.TERMINERSTELLEN_SCREEN_FXML);
		mainContainer.loadScreen(IMPFUNGEINTRAGEN_SCREEN, IMPFUNGEINTRAGEN_SCREEN_FXML);
		
		mainContainer.setScreen(Hauptmenue.MAIN_SCREEN);
		Group root = new Group();
		root.getChildren().addAll(mainContainer);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setOnCloseRequest(confirmCloseEventHandler);
		primaryStage.show();
		
		


	}
	private EventHandler<WindowEvent> confirmCloseEventHandler = event -> {
		// Quelle:
		// http://stackoverflow.com/questions/29710492/javafx-internal-close-request
		Alert closeConfirmation = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to exit?");
		Button exitButton = (Button) closeConfirmation.getDialogPane().lookupButton(ButtonType.OK);
		exitButton.setText("Exit");
		closeConfirmation.setHeaderText("Confirm Exit");
		closeConfirmation.initModality(Modality.APPLICATION_MODAL);
		closeConfirmation.initOwner(mainStage);

		// normally, you would just use the default alert positioning,
		// but for this simple sample the main stage is small,
		// so explicitly position the alert so that the main window can still be seen.
		closeConfirmation.setX(mainStage.getX() + 150);
		closeConfirmation.setY(mainStage.getY() - 300 + mainStage.getHeight());

		Optional<ButtonType> closeResponse = closeConfirmation.showAndWait();
		if (!ButtonType.OK.equals(closeResponse.get())) {
			event.consume();
		}
	};
	

	public static void main(String[] args,HauptmenueService aService) {
		awkService = aService;
		launch(args);
	}

}
