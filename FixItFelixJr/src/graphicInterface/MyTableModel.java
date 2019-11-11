package graphicInterface;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel {

	@Override
	public boolean isCellEditable(int row, int column) {
		// TODO Auto-generated method stub
		return false;
	}

	public MyTableModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyTableModel(int rowCount, int columnCount) {
		super(rowCount, columnCount);
		// TODO Auto-generated constructor stub
	}

	public MyTableModel(Object[] columnNames, int rowCount) {
		super(columnNames, rowCount);
		// TODO Auto-generated constructor stub
	}

	public MyTableModel(Object[][] data, Object[] columnNames) {
		super(data, columnNames);
		// TODO Auto-generated constructor stub
	}

	public MyTableModel(Vector columnNames, int rowCount) {
		super(columnNames, rowCount);
		// TODO Auto-generated constructor stub
	}

	public MyTableModel(Vector data, Vector columnNames) {
		super(data, columnNames);
		// TODO Auto-generated constructor stub
	}
	
	
	

}
