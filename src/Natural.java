import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;

//Add an invariant here.
@Invariant({
	"data >= 0", //if positive
	"data <= Integer.MAX_VALUE", //if less than max integer value
	"(data % 1) == 0" // if whole number
})
public class Natural implements Comparable<Natural> {
	private int data;

	// No contracts required for the following methods.

	@Override
	public boolean equals(Object o) { 
		if(!(o instanceof Natural)) return false; 
		Natural n = (Natural) o;
		return data==n.data; 
	}
	
	public int compareTo(Natural n) { 
		return Integer.compare(data, n.data); 
	}
	
	public Natural(Natural n) {
		this(n.data);
	}

	@Override
	public String toString() {
		return Integer.toString(data); 
	}

	// Add contracts to all following methods.
	
	@Requires({
		"d >= 0",
		"d <= Integer.MAX_VALUE",
		"(d % 1) == 0"
	})
	@Ensures({
		"data >= 0",
		"data <= Integer.MAX_VALUE",
		"(data % 1) == 0",
		"d == data"
	})
	public Natural(int d) {
		data = d;
	}
	
	@Requires("data < Integer.MAX_VALUE")
	@Ensures("old(data) + 1 == data")
	public void increment() {
		data++; 
	}
	
	@Requires("data > 0")
	@Ensures("old(data) - 1 == data")
	public void decrement() {
		data--;
	}
	
	@Requires("(n.data % 1) == 0")
	@Ensures("addition(n, old(data))")
	public void add(Natural n) {
		data += n.data;
	}
	
	@Requires("(n.data % 1) == 0")
	@Ensures("subtraction(n, old(data))")
	public void subtract(Natural n) {
		data -= n.data;
	}
	
	@Requires("(n.data % 1) == 0")
	@Ensures("multiplication(n, old(data))")
	public void multiply(Natural n) {
		data *= n.data;
	}
	
	@Requires("(n.data % 1) == 0")
	@Ensures("division(n, old(data))")
	public void divide(Natural n) {
		data /= n.data;
	}
	
	//custom functions for contracts
	private boolean addition(Natural n, int i) {
		int ans = 0;
		ans += i;
		ans += n.data;
		return data==ans;
	}
	
	private boolean subtraction(Natural n, int i) {
		int ans = 0;
		ans += i;
		ans -= n.data;
		return data==ans;
	}
	
	private boolean multiplication(Natural n, int i) {
		int ans = 1;
		ans *= i;
		ans *= n.data;
		return data==ans;
	}
	
	private boolean division(Natural n, int i) {
		int ans  = i / n.data;
		return data==ans;
	}
}
