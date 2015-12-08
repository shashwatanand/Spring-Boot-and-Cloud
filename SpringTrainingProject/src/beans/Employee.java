package beans;

import java.net.URL;
import java.util.List;
import java.util.Map;

public class Employee {
	int empNo;
	String name;
	double salary;

	URL profileURL;
	Department currentDepartment;

	List<String> skills;
	Map<String, String> projectsWorked;

	public Employee(int empNo, String name, double salary) {
		super();
		this.empNo = empNo;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", name=" + name + ", salary="
				+ salary + ", profileURL=" + profileURL
				+ ", currentDepartment=" + currentDepartment + ", skills="
				+ skills + ", projectsWorked=" + projectsWorked + "]";
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public URL getProfileURL() {
		return profileURL;
	}

	public void setProfileURL(URL profileURL) {
		this.profileURL = profileURL;
	}

	public Department getCurrentDepartment() {
		return currentDepartment;
	}

	public void setCurrentDepartment(Department currentDepartment) {
		this.currentDepartment = currentDepartment;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public Map<String, String> getProjectsWorked() {
		return projectsWorked;
	}

	public void setProjectsWorked(Map<String, String> projectsWorked) {
		this.projectsWorked = projectsWorked;
	}

}
