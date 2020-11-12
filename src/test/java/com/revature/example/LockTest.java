package com.revature.example;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.exceptions.InvalidKeyException;
import com.revature.exceptions.LockAlreadyLockedException;
import com.revature.exceptions.LockAlreadyUnlockedException;

public class LockTest {

	private Lock lock;
	
	// This runs before any tests run. You might specify or start up different resources in this section
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	// This runs after all tests have run. You might close your resources here that were being used
	// For example, FileReader
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	// This will run before every test
	@Before
	public void setUp() throws Exception {
		lock = new Lock(10);
	}

	// This will run after every test
	@After
	public void tearDown() throws Exception {
	}

	// There are two different types of tests (as a generalization)
	// We have positive tests // Where we are basically testing for intended usage of our logic
	// and we have negative tests // where we are testing for unintended use
	@Test(expected=LockAlreadyLockedException.class)
	public void testLock_alreadyLocked() throws LockAlreadyLockedException {
		lock.lock();
	}
	
	@Test
	public void testLock_unlocked() throws LockAlreadyUnlockedException, InvalidKeyException, LockAlreadyLockedException {
		lock.unlock(10);
		lock.lock();
	}
	
	@Test
	public void testUnlock_correctKey() throws LockAlreadyUnlockedException, InvalidKeyException {
		lock.unlock(10);
	}
	
	@Test(expected=InvalidKeyException.class)
	public void testUnlock_incorrectKey() throws LockAlreadyUnlockedException, InvalidKeyException {
		lock.unlock(11);
		
		// expected exceptions
		// assert methods
		
		// Mocking is where you create mock objects (or fake objects, that the class you are testing might use)
		// you would basically mock a dependency to your class using something like Mockito
		// Mockito is another tool that you might use that you can actually install in Maven
		// This will allow you to simulate method calls and returns from those dependencies
	}
}
