package Day_12;

import java.sql.Connection;
import java.util.ArrayList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

public class CourseDatabaseDao 
implements DaoInterface <Course, Integer> {

	@Override
	public void createNew(Course newCourse){
		try (Connection conn = JdbcUtils.BuildConnection();){
			
			String sqlQuery = "insert into course(CourseID, CourseName, CoursePrice, Duration) values (?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
			int id = newCourse.getCourseID();
			String name = newCourse.getCourseName();
			int price = newCourse.getAmount();
			int duration = newCourse.getDuration();
			
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, price);
			pstmt.setInt(4, duration);
			int count = pstmt.executeUpdate();
			System.out.println(count + " record added");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}

	@Override
	public Collection<Course> getAll() {
		Collection<Course> allCourse = new ArrayList<>(); 
		try(Connection conn = JdbcUtils.BuildConnection();){
			Statement stmt = conn.createStatement();
			String SQLquery = "select CourseID, CourseName, CoursePrice, Duration from course";
			ResultSet rs = stmt.executeQuery(SQLquery);
			while(rs.next()) {
				int courseID = rs.getInt(1);
				String courseName = rs.getString(2);
				int coursePrice = rs.getInt(3);
				int courseDuration = rs.getInt(4);
				Course currentCourse = new Course (courseID, courseName, coursePrice, courseDuration);
				allCourse.add(currentCourse);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return allCourse;
	}

	@Override
	public Course getOneByID(Integer id) {
		Course foundCourse = null;
		try(Connection conn = JdbcUtils.BuildConnection();){
			String sqlQuery = "select * from Course where courseID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int courseId = rs.getInt(1);
				String courseName = rs.getString(2);
				int coursePrice = rs.getInt(3);
				int courseDuration = rs.getInt(4);
				foundCourse = new Course(courseId, courseName, coursePrice, courseDuration);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		return foundCourse;
	}

	@Override
	public void update(Course modifiedCourse){
		try(Connection conn = JdbcUtils.BuildConnection()){
			String sqlQuery = "update course set CourseName =?, CoursePrice = ?, CourseDuration = ?, CourseID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
			String name = modifiedCourse.getCourseName();
			int price = modifiedCourse.getAmount();
			int duration = modifiedCourse.getDuration();
			int id = modifiedCourse.getCourseID();
			
			pstmt.setString(1, name);
			pstmt.setInt(2, price);
			pstmt.setInt(3,duration);
			pstmt.setInt(4, id);
			
			int updateCount = pstmt.executeUpdate();
			System.out.println(updateCount + " record updated");
		
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteById(Integer id) {
		try(Connection conn = JdbcUtils.BuildConnection()){
			
			String sqlQuery = "delete from course where courseid = ?";
			PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
			pstmt.setInt(1, id);
			int deleteCount = pstmt.executeUpdate();
			System.out.println(deleteCount + " record deleted");

			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
