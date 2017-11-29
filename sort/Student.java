package sort;

/**
 * Lab 5 number 2.
 * @author puliciccj5
 * @version (10.11.2016)
 *
 */
public class Student implements Comparable{
	
	private String name;
	private String ssn;
	private float gpa;
	
	public Student(String name, String ssn) {
		this.name = name;
		this.ssn = ssn;
		this.gpa = (float) 0.0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

	@Override
	public int compareTo(Object o) {
		int compare;
		
		if (o instanceof Student) {
			compare = this.name.compareToIgnoreCase(((Student) o).getName());
		
			if (compare == 0) 	//the objects have the same name
			{ 
				return this.ssn.compareTo(((Student) o).getSsn());
			}
			return compare;
		}
		return 0;
	}

	public String toString() {
		return name + "(" + ssn + ")";
	}

}
