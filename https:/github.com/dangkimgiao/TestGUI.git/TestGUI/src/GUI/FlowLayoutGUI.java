package GUI;

//import 2 goi awt va swing.awt
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class FlowLayoutGUI extends JFrame {
	
	public FlowLayoutGUI(String title) {
		
		this.setTitle(title);
		this.setSize(500, 500);
		//this.setSize(new Dimension(600,100));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLocationRelativeTo(null);
		AddControl();
		this.setVisible(true);
	}
	
	private void AddControl() {
		
		//ve JPanel và set layout
		JPanel pnFlow = new JPanel();
		pnFlow.setLayout(new FlowLayout());
		pnFlow.setBackground(Color.PINK);
		
		ImageIcon next = new ImageIcon(FlowLayoutGUI.class.getResource("/resources/next.jpg"), "Next");
		//JPanel pnFlow = new JPanel(new FlowLayout());
		
		//ve các control
		JButton btn1 = new JButton(next);
		//btn1.setForeground(Color.BLUE);
		JButton btn2 = new JButton ("Button 2");
		btn2.setPreferredSize(new Dimension(100,30));
		JButton btn3 = new JButton ("Button 3");
		JButton btn4 = new JButton("Button 4");
		JButton btn5 = new JButton ("Button 5");
		
		JButton btn6 = new JButton("Button 6");
		
		JTextField tf1 = new JTextField("Nhap Password:");
		tf1.setForeground(Color.LIGHT_GRAY);
		tf1.setPreferredSize(new Dimension(100,30));
		tf1.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(tf1.getText().equals("Nhap Password:")) {
					tf1.setText("");
					tf1.setForeground(Color.BLACK);
				}
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
/*				if(tf1.getText().equals("Nhap Password:")) {
					tf1.setText("");
					tf1.setForeground(Color.BLACK);
				}*/
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				tf1.setForeground(Color.RED);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				tf1.setForeground(Color.BLACK);
			}
			
		});
		JPasswordField pf = new JPasswordField();
		pf.setPreferredSize(new Dimension(100,30));
		
		JTextField tf2 = new JTextField(200);
		
		JTextArea ta = new JTextArea("JTextArea(): Tạo một TextArea mới.\n" + 
				"JTextArea(String s): Tạo một TextArea mới với text đã cho.\n" + 
				"JTextArea(int row, int column): Tạo một TextArea mới với số hàng và cột đã cho.\n" + 
				"JTextArea(String s, int row, int column): Tạo một TextArea mới với text, số hàng và cột đã cho.\n" + 
				"");
		ta.insert("SGU", 2);
		ta.append("SGU");
/*		JTextField tf1 = new JTextField(20);
		JTextArea ta1 = new JTextArea("ws): Được sử dụng để thiết lập số hàng đã cho.\n" + 
				"\n" + 
				"2. public void setColumns(int cols): Được sử dụng để thiết lập số cột đã cho",10, 10);
		ta1.insert("Giao", 3);
		ta1.append("Giao");*/
		pnFlow.add(btn1);
		pnFlow.add(btn2);
		pnFlow.add(btn3);
		pnFlow.add(btn4);
		pnFlow.add(btn5);
		//pnFlow.add(tf1);
		//pnFlow.add(ta1);
		pnFlow.add(btn6);
		pnFlow.add(tf1);
		pnFlow.add(pf);
		pnFlow.add(tf2);
		pnFlow.add(ta);
		this.setContentPane(pnFlow);
		
	}
	
/*	public static void main (String[] args) {
		FlowLayoutGUI layout = new FlowLayoutGUI("Flow Layout");
	}*/

}
