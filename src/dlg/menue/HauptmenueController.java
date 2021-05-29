package dlg.menue;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HauptmenueController implements Initializable, dlg.menue.ControlledScreen{


	@FXML
	Button bt_patientenErstellen;
	
	@FXML
	Button bt_beenden;
	
	@FXML
	Button bt_vakzineErstellen; 
	
	@FXML 
	Button bt_terminAnlegen;
	
	@FXML
	Button bt_impfungEintragen;
	
	private ScreensController myController;
	
	
	@Override
	public void setScreenParent(ScreensController screenPage) {
		this.myController = screenPage;
		
	}
	
	@FXML
	public void bt_patientenErstellenClicked() {
		System.out.println("Erstelle Patienten...");
		bt_patientenErstellen.getScene().getWindow().setHeight(600);

		this.myController.setScreen(Hauptmenue.PATIENTENERSTELLEN_SCREEN);
	}
	
	@FXML
	public void bt_vakzineErstellenClicked() {

		System.out.println("Erfasse Vakzineanlieferung...");
		bt_vakzineErstellen.getScene().getWindow().setHeight(500);
		bt_vakzineErstellen.getScene().getWindow().setWidth(850);
		this.myController.setScreen(Hauptmenue.VAKZINEERSTELLEN_SCREEN);

	}
	
	@FXML 
	public void bt_terminAnlegenClicked() {
		System.out.println("Erfasse Termin...");
		


		this.myController.setScreen(Hauptmenue.TERMINERSTELLEN_SCREEN);
		
	}
	
	@FXML 
	public void bt_impfungEintrageClicked() {
		System.out.println("Trage Impfung ein...");
		bt_impfungEintragen.getScene().getWindow().setHeight(500);
		bt_impfungEintragen.getScene().getWindow().setWidth(850);
		this.myController.setScreen(Hauptmenue.IMPFUNGEINTRAGEN_SCREEN);

		
	}
	
	@FXML
	public void bt_beendenClicked() {
	
		Stage mainStage = (Stage) bt_beenden.getScene().getWindow();
		Alert closeConfirmation = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to exit?");
		Button exitButton = (Button) closeConfirmation.getDialogPane().lookupButton(ButtonType.OK);
		exitButton.setText("Exit");
		closeConfirmation.setHeaderText("Confirm Exit");
		closeConfirmation.initModality(Modality.APPLICATION_MODAL);
		closeConfirmation.initOwner(mainStage);

		closeConfirmation.setX(mainStage.getX() + 150);
		closeConfirmation.setY(mainStage.getY() - 300 + mainStage.getHeight());

		Optional<ButtonType> closeResponse = closeConfirmation.showAndWait();

		if (ButtonType.OK.equals(closeResponse.get())) {
			System.exit(0);
		}

	}

	@Override
	public void initData() {
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

}
