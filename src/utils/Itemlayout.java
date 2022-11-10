package utils;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.Model;

public class Itemlayout extends JPanel implements ActionListener, FocusListener {

	public JLabel productname = new JLabel();
	public JLabel cost = new JLabel();
	public JButton plusButton = new JButton("+");
	public JTextField amount = new JTextField("0");
	public JButton minusButton = new JButton("-");
	public JPanel buttonPanel = new JPanel();
	public String tmpString;
	public Model model;

	public Itemlayout(String productname, String cost, Model model) {
		this.model = model;

		this.productname.setText(productname);
		this.productname.setHorizontalAlignment(SwingConstants.CENTER);
		this.cost.setText(cost);
		this.cost.setHorizontalAlignment(SwingConstants.CENTER);

		this.setLayout(new GridLayout(1, 3));
		buttonPanel.setLayout(new GridLayout(1, 3));

		this.add(this.productname);
		this.add(this.cost);
		amount.addFocusListener(this);
		minusButton.addActionListener(this);
		buttonPanel.add(minusButton);
		amount.setHorizontalAlignment(SwingConstants.CENTER);
		buttonPanel.add(amount);
		plusButton.addActionListener(this);
		buttonPanel.add(plusButton);
		this.add(buttonPanel);
		this.setVisible(true);

		if (model.itemExists(productname)) {
			Itemvalues item = model.getItem(productname);
			amount.setText(item.amount + "");
		} else {
			Itemvalues item = new Itemvalues(0, productname, Integer.parseInt(cost));
			model.itemvalues.add(item);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == minusButton) {
			if (Integer.parseInt(amount.getText()) > 0) {
				amount.setText(Integer.toString(Integer.parseInt(amount.getText()) - 1));
			}

		}
		if (e.getSource() == plusButton) {
			Itemvalues item = new Itemvalues((Integer.parseInt(amount.getText()) + 1), productname.getText(),
					Integer.parseInt(cost.getText()));
			for (Itemvalues i : model.itemvalues) {
				if (i.name == item.name) {
					model.itemvalues.set(model.itemvalues.indexOf(i), item);
				}
//				System.out.println(i.amount);
//				System.out.println(i.name);
//				System.out.println(i.cost);
//				System.out.println("---------------------");
			}
			amount.setText(Integer.toString(Integer.parseInt(amount.getText()) + 1));
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		tmpString = amount.getText();
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == amount) {
			try {
				int tmp = Integer.parseInt(amount.getText());
				if (tmp >= 0) {
					amount.setText(Integer.toString(tmp));
				} else {
					throw new Exception();
				}
			} catch (Exception e2) {
				amount.setText(tmpString);
			}
		}
	}

}
