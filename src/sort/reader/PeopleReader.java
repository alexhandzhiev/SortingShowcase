package sort.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import sort.objects.Person;

/**
 * @author alex
 *
 */
public class PeopleReader {
	
	private String databaseName;
	
	public PeopleReader(String databaseName) {
		this.databaseName = databaseName;
	}

	public Person[] readPeople() {
		
		List<Person> people = new ArrayList<Person>();
		BufferedReader br = null;
		
		try {
			FileReader fileReader = new FileReader("resources\\" + databaseName);
			br = new BufferedReader(fileReader);
			String currentLine;
			
			while ((currentLine = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(currentLine, ",");
				Person person = new Person(
						st.nextToken().trim(), 
						st.nextToken().trim().contentEquals("male")?false:true, 
						Integer.parseInt(st.nextToken().trim()), 
						Integer.parseInt(st.nextToken().trim()),
						Integer.parseInt(st.nextToken().trim()), 
						st.nextToken().trim()
						);
				people.add(person);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//No such file. Too lazy to do anything about it.
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//Error reading the file.
			e.printStackTrace();
		} finally {
			try {
				if(br != null) {
					br.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//Cannot close reader - something is seriously fucked up.
				e.printStackTrace();
			}
		}
		return (Person[]) people.toArray(new Person[people.size()]);
	}
}
