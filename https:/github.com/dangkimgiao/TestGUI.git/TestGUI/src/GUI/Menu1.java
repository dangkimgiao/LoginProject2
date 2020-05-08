package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

import GUI.Menu;

public class Menu1 extends JFrame{
	
	public static void main (String[] args) {
		Menu1 menu = new Menu1 ("JMenu Demo");
		
	}
	
	public Menu1(String title) {
		setTitle(title);
		this.setSize(new Dimension(500,500));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		addControl();
		
		this.setVisible(true);
	}
	
	private void addControl() {
		JMenuBar menuBar;
		JMenu fileMenu, helpMen;
		JMenuItem menuItem;
		
		//tạo menu bar
		menuBar = new JMenuBar();
		
		//thiết lập menu Menu
		fileMenu = new JMenu("Menu");
		
		fileMenu.setMnemonic(KeyEvent.VK_M);
		//add menu File vào menubar
		menuBar.add(fileMenu);
		
		//thiết lập menuItem cho menuFile
		menuItem = new JMenuItem("New",KeyEvent.VK_N);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
                ActionEvent.SHIFT_MASK));
		menuItem.setIcon(createImageIcon("/resources/new_20.png"));
		fileMenu.add(menuItem);
		
		menuItem = new JMenuItem("Edit",KeyEvent.VK_E);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
                ActionEvent.SHIFT_MASK));
		menuItem.setIcon(createImageIcon("/resources/edit_20.png"));
		fileMenu.add(menuItem);
		
		//thiết lập submenu
		fileMenu.addSeparator();
		
		
		
		this.setJMenuBar(menuBar);
		
		
	}
	
	  protected static ImageIcon createImageIcon(String path) {
	        java.net.URL imgURL = Menu.class.getResource(path);
	        if (imgURL != null) {
	            return new ImageIcon(imgURL);
	        } else {
	            System.err.println("Không tìm thấy: " + path);
	            return null;
	        }
	    }


}
