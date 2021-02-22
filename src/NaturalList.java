import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.java.contract.ContractImport;
import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;


@ContractImport("java.util.ArrayList")

//Add an invariant here.
@Invariant({
	"numbers != null", // array list cannot be null
	"containsNoNull(numbers)" //array cannot contain any null elements
})
public class NaturalList {
	private ArrayList<Natural> numbers;
	
	// No contracts required for the following methods.
	public NaturalList(NaturalList o) { 
		numbers = new ArrayList<Natural>();
		for(Natural n : o.numbers) 
			numbers.add(new Natural(n));
	}
	
	public NaturalList() {
		numbers = new ArrayList<Natural>();
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof NaturalList)) return false;
		NaturalList other = (NaturalList) o;
		return numbers.equals(other.numbers);
	}

	@Override
	public String toString() {
		return numbers.toString(); 
	}

	// Add contracts to all following methods.
	
	@Requires("n != null") // input not null
	@Ensures({
		"numbers.subList(0, numbers.size()-1).equals(old( new ArrayList<>(numbers)))", // checks elements of old list and new list
		"numbers.get(numbers.size()-1).equals(old(new Natural(n)))", // checks if final element same as input
		"old(new ArrayList<>(numbers)).size() + 1 == numbers.size()" // checks new size of array list
	})
	public void push(Natural n) {
		System.out.println(numbers.size());
		numbers.add(n);
		System.out.println(numbers.size());
	}
	
	@Requires("i < numbers.size()") // param has to be within numbers length
	@Ensures({
		"numbers.size() == old(numbers).size()", // must not change numbers list
		"numbers.equals(old(new ArrayList<>(numbers)))" // checks elements as the same still
	})
	public Natural get(int i) {
		return numbers.get(i);
	}
	
	@Requires("i <= numbers.size()") // params has to be in numbers length
	@Ensures({
		"numbers.get(i).equals(n)", // checks if inputed
		"old(new ArrayList<>(numbers)).size() == numbers.size()" //checks if size increased by 1
	})
	public void set(int i, Natural n) {
		numbers.set(i, n);
	}
	
	@Requires("numbers.size() > 0") // numbers size must be greater than 0
	@Ensures({
		"numbers.size() == old(numbers).size()", // checks if elements the same
		"isOrdered(numbers)" // private function to check if numbers sorted
	})
	public void sort() {
		Collections.sort(numbers);
	}
	
	@Requires("isOrdered(numbers)") // checks if numbers sorted or not
	@Ensures({
		"numbers.size() == old(numbers).size()", // ensures list hasnt changed
		"numbers.equals(old(numbers))"
	})
	public int search(Natural n) {
		return Collections.binarySearch(numbers, n);
	}
	
	// custom functions for contracts
	private boolean containsNoNull(ArrayList<Natural> numbers) {
		for(Natural n : numbers) {
			if (n == null) return false;
		}
		return true;
	}
	
	private boolean isOrdered(ArrayList<Natural> numbers) {
		for(int i=0; i<numbers.size(); i++) {
			if (i == numbers.size() - 1) return true; 
			int res = numbers.get(i).compareTo(numbers.get(i + 1));
			if (res > 0) {
				return false;
			}
		}
		return true;
	}
	
}
