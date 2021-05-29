package dlg.vakzineverwaltung;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import awk.AnwendungskernException;
import awk.vakzineverwaltung.entity.BestandsveraenderungTO;
import awk.vakzineverwaltung.entity.VakzineTO;
import dlg.menue.ControlledScreen;
import dlg.menue.Hauptmenue;
import dlg.menue.ScreensController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class VakzineController implements Initializable, ControlledScreen {

	@FXML
	private Button bt_vakzineErstellen;
	@FXML
	private Button bt_zurueck;
	@FXML
	private Button bt_ladeVakzine;

	@FXML
	private Label bestand1;

	@FXML
	private Label lb_id;
	@FXML
	private TextField tf_anlieferung; // ?
	@FXML
	private TextField tf_liefertag;
	@FXML
	private TextField tf_liefermonat;
	@FXML
	private TextField tf_lieferjahr;

	@SuppressWarnings("rawtypes")
	@FXML
	private TableView tv_bestandsveraenderungen;
	ScreensController myController;

	@FXML
	private ComboBox<String> cb_id;

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

	@SuppressWarnings("unchecked")
	private void initGui() {

		cb_id.getItems().setAll("BionTec", "AstraZeneca", "Johnson&Johnson");

		tf_anlieferung.setText("");
		tf_liefertag.setText("");
		tf_liefermonat.setText("");
		tf_lieferjahr.setText("");

		@SuppressWarnings({ "rawtypes" })
		ObservableList<BestandsveraenderungTO> vakzineTable = FXCollections.observableArrayList(new ArrayList());
		tv_bestandsveraenderungen.setItems(vakzineTable);

	}

	@SuppressWarnings("unchecked")
	private void showTableView(Collection<BestandsveraenderungTO> bestandsveraenderungen) {

		ObservableList<BestandsveraenderungTO> vakzineTable = FXCollections.observableArrayList(bestandsveraenderungen);

		System.out.println("anzahl der chargen: " + vakzineTable.size());

		TableColumn<BestandsveraenderungTO, String> anzahlCol = new TableColumn<BestandsveraenderungTO, String>(
				"Anzahl");
		anzahlCol.setMinWidth(100);
		anzahlCol.setCellValueFactory(new PropertyValueFactory<BestandsveraenderungTO, String>("anzahl"));

		TableColumn<BestandsveraenderungTO, String> tagCol = new TableColumn<BestandsveraenderungTO, String>(
				"Liefertag");
		tagCol.setMinWidth(100);
		tagCol.setCellValueFactory(new PropertyValueFactory<BestandsveraenderungTO, String>("liefertag"));

		TableColumn<BestandsveraenderungTO, String> monatCol = new TableColumn<BestandsveraenderungTO, String>(
				"Liefermonat");
		monatCol.setMinWidth(100);
		monatCol.setCellValueFactory(new PropertyValueFactory<BestandsveraenderungTO, String>("Liefermonat"));

		TableColumn<BestandsveraenderungTO, String> jahrCol = new TableColumn<BestandsveraenderungTO, String>(
				"Lieferjahr");
		jahrCol.setMinWidth(100);
		jahrCol.setCellValueFactory(new PropertyValueFactory<BestandsveraenderungTO, String>("lieferjahr"));

		tv_bestandsveraenderungen.setItems(vakzineTable);
		@SuppressWarnings("rawtypes")
		ArrayList<TableColumn> aList = new ArrayList<TableColumn>();
		aList.add(anzahlCol);
		aList.add(tagCol);
		aList.add(monatCol);
		aList.add(jahrCol);
		tv_bestandsveraenderungen.getColumns().setAll(aList);

	}

	@FXML
	public void bt_ladeVakzineClicked() throws RemoteException {

		int vakzineId = 0;
		VakzineTO vakzineTO = null;

		try {
			// vakzineid wird aus der choicebox generiert
			if (cb_id.getValue() == "BionTec") {
				String vakzineId_string = "1";
				lb_id.setText("1");
				vakzineId = Integer.parseInt(vakzineId_string);
			} else if (cb_id.getValue() == "AstraZeneca") {
				lb_id.setText("2");
				String vakzineId_string = "2";
				vakzineId = Integer.parseInt(vakzineId_string);
			} else if (cb_id.getValue() == "Johnson&Johnson") {
				lb_id.setText("3");
				String vakzineId_string = "3";
				vakzineId = Integer.parseInt(vakzineId_string);
			}

			System.out.println("Eingabe erfolgreich");

		} catch (NumberFormatException e) {
			System.out.println("vakzineid ungueltig");
			e.printStackTrace();
		}

		if (vakzineId != 0) {
			try {
				System.out.println("starte vakzine zuordnen.. ID = " + vakzineId);
				vakzineTO = myController.getAwkService().getBestandsveraenderungErfassenRemote()
						.vakzineZuordnenByIdR(vakzineId); // vaktineTO geladen
				bestand1.setText(String.valueOf(vakzineTO.getLagerbestand()));

			} catch (AnwendungskernException e) {
				e.printStackTrace();
				System.out.println("diesen impfstoff gibt es nicht");
			}

			if (vakzineTO != null) {
				bestand1.setText(String.valueOf(vakzineTO.getLagerbestand()));
				showTableView(vakzineTO.getBestandsveraenderungen());
			}
		}
	}

	@FXML
	public void bt_vakzineErstellenClicked() throws RemoteException {

		int vakzineId = Integer.parseInt(lb_id.getText());
		String anzahl_string = tf_anlieferung.getText();
		int anzahl = 0;

		try {
			anzahl = Integer.parseInt(anzahl_string);
		} catch (NumberFormatException e) {
			System.out.println("falsche anzahl");
			e.printStackTrace();
		}

		if (anzahl != 0) {
			try {
				System.out.println("Lieferjahr ist: " + tf_lieferjahr.getText());
				myController.getAwkService().getBestandsveraenderungErfassenRemote().bestandErhoehenR(vakzineId, anzahl,
						Integer.parseInt(tf_liefertag.getText()), Integer.parseInt(tf_liefermonat.getText()),
						Integer.parseInt(tf_lieferjahr.getText()));
			} catch (AnwendungskernException e) {
				System.out.println("Lieferung erfassen fehlgeschlagen");
				e.printStackTrace();
			}
		}

	}

	@FXML
	public void bt_zurueckClicked() {
		initGui();
		myController.setScreen(Hauptmenue.MAIN_SCREEN);

	}

}
