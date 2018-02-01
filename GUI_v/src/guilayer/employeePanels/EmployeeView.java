package guilayer.employeePanels;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;

import controllayer.EmployeeController;
import controllayer.EmployeeEditor;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;

public class EmployeeView extends JPanel {
	private JTable table;

	public EmployeeView() {
		setLayout(null);

		String[] columnNames = { "First Name", "Last Name", "Sport", "# of Years", "Vegetarian" };

		Object[][] data = { { "Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false) },
				{ "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
				{ "Sue", "Black", "Knitting", new Integer(2), new Boolean(false) },
				{ "Jane", "White", "Speed reading", new Integer(20), new Boolean(true) },
				{ "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) } };

		table = new JTable(new EmployeeModel());
		table.setPreferredSize(new Dimension(800, 721));
		table.setPreferredScrollableViewportSize(new Dimension(800, 721));
		table.setBackground(new Color(255, 235, 205));
		table.setRowHeight(35);
		JTableHeader header = table.getTableHeader();
		header.setOpaque(true);
		header.setBackground(new Color(255, 235, 205));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setSize(800, 721);
		add(scrollPane);
	}

	class EmployeeModel extends AbstractTableModel {
		EmployeeController ec = new EmployeeController();
		private String[] columnNames = { "Login", "Name", "Address", "Access level" };

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

		/**
		 * JTable uses this method to determine the default renderer/ editor for each
		 * cell. If we didn't implement this method, then the last column would contain
		 * text ("true"/"false"), rather than a check box.
		 */
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
			} else if(col == 2) {
				data[row][col] = value;
				editor.setAddress(String.valueOf(value));
				fireTableCellUpdated(row, col);
			}else if(col == 3) {
				try {
					editor.setAccessLevel(Integer.valueOf(String.valueOf(value)));
					data[row][col] = value;
					fireTableCellUpdated(row, col);
				} catch(Exception e) {
				  e.printStackTrace();
				}
			}
		}
	}
}
