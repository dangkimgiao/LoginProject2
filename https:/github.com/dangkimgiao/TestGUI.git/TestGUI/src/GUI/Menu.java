package GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;


public class Menu extends JFrame implements ActionListener, ItemListener {
    
	JTextArea output;
    JScrollPane scrollPane;
    String newline = "\n";
 
    public Menu(String title) {
    	//set cac thong so cho Jframe
    			this.setTitle(title);
    			this.setSize(600,600);
    			this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    			this.setLocationRelativeTo(null);
 
    			//ve cac control
    			addControl();
    		  	 
    	        // hien thi window.
    			this.setVisible(true);
    	
    }
    private void addControl() {
    	// Create/set menu bar and content pane.
    	setJMenuBar(createMenuBar());
        setContentPane(createContentPane());
        
        // Create and set up the popup menu.
        createPopupMenu();
    }
    public JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem;
        JRadioButtonMenuItem rbMenuItem;
        JCheckBoxMenuItem cbMenuItem;
 
        //tao menu bar
        menuBar = new JMenuBar();
 
        // menu 1
        menu = new JMenu("File");
        //thiết lập phím tắt Atl_F để nhấn menu
        //nhấn tổ hợp phím này thì menu/menuitem xổ xuống
        menu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(menu);
 
        // a group of JMenuItems
        //NEW
        ImageIcon icon = createImageIcon("/resources/new_20.png");
        menuItem = new JMenuItem("New", KeyEvent.VK_N); //thay thế cho menuItem.setMnemonic(KeyEvent.VK_N)
        menuItem.setIcon(icon);
        //thiết lập tổ hợp phím Shift_N
        //nhấn tổ hợp phím này thì menu item "New" được thực thi
        //muốn tổ hợp phím khác ALT thì dùng CTRL_MASK hoặc SHIFT_MASK
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
                ActionEvent.SHIFT_MASK));
        
        //sự kiện click menuitem "New"
        menuItem.addActionListener(this);
        menu.add(menuItem);
 
        // kẽ đường ngang trong menu
        menu.addSeparator();
        
 
        // a submenu
      
        submenu = new JMenu("A submenu");
        submenu.setMnemonic(KeyEvent.VK_S);
 
        menuItem = new JMenuItem("An item in the submenu");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,
                ActionEvent.ALT_MASK));
        menuItem.addActionListener(this);
        submenu.add(menuItem);
 
        menuItem = new JMenuItem("Another item");
        menuItem.addActionListener(this);
        submenu.add(menuItem);
        menu.add(submenu);
 
        // Build second menu in the menu bar.
        menu = new JMenu("Another Menu");
        menu.setMnemonic(KeyEvent.VK_N);
        menu.getAccessibleContext().setAccessibleDescription(
                "This menu does nothing");
        menuBar.add(menu);
 
        return menuBar;
    }
 
    public Container createContentPane() {
        // Create the content-pane-to-be.
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);
 
        // Create a scrolled text area.
        output = new JTextArea(5, 30);
        output.setEditable(false);
        scrollPane = new JScrollPane(output);
 
        // Add the text area to the content pane.
        contentPane.add(scrollPane, BorderLayout.CENTER);
 
        return contentPane;
    }
 
    public void createPopupMenu() {
        JMenuItem menuItem;
 
        // Create the popup menu.
        JPopupMenu popup = new JPopupMenu();
        menuItem = new JMenuItem("A popup menu item");
        menuItem.addActionListener(this);
        popup.add(menuItem);
        menuItem = new JMenuItem("Another popup menu item");
        menuItem.addActionListener(this);
        popup.add(menuItem);
 
        // Add listener to the text area so the popup menu can come up.
        MouseListener popupListener = (MouseListener) new PopupListener(popup);
        output.addMouseListener(popupListener);
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem source = (JMenuItem) (e.getSource());
        String s = "Menu " + source.getText() + " (thuộc " + getClassName(source)
                + ")";
        output.append(s + newline);
        output.setCaretPosition(output.getDocument().getLength());
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        JMenuItem source = (JMenuItem) (e.getSource());
        String s = "Item event detected."
                + newline
                + "    Event source: "
                + source.getText()
                + " (an instance of "
                + getClassName(source)
                + ")"
                + newline
                + "    New state: "
                + ((e.getStateChange() == ItemEvent.SELECTED) ? "selected"
                        : "unselected");
        output.append(s + newline);
        output.setCaretPosition(output.getDocument().getLength());
    }
 
    // Returns just the class name -- no package info.
    protected String getClassName(Object o) {
        String classString = o.getClass().getName();
        int dotIndex = classString.lastIndexOf(".");
        return classString.substring(dotIndex + 1);
    }
 
    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = Menu.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
 
    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread.
     */
/*    private static void createAndShowGUI() {
        // Create and set up the window.
        JFrame frame = new JFrame("DemoRightClickMenu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 

    }*/
 
    public static void main(String[] args) {

    	 Menu demo = new Menu("Demo MenuBar");
    }
 
    class PopupListener extends MouseAdapter {
        JPopupMenu popup;
 
        PopupListener(JPopupMenu popupMenu) {
            popup = popupMenu;
        }
 
        public void mousePressed(MouseEvent e) {
            maybeShowPopup(e);
        }
 
        public void mouseReleased(MouseEvent e) {
            maybeShowPopup(e);
        }
 
        private void maybeShowPopup(MouseEvent e) {
            if (e.isPopupTrigger()) {
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        }
    }


}
