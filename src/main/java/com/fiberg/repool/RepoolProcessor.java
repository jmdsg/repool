package com.fiberg.repool;

import com.fiberg.repool.annotation.Repool;
import com.google.auto.service.AutoService;

import javax.annotation.Nonnull;
import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;

/**
 * Repool processor to generate getters, setters, withers, builders, extensions and delegators.
 */
@AutoService(Processor.class)
public class RepoolProcessor extends AbstractProcessor {

	/** Filer to create java classes */
	private Filer filer;

	/** Messager to print annotation processor errors */
	private Messager messager;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void init(@Nonnull final ProcessingEnvironment processingEnv) {
		super.init(processingEnv);
		this.filer = processingEnv.getFiler();
		this.messager = processingEnv.getMessager();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean process(@Nonnull final java.util.Set<? extends TypeElement> annotations,
	                       @Nonnull final RoundEnvironment roundEnv) {


		return false;


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
