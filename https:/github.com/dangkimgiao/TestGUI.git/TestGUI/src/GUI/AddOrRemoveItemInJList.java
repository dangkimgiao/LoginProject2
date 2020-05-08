package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AddOrRemoveItemInJList extends JFrame  {
    private JTextField tfAdd;
    private JList<String> myList;
    
    public  AddOrRemoveItemInJList() {

        setTitle("MyJList");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200,200);
        setLocationRelativeTo(null);
        
        addControl();
        
        setVisible(true);
    }
    private void addControl() {
        // border panel
        JPanel panel = new JPanel(new BorderLayout());
        
        // add content
        panel.add(deletePanel(), BorderLayout.PAGE_START);
        panel.add(addPanel(), BorderLayout.PAGE_END);
        panel.add(addList(), BorderLayout.CENTER);
        
        this.setContentPane(panel);
    }
 
    // delete panel
    private JPanel deletePanel() {
        JPanel panel = new JPanel();
        panel.add(addButton("Delete"));
        return panel;
    }
 
    // add panel
    private JPanel addPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(tfAdd = new JTextField());
        panel.add(addButton("Add"));
        return panel;
    }
 
    // Jlist
    private JList<String> addList() {
    	
        // create defaultListModel
        DefaultListModel<String> model = new DefaultListModel<>();
        
        // add element to model
        model.addElement("Mango");
        model.addElement("Apple");
        
        // set model to JList
        myList = new JList<String>(model);
        
        return myList;
    }
 
    // create a button
    private JButton addButton(String btnName) {
        JButton btn = new JButton(btnName);
        btn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand() == "Delete") {
                    deleteItem();
                    return;
                }
                if (e.getActionCommand() == "Add") {
                    addItem();
                }
            }
        });
        return btn;
    }
 
    private void deleteItem() {
        // get model of Jlist
        DefaultListModel<String> model = (DefaultListModel<String>) myList.getModel();
        // delete item is selected
        if (!model.isEmpty() && myList.getSelectedIndex() >= 0) {
            model.remove(myList.getSelectedIndex());
        }
        // set model for JList
        myList.setModel(model);
    }
 
    private void addItem() {
        String item = tfAdd.getText().trim();
        if (item.equals("")) {
            JOptionPane.showMessageDialog(null,
                    "Pleas enter item add to Jlist", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            DefaultListModel model = (DefaultListModel) myList.getModel();
            model.addElement(item);
            myList.setModel(model);
            tfAdd.setText("");
        }
    }
 

    public static void main(String[] args) {
        new AddOrRemoveItemInJList();
    }

	

}
