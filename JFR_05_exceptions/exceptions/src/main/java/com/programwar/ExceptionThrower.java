package com.programwar;

public final class ExceptionThrower {
	public long scaryCounter;
	public static void main(String[] args) throws Exception {
		new ExceptionThrower().loop();
	}

	private void loop() throws Exception {
		while(true) {
			try {
				Thread.sleep(2000);
				doStuff();
			} catch (Exception e) {
				// Evilly swallow the exception.
			}
		}
	}
	
	private void doStuff() throws Exception {
		// Having a few frames on the stack makes the traces, um, more interesting.
		if (isScary()) {
			doScaryThing();
		}
		else {
			throwMe();
		}
	}
	
	private void doScaryThing() throws ScaryException {
		throw new ScaryException();		
	}

	private boolean isScary() {
		return ++scaryCounter % 10 == 0;
	}

	private void throwMe() throws ExceptionThrowerException {
		throw new ExceptionThrowerException("Throw me!");
	}

}
