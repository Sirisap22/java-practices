/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab06;
import lab06.Course;
/**
 *
 * @author ACER PREDATOR
 */
public class TestCourse {
	public static void start() {
		try {
			Course science = new Course("Science");
			science.addStudent("Mark Zuckerberg");
			science.addStudent("Elon Musk");
			science.addStudent("Bill Gates");
		
			System.out.println("Course : " + science.getCourseName());
			
			System.out.println("Before");
			displayStudents(science.getStudents(), science.getNumberOfStudents());
	
			science.dropStudent("Elon Musk");
			science.addStudent("Jack Ma");
			System.out.println("After");
			displayStudents(science.getStudents(), science.getNumberOfStudents());
			
		} catch (IllegalArgumentException | IllegalStateException error) {
			System.out.println(error);
		}
	
	}
	
	private static void displayStudents(String[] students, int numberOfStudents) {
		for (int i = 0; i < numberOfStudents; i++) {
			System.out.println("Student " + i + " : " + students[i]);
		}
	}
}
