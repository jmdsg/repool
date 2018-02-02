package test;

public class A implements ARPL {

	/**
	 * Number of A's.
	 * <!--{{
	 *     getter : {{
	 *         Getter of {{field}}
	 *         @return the number of A's
	 *         @javax.xml.bind.annotation.XmlAttribute(name = "Count")
	 *     }},
	 *     setter : {{
	 *         Setter of {{field}}
	 *         @param {{field}} number of A's
	 *         @com.sun.istack.internal.Nullable
	 *         @com.sun.istack.internal.Nullable{{1}}
	 *     }}
	 * }}-->
	 */
	int count;

	/**
	 * Number of A's.
	 * <!--{{getter : @javax.xml.bind.annotation.XmlAttribute(name = "Count")}}-->
	 */
	int count2;

	static ABuilder builder(int a ) {
		return ARPL.builder();
	}

}
