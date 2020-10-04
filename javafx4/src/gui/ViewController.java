package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController implements Initializable {

	@FXML
	private TextField txtNumeroUm;
	@FXML
	private TextField txtNumeroDois;

	@FXML
	private Label labelResultado;

	@FXML
	private Button btSum;

	@FXML
	public void onBtSumAction() {
		try {
			Locale.setDefault(Locale.US);
			double number1 = Double.parseDouble(txtNumeroUm.getText());
			double number2 = Double.parseDouble(txtNumeroDois.getText());

			double soma = number1 + number2;

			labelResultado.setText(String.format("%.2f", soma));
		} catch (NumberFormatException e) {
			Alerts.showAlert("Erroe", null, e.getMessage(), AlertType.ERROR);
		}

	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		Constraints.setTextFieldDouble(txtNumeroUm);
		Constraints.setTextFieldDouble(txtNumeroDois);
		Constraints.setTextFieldMaxLength(txtNumeroUm, 12);
		Constraints.setTextFieldMaxLength(txtNumeroDois, 12);

	}

}
