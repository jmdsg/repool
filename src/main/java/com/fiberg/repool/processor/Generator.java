package com.fiberg.repool.processor;

import com.fiberg.repool.util.NameUtils;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;

import javax.annotation.Nonnull;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.Writer;

import static org.apache.commons.lang3.ObjectUtils.allNotNull;

/**
 * Class that generates all classes from repool.
 */
public class Generator {

	/** Handles the report of errors, warnings and anothers */
	private final Messager messager;

	/** Receives the generated class files */
	private final Filer filer;

	/**
	 * @param messager handles the report of errors, warnings and anothers
	 * @param filer receives the generated class files
	 */
	public Generator(@Nonnull final Messager messager,
	                 @Nonnull final Filer filer) {
		this.messager = messager;
		this.filer = filer;
	}

	/**
	 * Method that generates the type spec
	 *
	 * @param typeSpec type spec
	 * @param packageName package name of the class
	 * @param className class name of the class
	 */
	public void createJavaClass(@Nonnull final TypeSpec typeSpec,
	                            @Nonnull final String packageName,
	                            @Nonnull final String className) {

		// check if non of the parameters is null
		if (allNotNull(typeSpec, packageName, className)) {

			try {

				// create source file and open the writer
				final JavaFileObject jfo = filer.createSourceFile(NameUtils.addPrefixName(className, packageName));
				final Writer writer = jfo.openWriter();

				// build the class and write to the file
				final JavaFile javaFile = JavaFile.builder(packageName, typeSpec).build();
				javaFile.writeTo(writer);

				// close the writer
				writer.close();

			} catch (IOException e) {

				// print the error when the class could not be generated
				Handler.error(messager, e, "Class could not be written");

			}

		}

	}

}
