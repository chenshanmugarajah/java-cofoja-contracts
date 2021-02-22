import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.google.java.contract.PreconditionError;
import com.sun.org.glassfish.gmbal.Description;

class NaturalListTest {

	@Test
	void pushPreconditionTest() {
		Natural nat = null;
		NaturalList natList = new NaturalList();
		
		assertThrows(PreconditionError.class, () -> {
			natList.push(nat);
		});
	}
	
	@Test
	void pushPostconditionTest() {
		Natural nat = new Natural(1);
		NaturalList nl = new NaturalList();
		
		assertDoesNotThrow(() -> {
			nl.push(nat);
		});
	}
	
	@Test
	void getPreconditionTest() {
		Natural nat = new Natural(1);
		Natural nat2 = new Natural(3);
		Natural nat3 = new Natural(5);
		NaturalList natList = new NaturalList();
		natList.push(nat);
		natList.push(nat2);
		natList.push(nat3);
		
		assertThrows(PreconditionError.class, () -> {
			natList.get(6);
		});
	}
	
	@Test
	void getPostconditionTest() {
		Natural nat = new Natural(1);
		Natural nat2 = new Natural(3);
		Natural nat3 = new Natural(5);
		NaturalList natList = new NaturalList();
		natList.push(nat);
		natList.push(nat2);
		natList.push(nat3);
		
		assertDoesNotThrow(() -> {
			natList.get(2);
		});
	}
	
	@Test
	void setPreconditionTest() {
		Natural nat = new Natural(1);
		Natural nat2 = new Natural(3);
		Natural nat3 = new Natural(5);
		NaturalList natList = new NaturalList();
		natList.push(nat);
		natList.push(nat2);
		natList.push(nat3);
		Natural natTest = new Natural(4);
		
		assertThrows(PreconditionError.class, () -> {
			natList.set(5, natTest);
		});
	}
	
	@Test
	void setPostconditionTest() {
		Natural nat = new Natural(1);
		Natural nat2 = new Natural(3);
		Natural nat3 = new Natural(5);
		NaturalList natList = new NaturalList();
		
		assertDoesNotThrow(() -> {
			natList.push(nat);
			natList.push(nat2);
			natList.push(nat3);
			Natural test = new Natural(4);
			natList.set(2, test);
		});
	}
	
	@Test
	void sortPreconditionTest() {
		NaturalList natList = new NaturalList();
		
		assertThrows(PreconditionError.class, () -> {
			natList.sort();
		});
	}
	
	@Test
	void sortPostconditionTest() {
		Natural nat = new Natural(1);
		Natural nat2 = new Natural(9);
		Natural nat3 = new Natural(5);
		NaturalList natList = new NaturalList();
		natList.push(nat);
		natList.push(nat2);
		natList.push(nat3);
		
		assertDoesNotThrow(() -> {
			natList.sort();
		});
	}
	
	@Test
	void searchPreconditionTest() {
		Natural nat = new Natural(1);
		Natural nat2 = new Natural(9);
		Natural nat3 = new Natural(5);
		NaturalList natList = new NaturalList();
		natList.push(nat);
		natList.push(nat2);
		natList.push(nat3);
		Natural natTest = new Natural(5);
		
		assertThrows(PreconditionError.class, () -> {
			natList.search(natTest);
		});
	}
	
	@Test
	void searchPostconditionTest() {
		Natural nat = new Natural(1);
		Natural nat2 = new Natural(11);
		Natural nat3 = new Natural(9);
		NaturalList natList = new NaturalList();
		natList.push(nat);
		natList.push(nat2);
		natList.push(nat3);
		Natural natTest = new Natural(5);
		
		assertDoesNotThrow(() -> {
			natList.sort();
			natList.search(natTest);
		});
	}
	

}
