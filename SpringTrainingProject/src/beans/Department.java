package beans;

public class Department {
	int deptNo;
	String name;
	String location;

	@Override
	public String toString() {
		return "Department [deptNo=" + deptNo + ", name=" + name + ", loation="
				+ location + "]";
	}
	
	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
