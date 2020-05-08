package GUI;

import java.awt.*;
import javax.swing.*;

public class BorderLayoutGUI extends JFrame {
	
/*	public static void main(String[] args) {
		BorderLayoutGUI layout = new BorderLayoutGUI("Border Layout");
		
	}*/
	
	public BorderLayoutGUI(String title) {
		this.setTitle(title);
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		addControl();
		this.setVisible(true);
	}
	
	private void addControl() {
		//panel border
		JPanel pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());
		
		Font ft = new Font("Arial", Font.BOLD, 20);
			
		//panel NOrth
		JPanel pnNorth = new JPanel();
		pnNorth.setBackground(Color.RED);
		pnNorth.setPreferredSize(new Dimension(0,50));
		
		JLabel lblNorth = new JLabel("North");
		lblNorth.setForeground(Color.WHITE);
		lblNorth.setFont(ft);
		pnNorth.add(lblNorth);
		
		pnBorder.add(pnNorth, BorderLayout.NORTH);
		
		//panel South
		
		JPanel pnSouth = new JPanel();
		pnSouth.setBackground(Color.RED);
		pnSouth.setPreferredSize(new Dimension(0,50));
		
		JLabel lblSouth = new JLabel ("South");
		lblSouth.setFont(ft);
		lblSouth.setForeground(Color.WHITE);
		pnSouth.add(lblSouth);
		
		pnBorder.add(pnSouth,BorderLayout.SOUTH);
		
		//panel West
		JPanel pnWest = new JPanel();
		pnWest.setLayout(new BorderLayout());
		pnWest.setBackground(Color.BLUE);
		pnWest.setPreferredSize(new Dimension(70,0));
		
		JLabel lblWest = new JLabel("West", JLabel.CENTER);
		lblWest.setFont(ft);
		lblWest.setForeground(Color.WHITE);
		
		pnWest.add(lblWest, BorderLayout.CENTER);
		
		pnBorder.add(pnWest, BorderLayout.WEST);
		
		//panel East
		JPanel pnEast = new JPanel();
		pnEast.setLayout(new BorderLayout());
		pnEast.setBackground(pnWest.getBackground());
		pnEast.setPreferredSize(pnWest.getPreferredSize());
		
		JLabel lblEast = new JLabel("East",JLabel.CENTER);
		lblEast.setForeground(Color.WHITE);
		lblEast.setFont(ft);
		pnEast.add(lblEast, BorderLayout.CENTER);
		
		pnBorder.add(pnEast,BorderLayout.EAST);
		
		
		//panel center
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BorderLayout());
		pnCenter.setBackground(Color.YELLOW);
		
		JLabel lblCenter = new JLabel("Center", JLabel.CENTER);
		lblCenter.setFont(ft);
		pnCenter.add(lblCenter, BorderLayout.CENTER);
		
		pnBorder.add(pnCenter, BorderLayout.CENTER);
		
		this.setContentPane(pnBorder);
		
	}

}
