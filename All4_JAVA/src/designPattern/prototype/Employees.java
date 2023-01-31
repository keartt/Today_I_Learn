package designPattern.prototype;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable {
	private List<String> empList;

	public Employees() {
		empList = new ArrayList<String>();
	}

	public Employees(List<String> list) {
		this.empList = list;
	}

	public void loadData() {
		empList.add("Ann");
		empList.add("David");
		empList.add("John");
		empList.add("Methew");
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		List<String> temp = new ArrayList<>();
		for (String str : this.empList) {
			temp.add(str);
		}
		return new Employees(temp);
	}

	public List<String> getEmpList() {
		return empList;
	}
}