/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab06;
import lab06.Queue;
/**
 *
 * @author ACER PREDATOR
 */
public class TestQueue {
	public static void start() {
		Queue queue = new Queue();
		
		for (int i = 1; i <= 20; i++) {
			System.out.printf("Enqueue : %d\n", i);
			queue.enqueue(i);
		}
		
		System.out.println("Empty : " + queue.empty());
		
		for (int i = 0; i < 20; i++) {
			System.out.printf("Dequeue : %d\n", queue.dequeue());
		}
		
		System.out.println("Empty : " + queue.empty());
	}
}
