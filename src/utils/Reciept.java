package utils;

import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.Model;

public class Reciept extends JPanel {

	public JList<String> amount = new JList<String>();
	public DefaultListModel<String> defaultModel2 = new DefaultListModel<String>();
	public JList<String> items = new JList<String>();
	public DefaultListModel<String> defaultModel = new DefaultListModel<String>();
	public JList<String> cost = new JList<String>();
	public DefaultListModel<String> defaultModel3 = new DefaultListModel<String>();
	public Model model;

	public Reciept(Model model) {
		this.model = model;

		this.setLayout(new GridLayout(1, 3));

		amount.setModel(defaultModel2);
		amount.setAlignmentX(SwingConstants.CENTER);
		for (Itemvalues itemvalues : model.itemvalues) {
			defaultModel2.addElement(itemvalues.amount + "x");
		}
		this.add(amount);

		items.setModel(defaultModel);
		items.setAlignmentX(SwingConstants.CENTER);
		for (Itemvalues itemvalues : model.itemvalues) {
			defaultModel.addElement(itemvalues.name);
		}
		this.add(items);

		cost.setModel(defaultModel3);
		cost.setAlignmentX(SwingConstants.CENTER);
		for (Itemvalues itemvalues : model.itemvalues) {
			defaultModel3.addElement(itemvalues.cost + "");
		}
		this.add(cost);

		this.setVisible(true);

	}

}
