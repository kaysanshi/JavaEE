package com.test;
/**
 * 
 * @author leoi555
 *
 */
public class Waveform {
	private static Long counter;
	private final long id=counter++;
	public String toString() {
		
		return "WaveForm"+id;
		
	}
}
