package utils;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import model.Model;

public class Adresslayout extends JPanel {

	public JLabel valueLabel = new JLabel();
	public JTextField inputTextField;
	public Model model;

	public Adresslayout(String val1, String val2, Model model) {
		this.model = model;
		this.inputTextField = new JTextField(val2);
		this.setLayout(new GridLayout(1, 2));
		this.valueLabel.setText(val1);
		this.valueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(valueLabel);
		this.inputTextField.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(inputTextField);
		this.setVisible(true);

		inputTextField.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if (val1 == "Vorname") {
					model.name1 = inputTextField.getText();
				}
				if (val1 == "Nachname") {
					model.name2 = inputTextField.getText();
				}
				if (val1 == "Strasse") {
					model.street = inputTextField.getText();
				}
				if (val1 == "Hausnummer") {
					model.streetNumber = inputTextField.getText();
				}
				if (val1 == "Ort") {
					model.city = inputTextField.getText();
				}
				if (val1 == "PLZ") {
					model.postalcode = inputTextField.getText();
				}
				if (val1 == "Land") {
					model.country = inputTextField.getText();
				}

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

}
