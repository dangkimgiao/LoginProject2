package GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AddRemoveList extends JFrame {
	
	JList<String> myList;
	JTextField tf;
	
/*	public static void main(String[] args) {
		AddRemoveList form = new AddRemoveList("JList");
		
	}
*/
	public AddRemoveList(String title) {
		
		//set cac thong so cho Jframe
		this.setTitle(title);
		this.setSize(200,200);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		//ve cac control
		addControl();
		
		this.setVisible(true);
		
	}
	
	private void addControl() {
		//tao panel tong
		JPanel bPanel = new JPanel();
		bPanel.setLayout(new BorderLayout());
		//them cac panel South, Center, North
		bPanel.add(addNorthPanel(), BorderLayout.NORTH);
		bPanel.add(addJList(), BorderLayout.CENTER);
		bPanel.add(addSouthPanel(), BorderLayout.SOUTH);
		
		this.setContentPane(bPanel);
	}
	
	private JPanel addNorthPanel() {
		JPanel panel = new JPanel();
		panel.add(addDeleteButton("Delete"));
		return panel;
	}
	private JButton addDeleteButton(String text) {
		JButton button = new JButton(text);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				deleteItem();
			}
			
		});
		return button;
	}
	
	private void deleteItem() {
		
		//lay du lieu trong list
		DefaultListModel<String> model = (DefaultListModel<String>) myList.getModel();
		
		//xoa item
		if(!model.isEmpty()) {
			model.remove(myList.getSelectedIndex());
		}
		myList.setModel(model);
		
	}
	
/*	private JPanel addCenterPanel() {
		JPanel panel = new JPanel();
		panel.add();
		return panel;
	}*/
	
	private JList addJList() {
		//tao model
		DefaultListModel<String> model = new DefaultListModel<String>();
		model.addElement("Mango");
		model.addElement("Apple");
		//add model vao JList
		myList = new JList<String>(model);
		
		return myList;
	}
	
	private JPanel addSouthPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		tf = new JTextField();
		panel.add(tf, BorderLayout.NORTH);
		panel.add(addButton("Add"), BorderLayout.SOUTH);
		return panel;
	}
	
	private JButton addButton(String text) {
		JButton btn = new JButton(text);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String item = tf.getText();
				if(item.equals("")) {
					JOptionPane.showMessageDialog(null, "Nhap item vao","Error", JOptionPane.ERROR_MESSAGE);
				}
				else{
					DefaultListModel model = (DefaultListModel) myList.getModel();
					model.addElement(item);
					myList.setModel(model);
					tf.setText("");
				}
				
			}
			
			
		});
		return btn;
				 
	}
}
