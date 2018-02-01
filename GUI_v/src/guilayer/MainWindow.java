package guilayer;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import controllayer.Session;
import guilayer.layers.MainMenu;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class MainWindow {

	private JFrame mainFrame;

	private JTextField username;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JPasswordField passwordField;
	private MainMenu mainMenu = new MainMenu();

	private NotificationWindow notification = new NotificationWindow();

	/**
	 * Launch the application.
	 */
	public static void start() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			UIManager.getDefaults().put("TabbedPane.contentBorderInsets", new Insets(0, 0, 0, 0));
			UIManager.getDefaults().put("TabbedPane.tabsOverlapBorder", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setResizable(false);
		mainFrame.setBounds(100, 100, 1000, 800);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(new CardLayout(0, 0));

		// mainFrame.getContentPane().setLayout(null);

		JPanel loginPane = new JPanel();
		loginPane.setBounds(0, 0, 1000, 771);
		mainFrame.getContentPane().add(loginPane);
		loginPane.setLayout(null);

		mainFrame.getContentPane().add(loginPane, "login");
		mainFrame.getContentPane().add(mainMenu, "main");
		menuStateChange("main");

		JPanel logLeftPanel = new JPanel();
		logLeftPanel.setBackground(new Color(255, 235, 205));
		logLeftPanel.setBounds(0, 0, 500, 771);
		loginPane.add(logLeftPanel);
		logLeftPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/pics/xlbygSE.png")));
		lblNewLabel.setBounds(100, 270, 264, 264);
		logLeftPanel.add(lblNewLabel);

		JPanel logRightPanel = new JPanel();
		logRightPanel.setBackground(Color.DARK_GRAY);
		logRightPanel.setBounds(500, 0, 500, 771);
		loginPane.add(logRightPanel);
		logRightPanel.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(120, 345, 300, 2);
		logRightPanel.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(120, 425, 300, 2);
		logRightPanel.add(separator_1);

		username = new JTextField();
		username.setSelectedTextColor(new Color(208, 187, 130));
		username.setCaretColor(new Color(255, 235, 205));
		username.setBorder(null);
		username.setForeground(Color.WHITE);
		username.setBackground(Color.DARK_GRAY);
		username.setBounds(120, 315, 300, 30);
		logRightPanel.add(username);
		username.setColumns(15);

		passwordField = new JPasswordField();
		passwordField.setSelectedTextColor(new Color(255, 235, 205));
		passwordField.setCaretColor(new Color(255, 235, 205));
		passwordField.setForeground(Color.WHITE);
		passwordField.setBorder(null);
		passwordField.setBackground(Color.DARK_GRAY);
		passwordField.setBounds(120, 395, 300, 30);
		logRightPanel.add(passwordField);
		passwordField.setColumns(15);

		lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(120, 370, 300, 14);
		logRightPanel.add(lblPassword);
		lblPassword.setFont(new Font("Dubai", Font.BOLD, 14));

		lblUsername = new JLabel("USERNAME");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(120, 290, 300, 14);
		logRightPanel.add(lblUsername);
		lblUsername.setFont(new Font("Dubai", Font.BOLD, 14));

		JPanel btnlogin = new JPanel();
		btnlogin.setBackground(new Color(255, 235, 205));
		btnlogin.setBounds(120, 455, 176, 45);
		logRightPanel.add(btnlogin);
		btnlogin.setLayout(null);

		JLabel lblLogin = new JLabel("LogIn");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(Color.DARK_GRAY);
		lblLogin.setFont(new Font("Dubai", Font.BOLD, 14));
		lblLogin.setBounds(0, 0, 176, 44);
		btnlogin.add(lblLogin);

		JButton btnSubmit = new JButton("");
		btnSubmit.setVisible(false);
		btnSubmit.setBounds(0, 0, 0, 0);
		btnlogin.add(btnSubmit);

		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submit();
			}
		});
		btnlogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				submit();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnlogin.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnlogin.setBorder(null);
			}
		});
		mainFrame.getRootPane().setDefaultButton(btnSubmit);
	}

	private boolean userLogin(String username, String password) {
		try {
			if (Session.getInstance().login(username, password, "DIY")) {
				return true;
			}
		} catch (Exception ignored) {

		}
		return false;
	}

	private void submit() {
		if (username.getText().length() <= 0 && passwordField.getPassword().length <= 0)
			notification.errorWindow("Username and Password is missing!", "Error");
		else if (username.getText().length() <= 0)
			notification.errorWindow("Username is missing!", "Error");
		else if (passwordField.getPassword().length <= 0)
			notification.errorWindow("Password is missing!", "Error");
		else if (userLogin(username.getText(), String.valueOf(passwordField.getPassword())))
			menuStateChange("main");
		else
			notification.errorWindow("Wrong Username or Password!", "Error");
	}

	private void menuStateChange(String menuName) {
		CardLayout cl = (CardLayout) mainFrame.getContentPane().getLayout();
		cl.show(mainFrame.getContentPane(), menuName);
	}
}
