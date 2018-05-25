//https://stackoverflow.com/questions/8973381/why-cannot-cast-integer-to-string-in-java
/*Why this is not possible:

Because String and Integer are not in the same Object hierarchy.

      Object
     /      \
    /        \
String     Integer
The casting which you are trying, works only if they are in the same hierarchy, e.g.

      Object
     /
    /
   A
  /
 /
B
In this case, (A) objB or (Object) objB or (Object) objA will work.

Hence as others have mentioned already, to convert an integer to string use:

String.valueOf(integer), or Integer.toString(integer) for primitive,

or

Integer.toString() for the object.*/

package example.core;

public class Boxing {

	public static void main(String[] args) {
		/*Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
		at example.core.Boxing.main(Boxing.java:35)*/
		Object o = 1;
		String a = ((String) o);
		System.out.println(a);
	}
}
