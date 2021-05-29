package dlg.patientenverwaltung;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import awk.AnwendungskernException;
import dlg.menue.ControlledScreen;
import dlg.menue.Hauptmenue;
import dlg.menue.ScreensController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PatientenController implements Initializable, ControlledScreen {

	@FXML
	private Button bt_patientenErstellen;
	@FXML
	private Button bt_zurueck;
	@FXML
	private TextField tf_id;
	@FXML
	private TextField tf_name;
	@FXML
	private TextField tf_nachname;
	@FXML
	private TextField tf_email;
	@FXML
	private TextField tf_telefonnr;
	@FXML
	private TextField tf_geburtstag;
	@FXML
	private TextField tf_geburtsmonat;
	@FXML
	private TextField tf_geburtsjahr;

	ScreensController myController;

	@Override
	public void setScreenParent(ScreensController screenPage) {
		myController = screenPage;

	}

	@Override
	public void initData() {

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initGui();
	}

	private void initGui() {

		tf_id.setText("");
		tf_name.setText("");
		tf_nachname.setText("");
		tf_email.setText("");
		tf_telefonnr.setText("");
		tf_geburtstag.setText("");
		tf_geburtsmonat.setText("");
		tf_geburtsjahr.setText("");

	}

	@FXML
	public void bt_patientenErstellenClicked() {
		int id = Integer.parseInt(tf_id.getText());

		String name = tf_name.getText();
		String nachname = tf_nachname.getText();
		int geburtstag = Integer.parseInt(tf_geburtstag.getText());
		int geburtsmonat = Integer.parseInt(tf_geburtsmonat.getText());
		int geburtsjahr = Integer.parseInt(tf_geburtsjahr.getText());
		String email = tf_email.getText();
		int telefonnr = Integer.parseInt(tf_telefonnr.getText());

		try {
			myController.getAwkService().getPatientenErfassen().patientenErstellenR(id, name, nachname, geburtstag,
					geburtsmonat, geburtsjahr, email, telefonnr);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (AnwendungskernException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void bt_zurueckClicked() {
		initGui();
		myController.setScreen(Hauptmenue.MAIN_SCREEN);

	}

}
