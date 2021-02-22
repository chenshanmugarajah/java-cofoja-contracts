import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import com.google.java.contract.PreconditionError;

class NaturalTest {
	
	@Test
	void consPreConditionTest() {
		assertThrows(PreconditionError.class, () -> {
			Natural nat = new Natural(-1); // should throw since negative
		});
	}
	
	@Test
	void consPostConditionTest() {
		assertDoesNotThrow(() -> {
			Natural nat = new Natural(3);
		});
	}
	
	@Test
	void incrementPreConditionTest() {
		
		assertThrows(PreconditionError.class, () -> {
			Natural nat = new Natural(Integer.MAX_VALUE);
			nat.increment(); //cant increment since nat already max
		});
	}
	
	@Test
	void incrementPostConditionTest() {
		
		assertDoesNotThrow(() -> {
			Natural nat = new Natural(3);
			nat.increment();
		});
		
	}
	
	@Test
	void decrementPreConditionTest() {
		
		assertThrows(PreconditionError.class, () -> {
			Natural nat = new Natural(0);
			nat.decrement();
		});
	}
	
	@Test
	void decrementPostConditionTest() {
		
		assertDoesNotThrow(() -> {
			Natural nat = new Natural(3);
			nat.decrement();
		});
	}
	
	//add(Natural n) precondition test
	//cannot test input since int is always a whole number
	
	@Test
	void addPostConditionTest() {
		int var1 = 2;
		int var2 = 3;
		int ans = var1 + var2;
		
		Natural nat = new Natural(var1);
		Natural nat2 = new Natural(var2);
		
		assertDoesNotThrow(() -> {
			nat.add(nat2);
		});	
		
		assertEquals(Integer.toString(ans), nat.toString());
	}
	
	//subtract(Natural n) precondition test
	//cannot test input since int is always a whole number
	
	@Test
	void subtractPostConditionTest() {
		int var1 = 5;
		int var2 = 3;
		int ans = var1 - var2;
		
		Natural nat = new Natural(var1);
		Natural nat2 = new Natural(var2);
		
		assertDoesNotThrow(() -> {
			nat.subtract(nat2);
		});
		
		assertEquals(Integer.toString(ans), nat.toString());
	}
	
	//multiply(Natural n) precondition test
	//cannot test input since int is always a whole number hence 5.1 becomes 5 even if int is cast
	
	@Test
	void multiplicationPostConditionTest() {
		int var1 = 5;
		int var2 = 3;
		int ans = var1 * var2;
		
		Natural nat = new Natural(var1);
		Natural nat2 = new Natural(var2);
		
		assertDoesNotThrow(() -> {
			nat.multiply(nat2);
		});
		
		assertEquals(Integer.toString(ans), nat.toString());	
	}
	
	//division(Natural n) precondition test
	//cannot test input since int is always a whole number
	
	@Test
	void divisionPostConditionTest() {
		int var1 = 5;
		int var2 = 3;
		int ans = var1 / var2;
		
		Natural nat = new Natural(var1);
		Natural nat2 = new Natural(var2);
		
		assertDoesNotThrow(() -> {
			nat.divide(nat2);
		});
		
		assertEquals(Integer.toString(ans), nat.toString());	
	}
}
