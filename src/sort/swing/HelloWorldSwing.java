package sort.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import sort.comparators.SexComparator;
import sort.objects.Person;
import sort.objects.PersonTableModel;
import sort.reader.PeopleReader;

public class HelloWorldSwing {
	public static void main(String[] args) throws IOException {
		createAndShowGUI();
	}
	
	private static void createAndShowGUI() throws IOException {
		PeopleReader personReader = new PeopleReader("databaseLOL.txt");
		final Person[] people = personReader.readPeople();
		
		final JFrame frame = new JFrame("Hello shit frame.");
		frame.setSize(450, 300);
		frame.setLocationRelativeTo(null);
//		frame.pack(); //се интересува само от компонентите във фрейма
		JLabel label = new JLabel("Мара, свят!", JLabel.CENTER);
		frame.getContentPane().add(label);
		JButton button = new JButton("Click me for no reason");

		Container cp = frame.getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(label, BorderLayout.NORTH);
		cp.add(button, BorderLayout.SOUTH);
		
		TableModel tableModel = new PersonTableModel(people);
		final JTable table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		cp.add(scrollPane, BorderLayout.CENTER);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Arrays.sort(people, new SexComparator());
				table.repaint();
			}
		});
		frame.setVisible(true);
	}
}
