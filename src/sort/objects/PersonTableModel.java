package sort.objects;

import javax.swing.table.AbstractTableModel;


public class PersonTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6710807049098422514L;
	private Person[] people;
	
	public PersonTableModel(Person[] people) {
		super();
		this.people = people;
	}
	
	@Override
	public int getColumnCount() {
		return getClass().getDeclaredFields().length;
	}
	
	@Override
	public int getRowCount() {
		return people.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
			case 0: return people[rowIndex].getName();
			case 1: return people[rowIndex].isFemale()?"жена":"мъж";
			case 2: return people[rowIndex].getAge();
			case 3: return people[rowIndex].getHeight();
			case 4: return people[rowIndex].getWeight();
			case 5: return people[rowIndex].getBodyMassIndex();
		}
		return null;
	}

	public String getColumName(int column) {
		switch(column) {
			case 0: return "Име";
			case 1: return "Пол";
			case 2: return "Възраст";
			case 3: return "Височина (см)";
			case 4: return "Тегло (кг)";
			case 5: return "BMI";
			default: return super.getColumnName(column);
		}
	}
}
