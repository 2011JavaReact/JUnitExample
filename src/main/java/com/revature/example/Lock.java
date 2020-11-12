package com.revature.example;

import com.revature.exceptions.InvalidKeyException;
import com.revature.exceptions.LockAlreadyLockedException;
import com.revature.exceptions.LockAlreadyUnlockedException;

public class Lock {

	// by default, if you don't initialize the instance variable and only declare it, it will have 
	// some sort of default value
	// for numeric types, this is usually 0
	// floating point 0.0
	// boolean -> false
	
	// Object types -> null
	private int secretKey;
	private boolean isLocked;

	public Lock(int secretKey) {
		this.isLocked = true;
		this.secretKey = secretKey;
	}
	
	public static void main(String[] args) {
		// while an object of the Lock type is being instantiated, it actually instantiates the fields first
		// and then it will go into the constructor code
		Lock lock = new Lock(10);
		System.out.println("Hello World!");
	}
	
	// lock() should only return true, if our lock is already unlocked
	// otherwise it will return false;
	public void lock() throws LockAlreadyLockedException {
		if (isLocked) {
			throw new LockAlreadyLockedException();
		}
		
		this.isLocked = false;
	}
	
	// Units are sort of arbitary
	// Units could be entire classes, methods, blocks of code, 1 line of code
	// 
	public void unlock(int key) throws LockAlreadyUnlockedException, InvalidKeyException {		
		if (!isLocked) {
			throw new LockAlreadyUnlockedException();
		}
		
		if (this.secretKey == key) {
			this.isLocked = false;
		} else {
			throw new InvalidKeyException();
		}
		
	}
	
	// getter method
	public boolean isLocked() {
		return this.isLocked;
	}
	
}
