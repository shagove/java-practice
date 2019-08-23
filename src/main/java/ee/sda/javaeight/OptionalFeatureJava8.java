package ee.sda.javaeight;

import java.util.Optional;

public class OptionalFeatureJava8 {

	public static void main(String[] args) {
		OptionalFeatureJava8 optionTester = new OptionalFeatureJava8();
	    Integer value1 = null;
	    Integer value2 = new Integer(10);
			
	    //Optional.ofNullable - allows passed parameter to be null.
	    Optional<Integer> a = Optional.ofNullable(value1);
	    System.out.println(a);
			
	    //Optional.of - throws NullPointerException if passed parameter is null
	    Optional<Integer> b = Optional.of(value2);
	    System.out.println(optionTester.sum(a,b));
		


	}
	   public Integer sum(Optional<Integer> a, Optional<Integer> b){
			
		      //Optional.isPresent - checks the value is present or not
				
		      System.out.println("First parameter is present: " + a.isPresent());
		      System.out.println("Second parameter is present: " + b.isPresent());
				
		      //Optional.orElse - returns the value if present otherwise returns
		      //the default value passed.
		      Integer value1 = a.orElse(new Integer(0));
				
		      //Optional.get - gets the value, value should be present
		      Integer value2 = b.get();
		      return value1 + value2;
		   }
	


}
