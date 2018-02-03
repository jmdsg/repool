package com.fiberg.repool.processor;

import javax.annotation.Nonnull;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import java.util.Objects;

/**
 * Annotation processor utils.
 */
public final class Utils {

	/**
	 * Private empty constructor.
	 */
	private Utils() {  }

	/**
	 * Method that extracts the package element of a type element.
	 *
	 * @param element type element
	 * @return package element of a type element
	 * @throws IllegalStateException when enclosing element type is unknown
	 */
	public static PackageElement extractPackage(@Nonnull final TypeElement element) throws IllegalStateException {
		Objects.requireNonNull(element, "element is null");

		// check the instance type of the enclosing element
		if (element.getEnclosingElement() instanceof PackageElement) {

			// return the enclosing package element
			return (PackageElement) element.getEnclosingElement();

		} else if (element.getEnclosingElement() instanceof TypeElement){

			// return the recursive call the function
			return extractPackage((TypeElement) element.getEnclosingElement());

		} else {

			// throw exception when enclosing element type is unknown
			throw new IllegalStateException(String.format("Unknow type of the element %s", element));

		}

	}

}
