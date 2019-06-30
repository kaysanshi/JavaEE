package com.test;
/**
 * 
 * @author leoi555
 *
 */
public class Filter {
	public String name() {
		return this.getClass().getSimpleName();
	}
	
	public Waveform process(Waveform input) {
		
		return input;
		
	}
	
}
