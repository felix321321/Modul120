package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.Model;
import utils.Itemlayout;

public class Mainmenu extends JFrame implements ActionListener, MouseListener {

	public JLabel productJLabel = new JLabel("Produkt");
	public JLabel costJLabel = new JLabel("Preis");
	public JLabel cartJLabel = new JLabel("Warenkorb");
	public JPanel topJPanel = new JPanel();
	public JLabel pageLabel = new JLabel("Seite 1/3");
	public Itemlayout layout1;
	public Itemlayout layout2;
	public Itemlayout layout3;
	public Itemlayout layout4;
	public Itemlayout layout5;
	public Itemlayout layout6;
	public Itemlayout layout7;
	public JLabel paymentJLabel = new JLabel(
			"Ihre Beszahlmöglichkeiten sind Paypal, Kreditkarte, Direktüberweisung und Bar.");
	public JPanel bottomJPanel = new JPanel();
	public JButton reset = new JButton("Produkte zurücksetzen");
	public JLabel sum = new JLabel("0");
	public JButton checkoutButton = new JButton("Checkout");
	public Model model;

	public Mainmenu(Model model) {
		this.model = model;

		Itemlayout layout1 = new Itemlayout("Apfel", "1", model);
		Itemlayout layout2 = new Itemlayout("Birne", "2", model);
		Itemlayout layout3 = new Itemlayout("Banane", "3", model);
		Itemlayout layout4 = new Itemlayout("Hundefutter", "5", model);
		Itemlayout layout5 = new Itemlayout("PC", "256", model);
		Itemlayout layout6 = new Itemlayout("Auto", "512", model);
		Itemlayout layout7 = new Itemlayout("Brot", "2", model);

		this.setTitle("Hauptmenü");
		this.setLayout(new GridLayout(11, 1));

		topJPanel.setLayout(new GridLayout(1, 3));
		productJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		topJPanel.add(productJLabel);
		costJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		topJPanel.add(costJLabel);
		cartJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		topJPanel.add(cartJLabel);

		pageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		paymentJLabel.setHorizontalAlignment(SwingConstants.CENTER);

		bottomJPanel.setLayout(new GridLayout(1, 3));
		reset.addActionListener(this);
		bottomJPanel.add(reset, BorderLayout.CENTER);
		sum.setHorizontalAlignment(SwingConstants.CENTER);
		bottomJPanel.add(sum);
		checkoutButton.addActionListener(this);
		bottomJPanel.add(checkoutButton, BorderLayout.CENTER);

		this.add(pageLabel);
		this.add(topJPanel);
		this.add(layout1);
		this.add(layout2);
		this.add(layout3);
		this.add(layout4);
		this.add(layout5);
		this.add(layout6);
		this.add(layout7);
		this.add(paymentJLabel);
		this.add(bottomJPanel);

		this.addMouseListener(this);

		this.setVisible(true);
		this.setSize(600, 600);
		this.repaint();
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == reset) {
			model.reset();
			Mainmenu mainmenu = new Mainmenu(model);
			this.dispose();
		}
		if (e.getSource() == checkoutButton) {
			Adressmenu adressmenu = new Adressmenu(model);
			this.dispose();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		sum.setText(model.totalCost() + "");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
