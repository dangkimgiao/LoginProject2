package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.UserBLL;
import DTO.UserDTO;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class F_Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					F_Login frame = new F_Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public F_Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		txtUserName = new JTextField();
		contentPane.add(txtUserName, BorderLayout.NORTH);
		txtUserName.setColumns(10);
		
		txtPassword = new JTextField();
		contentPane.add(txtPassword, BorderLayout.CENTER);
		txtPassword.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDTO userDTO = new UserDTO(txtUserName.getText(), txtPassword.getText());
				UserBLL userBLL = new UserBLL();
				
				try {
					if(userBLL.Login(userDTO)==null) {
						//xuat message nhap username, password ko dung
					}
					else if (!userBLL.Login(userDTO).first()) //ko tim thay record nao thoa dk
					{
						//xuat message login ko thanh cong
					}
					else {
						//xuat message login thanh cong hoac lien toi form tiep theo
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		contentPane.add(btnLogin, BorderLayout.SOUTH);
	}

}
