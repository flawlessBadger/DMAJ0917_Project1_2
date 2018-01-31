package guilayer.employeePanels;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;

import controllayer.EmployeeController;
import controllayer.EmployeeEditor;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class EmployeeView extends JPanel implements ActionListener, KeyListener {
	private JTable table;
	private JTextField txtName;
	private JTextField nameField;
	private JTextField passwordField;
	private JTextField addressField;
	private JTextField loginField;
	private JTextField repeatPasswordField;
	private JSpinner spinnerAL;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;
	private JLabel lblName;
	private JLabel lblPassword;
	private JLabel lblRepeatPass;
	JPanel panel;
	JPanel panel_1;
	EmployeeController ec = new EmployeeController();
	private JButton btnCancel;

	public EmployeeView() {
		setLayout(null);

		panel_1 = new JPanel();
		panel_1.setVisible(false);
		panel_1.setBounds(0, 0, 800, 721);
		add(panel_1);
		panel_1.setLayout(null);

		lblNewLabel_1 = new JLabel("Login:");
		lblNewLabel_1.setBounds(50, 70, 100, 30);
		panel_1.add(lblNewLabel_1);

		loginField = new JTextField();
		loginField.setBounds(50, 100, 250, 35);
		panel_1.add(loginField);
		loginField.setColumns(10);

		lblName = new JLabel("Name:");
		lblName.setBounds(50, 180, 123, 30);
		panel_1.add(lblName);

		nameField = new JTextField();
		nameField.setBounds(50, 210, 250, 35);
		panel_1.add(nameField);
		nameField.setColumns(10);

		addressField = new JTextField();
		addressField.setBounds(50, 320, 350, 70);
		panel_1.add(addressField);
		addressField.setColumns(10);

		lblNewLabel = new JLabel("Address:");
		lblNewLabel.setBounds(50, 290, 123, 26);
		panel_1.add(lblNewLabel);

		JLabel lblAccessLevel = new JLabel("Access level:");
		lblAccessLevel.setBounds(50, 435, 136, 26);
		panel_1.add(lblAccessLevel);

		SpinnerModel model = new SpinnerNumberModel(3, 0, 3, 1);
		spinnerAL = new JSpinner(model);
		spinnerAL.setBounds(50, 460, 41, 32);
		panel_1.add(spinnerAL);

		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(50, 545, 136, 26);
		panel_1.add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(50, 575, 250, 35);
		panel_1.add(passwordField);
		passwordField.setColumns(10);

		lblRepeatPass = new JLabel("Repeat password:");
		lblRepeatPass.setBounds(400, 545, 186, 26);
		panel_1.add(lblRepeatPass);

		repeatPasswordField = new JPasswordField();
		repeatPasswordField.setBounds(400, 575, 250, 32);
		panel_1.add(repeatPasswordField);
		repeatPasswordField.setColumns(10);

		JButton registerButton = new JButton("Confirm");
		registerButton.setBounds(50, 670, 140, 35);
		registerButton.setActionCommand("register");
		panel_1.add(registerButton);

		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(551, 670, 141, 35);
		btnCancel.setActionCommand("cancel");
		panel_1.add(btnCancel);
		// header.setOpaque(true);
		// header.setBackground(new Color(255, 235, 205));

		panel = new JPanel();
		panel.setBounds(0, 0, 800, 721);
		add(panel);
		panel.setLayout(null);

		table = new JTable(new EmployeeModel());
		table.setPreferredSize(new Dimension(800, 721));
		table.setPreferredScrollableViewportSize(new Dimension(800, 721));
		table.setBackground(new Color(255, 235, 205));
		table.setRowHeight(35);
		JTableHeader header = table.getTableHeader();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(30, 70, 740, 671);
		panel.add(scrollPane);

		txtName = new JTextField();
		txtName.setBounds(30, 30, 186, 35);
		panel.add(txtName);
		txtName.setText("Name");
		txtName.setColumns(10);
		txtName.setActionCommand("search");

		JButton searchButton = new JButton("Search");
		searchButton.setBounds(215, 30, 110, 35);
		panel.add(searchButton);
		searchButton.setActionCommand("search");
		searchButton.setMnemonic(KeyEvent.VK_M);

		JButton addButton = new JButton("+");
		addButton.setBounds(660, 30, 110, 35);
		panel.add(addButton);
		addButton.setActionCommand("add");

		addButton.addActionListener(this);
		btnCancel.addActionListener(this);
		registerButton.addActionListener(this);
		searchButton.addActionListener(this);
		txtName.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		if ("search".equals(e.getActionCommand())) {
			((EmployeeModel) table.getModel()).search(txtName.getText());
		} else if ("add".equals(e.getActionCommand())) {
			System.out.println("add");
			panel.setVisible(false);
			panel_1.setVisible(true);
		} else if ("cancel".equals(e.getActionCommand())) {
			System.out.println("cancel");
			panel.setVisible(true);
			panel_1.setVisible(false);
		} else if ("register".equals(e.getActionCommand())) {
			Boolean valid = true;

			if (ec.isLoginTaken(loginField.getText()) || loginField.getText().equals("")) {
				lblNewLabel_1.setForeground(Color.RED);
				loginField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
				valid = false;
			} else {
				lblNewLabel_1.setForeground(Color.BLACK);
				loginField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(171, 173, 179)));
			}

			if (nameField.getText().equals("")) {
				lblName.setForeground(Color.RED);
				nameField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
				valid = false;
			} else {
				lblName.setForeground(Color.BLACK);
				nameField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(171, 173, 179)));
			}

			if (addressField.getText().equals("")) {
				lblNewLabel.setForeground(Color.RED);
				addressField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
				valid = false;
			} else {
				lblNewLabel.setForeground(Color.BLACK);
				addressField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(171, 173, 179)));
			}

			if (passwordField.getText().equals("")) {
				lblPassword.setForeground(Color.RED);
				passwordField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
				valid = false;
			} else {
				lblPassword.setForeground(Color.BLACK);
				passwordField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(171, 173, 179)));
			}

			if (!passwordField.getText().equals(repeatPasswordField.getText())) {
				lblRepeatPass.setForeground(Color.RED);
				repeatPasswordField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
				valid = false;
			} else {
				lblRepeatPass.setForeground(Color.BLACK);
				repeatPasswordField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(171, 173, 179)));
			}

			if (valid) {
				ec.createEmployee(loginField.getText(), nameField.getText(), addressField.getText(),
						(int) spinnerAL.getValue(), passwordField.getText());
			}
		}
	}

	class EmployeeModel extends AbstractTableModel {
		private String[] columnNames = { "Login", "Name", "Address", "Access level", "password" };

		private Object[][] data = ec.getData();

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.length;
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

		public Object getValueAt(int row, int col) {
			return data[row][col];
		}

		public void search(String name) {
			String[][] dataset = ec.getData();
			ArrayList<Integer> matches = new ArrayList();
			for (int i = 0; i < dataset.length; i++)
				if (dataset[i][1].toLowerCase().contains(name.toLowerCase()))
					matches.add(i);
			data = new Object[matches.size()][4];
			for (int i = 0; i < matches.size(); i++)
				data[i] = dataset[matches.get(i)];
			fireTableDataChanged();
		}

		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}

		public boolean isCellEditable(int row, int col) {
			// Note that the data/cell address is constant,
			// no matter where the cell appears onscreen.
			if (col < 1) {
				return false;
			} else {
				return true;
			}
		}

		public void setValueAt(Object value, int row, int col) {
			EmployeeEditor editor = new EmployeeEditor(String.valueOf(data[row][0]));
			if (col == 1) {
				data[row][col] = value;
				editor.setName(String.valueOf(value));
				fireTableCellUpdated(row, col);
			} else if (col == 2) {
				data[row][col] = value;
				editor.setAddress(String.valueOf(value));
				fireTableCellUpdated(row, col);
			} else if (col == 3) {
				try {
					editor.setAccessLevel(Integer.valueOf(String.valueOf(value)));
					data[row][col] = value;
					fireTableCellUpdated(row, col);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			((EmployeeModel) table.getModel()).search(txtName.getText());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
