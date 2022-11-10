package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.Model;
import utils.Reciept;

public class Recieptmenu extends JFrame implements ActionListener {

	public JLabel pageLabel = new JLabel("Seite 3/3");
	public JLabel nameJLabel = new JLabel();
	public JLabel adressJLabel = new JLabel();
	public JLabel paymentOptions = new JLabel();
	public Reciept reciept;
	public JLabel thanks = new JLabel("Vielen Dank für Ihre Bestellung");
	public JPanel buttonPanel = new JPanel();
	public JButton print = new JButton("Drucken");
	public JButton finish = new JButton("Abschliessen");
	public Model model;

	public Recieptmenu(Model model) {
		this.model = model;

		this.reciept = new Reciept(model);

		this.setTitle("Rechnung");
		this.setLayout(new GridLayout(7, 1));

		nameJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		adressJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		paymentOptions.setHorizontalAlignment(SwingConstants.CENTER);
		thanks.setHorizontalAlignment(SwingConstants.CENTER);
		pageLabel.setHorizontalAlignment(SwingConstants.CENTER);

		this.add(pageLabel);
		this.add(nameJLabel);
		this.add(adressJLabel);
		this.add(paymentOptions);
		this.add(reciept);
		this.add(thanks);

		nameJLabel.setText(model.name1 + " " + model.name2);
		adressJLabel.setText(model.street + " " + model.streetNumber + " " + model.city + " " + model.postalcode + " "
				+ model.country);
		paymentOptions.setText(model.totalCost + " Chf, " + model.paymentOption);

		buttonPanel.setLayout(new GridLayout(1, 2));
		print.setHorizontalAlignment(SwingConstants.CENTER);
		buttonPanel.add(print);
		finish.setHorizontalAlignment(SwingConstants.CENTER);
		finish.addActionListener(this);
		buttonPanel.add(finish);
		this.add(buttonPanel);

		this.setVisible(true);
		this.setSize(600, 900);
		this.repaint();
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == finish) {
			this.dispose();
		}
	}

}
