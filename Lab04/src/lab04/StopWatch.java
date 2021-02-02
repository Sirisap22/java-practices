/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab04;

import java.util.Date;

/**
 *
 * @author ACER PREDATOR
 */
public class StopWatch {
	private Date startTime;
	private Date endTime;

	StopWatch() {
		this.startTime = new Date();
	}

	public void start() {
		this.startTime = new Date();
	}

	public void stop() {
		this.endTime = new Date();
	}

	public long getElapsedTime() {
		return this.endTime.getTime() - this.startTime.getTime();
	}

}
