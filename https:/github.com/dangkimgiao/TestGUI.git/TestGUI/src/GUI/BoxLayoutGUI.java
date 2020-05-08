package GUI;

import java.awt.*;
import javax.swing.*;

public class BoxLayoutGUI extends JFrame {
	
/*	public static void main (String[] args) {
		BoxLayoutGUI layout = new BoxLayoutGUI();
		
	}*/
	
	public BoxLayoutGUI() {
		//thiết lập các thông số cơ bản
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		addControl();
		this.setVisible(true);
	}
	
	//vẽ JPanel và add các control
	private void addControl() {
		Font ft = new Font("Arial", Font.ITALIC,20);
		
		//vẽ JPanel
		JPanel pnBox = new JPanel();
		pnBox.setLayout(new BoxLayout(pnBox,BoxLayout.X_AXIS));
		
		//thêm controls vào JPanel
		JButton btn1 = new JButton ("Button 1");
		btn1.setFont(ft);
		btn1.setForeground(Color.RED);
		JButton btn2 = new JButton("Button 2");
		JButton btn3 = new JButton("Button 3");
		
		pnBox.add(btn1);
		pnBox.add(btn2);
		pnBox.add(btn3);
		
		//set nội dung panel vào frame
		this.setContentPane(pnBox);
		
	}

}
