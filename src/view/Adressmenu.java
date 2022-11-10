package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.Model;
import utils.Adresslayout;

public class Adressmenu extends JFrame implements ActionListener {

	public JLabel pageLabel = new JLabel("Seite 2/3");
	public Adresslayout name1;
	public Adresslayout name2;
	public Adresslayout street;
	public Adresslayout streetNumber;
	public Adresslayout city;
	public Adresslayout postalcode;
	public Adresslayout country;
	public JComboBox<String> paymentOptionsBox = new JComboBox<String>();
	public JPanel paymentPanel = new JPanel();
	public JLabel payment = new JLabel("Zahlungsart");
	public JPanel amountPanel = new JPanel();
	public JLabel amountLabel = new JLabel("Zu zahlender Betrag");
	public JLabel finalAmountLabel = new JLabel("0");
	public JButton backButton = new JButton("Zurück zum Warenkorb");
	public JButton finishButton = new JButton("Bestellung abschliessen");
	public JPanel buttonPanel = new JPanel();
	public Model model;

	public Adressmenu(Model model) {
		this.model = model;
		this.setTitle("Anschrift");
		this.setLayout(new GridLayout(11, 1));

		Adresslayout name1 = new Adresslayout("Vorname", model.name1, model);
		Adresslayout name2 = new Adresslayout("Nachname", model.name2, model);
		Adresslayout street = new Adresslayout("Strasse", model.street, model);
		Adresslayout streetNumber = new Adresslayout("Hausnummer", model.streetNumber, model);
		Adresslayout city = new Adresslayout("Ort", model.city, model);
		Adresslayout postalcode = new Adresslayout("PLZ", model.postalcode, model);
		Adresslayout country = new Adresslayout("Land", model.country, model);

		pageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		paymentOptionsBox.addActionListener(this);
		addPaymentOptions(model);

		this.add(pageLabel);
		this.add(name1);
		this.add(name2);
		this.add(street);
		this.add(streetNumber);
		this.add(city);
		this.add(postalcode);
		this.add(country);

		paymentPanel.setLayout(new GridLayout(1, 2));
		paymentPanel.add(payment);
		payment.setHorizontalAlignment(SwingConstants.CENTER);
		paymentPanel.add(paymentOptionsBox);
		this.add(paymentPanel);

		amountPanel.setLayout(new GridLayout(1, 2));
		amountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		amountPanel.add(amountLabel);
		finalAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		amountPanel.add(finalAmountLabel);
		this.add(amountPanel);

		finalAmountLabel.setText(model.totalCost + "");

		buttonPanel.setLayout(new GridLayout(1, 2));
		backButton.addActionListener(this);
		buttonPanel.add(backButton);
		finishButton.addActionListener(this);
		buttonPanel.add(finishButton);
		this.add(buttonPanel);

		this.setVisible(true);
		this.setSize(600, 600);
		this.repaint();
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
	}

	public void addPaymentOptions(Model model) {
		paymentOptionsBox.addItem("Direktüberweisung");
		paymentOptionsBox.addItem("Paypal");
		paymentOptionsBox.addItem("Kreditkarte");
		paymentOptionsBox.addItem("Bar");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == paymentOptionsBox) {
			model.paymentOption = (String) paymentOptionsBox.getSelectedItem();
		}
		if (e.getSource() == backButton) {
			Mainmenu mainmenu = new Mainmenu(model);
			this.dispose();
		}
		if (e.getSource() == finishButton) {
			Recieptmenu recieptMenu = new Recieptmenu(model);
			this.dispose();
		}
	}

}
