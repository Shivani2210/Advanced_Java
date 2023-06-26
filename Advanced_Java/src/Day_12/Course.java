package Day_12;

public class Course {
	private int courseID;
	private String courseName;
	private int amount;
	private int duration;
	
	public Course(int courseID, String courseName, int amount, int duration) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.amount = amount;
		this.duration = duration;
	}
	
	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Course [courseID=" + courseID + ", courseName=" + courseName + ", amount=" + amount + ", duration="
				+ duration + "]";
	} 
		
		
	
	}
	
	


