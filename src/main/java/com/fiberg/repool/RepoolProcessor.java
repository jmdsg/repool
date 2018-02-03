package com.fiberg.repool;

import com.fiberg.repool.annotation.Repool;
import com.fiberg.repool.processor.Generator;
import com.fiberg.repool.processor.Utils;
import com.google.auto.service.AutoService;
import com.squareup.javapoet.TypeSpec;

import javax.annotation.Nonnull;
import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;

/**
 * Repool processor to generate getters, setters, withers, builders, extensions and delegators.
 */
@AutoService(Processor.class)
public class RepoolProcessor extends AbstractProcessor {

	/** Messager to print annotation processor errors */
	private Messager messager;

	/** Filer to create java classes */
	private Filer filer;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void init(@Nonnull final ProcessingEnvironment processingEnv) {
		super.init(processingEnv);
		this.messager = processingEnv.getMessager();
		this.filer = processingEnv.getFiler();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean process(@Nonnull final java.util.Set<? extends TypeElement> annotations,
	                       @Nonnull final RoundEnvironment roundEnv) {



		Generator generator = new Generator(messager, filer);

		java.util.Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(Repool.class);

		elements.stream()
				.filter(TypeElement.class::isInstance)
				.map(TypeElement.class::cast)
				.forEach(type -> {

					String simpleName = type.getSimpleName().toString();
					PackageElement packageElement = Utils.extractPackage(type);
					String packageName = packageElement.getQualifiedName().toString();
					generator.createJavaClass(TypeSpec.interfaceBuilder(String.format("%sRPL", simpleName))
									.build(), packageName, simpleName);

				});

		return true;



	}

	/**
	 * {@inheritDoc}
	 */
	@Nonnull
	@Override
	public java.util.Set<String> getSupportedAnnotationTypes() {
		final java.util.Set<String> annotataions = new java.util.LinkedHashSet<>();
		annotataions.add(Repool.class.getCanonicalName());
		return annotataions;
	}

	/**
	 * {@inheritDoc}
	 */
	@Nonnull
	@Override
	public SourceVersion getSupportedSourceVersion() {
		return SourceVersion.latestSupported();
	}

}
