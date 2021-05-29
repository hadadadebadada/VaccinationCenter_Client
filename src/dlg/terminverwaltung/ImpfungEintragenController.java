package dlg.terminverwaltung;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import awk.AnwendungskernException;
import awk.terminverwaltung.entity.TerminTO;
import dlg.menue.ControlledScreen;
import dlg.menue.Hauptmenue;
import dlg.menue.ScreensController;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ImpfungEintragenController implements Initializable, ControlledScreen {

	@FXML
	TextField tf_tag;
	@FXML
	TextField tf_monat;
	@FXML
	TextField tf_jahr;
	@FXML
	TextField tf_std;
	@FXML
	TextField tf_minute;

	@FXML
	TextField tf_bemerkung;
	@FXML
	TextField tf_ladeTerminByID;

	@FXML
	Button bt_ladeTerminByID;
	@FXML
	Button bt_patientenLaden;

	@FXML
	Label lb_terminId;

	@FXML
	Button bt_impfungEintragen;
	@FXML
	Button bt_zurueck;
	@FXML
	Label lb_patientenID;

	@FXML
	ComboBox<String> cb_selectVakzine;

	ScreensController myController;

	@FXML
	public void bt_ladeTerminByIDClicked() throws RemoteException {
		String terminid_string = tf_ladeTerminByID.getText();
		int terminID = 0;
		TerminTO terminTO = null;

		try {
			terminID = Integer.parseInt(terminid_string);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("Fehlerhafte eingabe..");

		}
		if (terminID != 0) {
			try {

				System.out.println("terminid ist: " + terminID);
				terminTO = myController.getAwkService().getTerminValidierenRemote().terminSuchenByIDR(terminID);
				System.out.println("bermerkung: " + terminTO.getBemerkung());
			} catch (AnwendungskernException e) {
				e.printStackTrace();
				System.out.println("Termin nicht gefunden");

			}
			if (terminTO != null) {
				lb_terminId.setText(String.valueOf(terminTO.getTerminID()));

			}

		}

	}

	@FXML
	public void bt_impfungEintragenClicked() {

		int vakzineID = 0;

		if (cb_selectVakzine.getValue() == "BionTec") {
			String vakzineId_string = "1";
			vakzineID = Integer.parseInt(vakzineId_string);
		} else if (cb_selectVakzine.getValue() == "AstraZeneca") {
			String vakzineId_string = "2";
			vakzineID = Integer.parseInt(vakzineId_string);
		} else if (cb_selectVakzine.getValue() == "Johnson&Johnson") {
			String vakzineId_string = "3";
			vakzineID = Integer.parseInt(vakzineId_string);
		}

		int terminID = Integer.parseInt(tf_ladeTerminByID.getText()); // 
		int impftag = Integer.parseInt(tf_tag.getText());
		int impfmonat = Integer.parseInt(tf_monat.getText());
		int impfjahr = Integer.parseInt(tf_jahr.getText());
		int std = Integer.parseInt(tf_std.getText());
		int min = Integer.parseInt(tf_minute.getText());
		String bemerkung = tf_bemerkung.getText();
		int patientenID = Integer.parseInt(lb_terminId.getText()); // 
		System.out.println("impfstoff mit der ID: " + vakzineID + " wurde verabreicht");

		try {
			myController.getAwkService().getTerminValidierenRemote().terminValidierenR(terminID, impftag, impfmonat,
					impfjahr, std, min, bemerkung, vakzineID, patientenID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AnwendungskernException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			myController.getAwkService().getBestandsveraenderungErfassenRemote().lagerbestandSenkenR(vakzineID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AnwendungskernException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	public void bt_zurueckClicked() {
		myController.setScreen(Hauptmenue.MAIN_SCREEN);

	}

	private void initGui() {
		cb_selectVakzine.getItems().setAll("BionTec", "AstraZeneca", "Johnson&Johnson");

	}

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

}
