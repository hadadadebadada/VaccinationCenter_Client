package dlg.terminverwaltung;

import java.net.URL;
import java.rmi.RemoteException;

import java.util.Collection;
import java.util.ResourceBundle;

import awk.AnwendungskernException;
import awk.patientenverwaltung.entity.PatientTO;
import dlg.menue.ControlledScreen;
import dlg.menue.Hauptmenue;
import dlg.menue.ScreensController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TerminverwaltungsController implements Initializable, ControlledScreen {

	ScreensController myController;

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
	Label lb_patientenId;
	@FXML
	Label lb_name;

	@FXML
	Button bt_zurueck;
	@FXML
	Button bt_terminAnlegen;
	@FXML
	Button bt_ladePatienten;

	@FXML
	TextField tf_patientenId;

	ObservableList<String> patientenlisteOL = FXCollections.observableArrayList();

	@FXML
	ChoiceBox<String> cb_selectPatient = new ChoiceBox<String>(patientenlisteOL);

	ChangeListener<String> changeListener = new ChangeListener<String>() {

		@Override
		public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
			//
			lb_name.setText(arg2);

		}
	};

	private void initGui() {

		tf_tag.setText("");
		tf_monat.setText("");
		tf_jahr.setText("");
		tf_std.setText("");
		tf_minute.setText("");
		lb_name.setText("");

	}

	@FXML
	public void bt_ladePatientenClicked() {

		try {
			Collection<PatientTO> data = myController.getAwkService().getPatientenlisteLadenRemote()
					.patientenListeAusgebenR();
			for (PatientTO patientTO : data) {

				cb_selectPatient.getItems().add(patientTO.toString());

				System.out.println(patientTO.getNachname());
			}

		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (AnwendungskernException e) {
			e.printStackTrace();
			System.out.println("Fehler beim laden der patientenlsite");
		}

	}

	@FXML
	public void bt_terminAnlegenClicked() {

		// StringTO aus dem patienten wird aufteilt und die ID genutzt um die terminID und patientenID als foreign- bzw. primarykey in der db zusetzen
		String str = lb_name.getText();
		String[] tokens = str.split(" ");

		String command = tokens[0];

		int terminid = Integer.parseInt(command);
		int impftag = Integer.parseInt(tf_tag.getText());
		int impfmonat = Integer.parseInt(tf_monat.getText());
		int impfjahr = Integer.parseInt(tf_jahr.getText());
		int std = Integer.parseInt(tf_std.getText());
		int min = Integer.parseInt(tf_minute.getText());
		String bemerkung = "";
		int vakzineId = 0;
		int patientenId = Integer.parseInt(command);

		System.out.println("beginne mit db-zugriff");

		try {
			myController.getAwkService().getTerminErstellenRemote().terminErstellen(terminid, impftag, impfmonat,
					impfjahr, std, min, bemerkung, vakzineId, patientenId);
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

	@Override
	public void setScreenParent(ScreensController screenPage) {
		myController = screenPage;

	}

	@Override
	public void initData() {
		bt_ladePatientenClicked();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		cb_selectPatient.getSelectionModel().selectedItemProperty().addListener(changeListener); 

	}

}
