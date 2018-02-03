package com.fiberg.repool.processor;

import org.apache.commons.lang3.StringUtils;

import javax.annotation.Nonnull;
import javax.annotation.processing.Messager;
import javax.lang.model.element.Element;
import javax.tools.Diagnostic;

import java.util.Optional;

import static java.lang.String.format;
import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.*;

/**
 * Method that
 */
final class Handler {

	/**
	 * Private empty constructor of the handler.
	 */
	private Handler() {  }

	/**
	 * Method to log an error.
	 *
	 * @param messager messager to print the log
	 * @param e        element
	 * @param t        throwable
	 * @param msg      string message
	 * @param args     object arguments
	 */
	public static void error(@Nonnull final Messager messager,
	                         @Nonnull final Element e,
	                         final Throwable t,
	                         @Nonnull final String msg,
	                         @Nonnull final Object... args) {
		messager.printMessage(
				Diagnostic.Kind.ERROR,
				formatThrowable(t, String.format(msg, args)),
				e);
	}

	/**
	 * Method to log an error.
	 *
	 * @param messager messager to print the log
	 * @param e        element
	 * @param msg      string message
	 * @param args     object arguments
	 */
	static void error(@Nonnull final Messager messager,
	                  @Nonnull final Element e,
	                  @Nonnull final String msg,
	                  @Nonnull final Object... args) {
		messager.printMessage(
				Diagnostic.Kind.ERROR,
				String.format(msg, args),
				e);
	}

	/**
	 * Method to log an error.
	 *
	 * @param messager messager to print the log
	 * @param t        throwable
	 * @param msg      string message
	 * @param args     object arguments
	 */
	static void error(@Nonnull final Messager messager,
	                  final Throwable t,
	                  @Nonnull final String msg,
	                  @Nonnull final Object... args) {
		messager.printMessage(
				Diagnostic.Kind.ERROR,
				formatThrowable(t, String.format(msg, args)));
	}

	/**
	 * Method to log an error.
	 *
	 * @param messager messager to print the log
	 * @param msg      string message
	 * @param args     object arguments
	 */
	static void error(@Nonnull final Messager messager,
	                  @Nonnull final String msg,
	                  @Nonnull final Object... args) {
		messager.printMessage(
				Diagnostic.Kind.ERROR,
				String.format(msg, args));
	}

	/**
	 * Method to log an error.
	 *
	 * @param messager messager to print the log
	 * @param t        throwable
	 */
	static void error(@Nonnull final Messager messager,
	                  final Throwable t) {
		messager.printMessage(
				Diagnostic.Kind.ERROR,
				formatThrowable(t));
	}

	/**
	 * Method to log an error.
	 *
	 * @param messager messager to print the log
	 * @param e        element
	 * @param t        throwable
	 */
	static void error(@Nonnull final Messager messager,
	                  @Nonnull final Element e,
	                  final Throwable t) {
		messager.printMessage(
				Diagnostic.Kind.ERROR,
				formatThrowable(t),
				e);
	}

	/**
	 * Method to log a warning.
	 *
	 * @param messager messager to print the log
	 * @param e        element
	 * @param t        throwable
	 * @param msg      string message
	 * @param args     object arguments
	 */
	static void warning(@Nonnull final Messager messager,
	                    @Nonnull final Element e,
	                    final Throwable t,
	                    @Nonnull final String msg,
	                    @Nonnull final Object... args) {
		messager.printMessage(
				Diagnostic.Kind.WARNING,
				formatThrowable(t, String.format(msg, args)),
				e);
	}

	/**
	 * Method to log a warning.
	 *
	 * @param messager messager to print the log
	 * @param e        element
	 * @param msg      string message
	 * @param args     object arguments
	 */
	static void warning(@Nonnull final Messager messager,
	                    @Nonnull final Element e,
	                    @Nonnull final String msg,
	                    @Nonnull final Object... args) {
		messager.printMessage(
				Diagnostic.Kind.WARNING,
				String.format(msg, args),
				e);
	}

	/**
	 * Method to log a warning.
	 *
	 * @param messager messager to print the log
	 * @param t        throwable
	 * @param msg      string message
	 * @param args     object arguments
	 */
	static void warning(@Nonnull final Messager messager,
	                    final Throwable t,
	                    @Nonnull final String msg,
	                    @Nonnull final Object... args) {
		messager.printMessage(
				Diagnostic.Kind.WARNING,
				formatThrowable(t, String.format(msg, args)));
	}

	/**
	 * Method to log a warning.
	 *
	 * @param messager messager to print the log
	 * @param msg      string message
	 * @param args     object arguments
	 */
	static void warning(@Nonnull final Messager messager,
	                    @Nonnull final String msg,
	                    @Nonnull final Object... args) {
		messager.printMessage(
				Diagnostic.Kind.WARNING,
				String.format(msg, args));
	}

	/**
	 * Method to log a warning.
	 *
	 * @param messager messager to print the log
	 * @param t        throwable
	 */
	static void warning(@Nonnull final Messager messager,
	                    final Throwable t) {
		messager.printMessage(
				Diagnostic.Kind.WARNING,
				formatThrowable(t));
	}

	/**
	 * Method to log a warning.
	 *
	 * @param messager messager to print the log
	 * @param e        element
	 * @param t        throwable
	 */
	static void warning(@Nonnull final Messager messager,
	                    @Nonnull final Element e,
	                    final Throwable t) {
		messager.printMessage(
				Diagnostic.Kind.WARNING,
				formatThrowable(t),
				e);
	}

	/**
	 * Method that formats a throwable.
	 *
	 * @param throwable throwable to format
	 * @return the formatted throwable
	 */
	private static String formatThrowable(final Throwable throwable) {
		return formatThrowable(throwable, null);
	}

	/**
	 * Method that formats a throwable.
	 *
	 * @param throwable throwable to format
	 * @param prefix    prefix to use
	 * @return the formatted throwable with prefix
	 */
	private static String formatThrowable(final Throwable throwable,
	                                      final String prefix) {

		// check if throwable is not null
		if (nonNull(throwable)) {

			// create possible generated message
			final String generated = Optional.ofNullable(prefix)
					.filter(StringUtils::isNotBlank)
					.map(p -> p + String.format("%s - Generated By: ", p))
					.orElse(EMPTY);

			// get throwable message
			final String message = throwable.getMessage();

			// get possible cause message
			final String caused = Optional.of(throwable)
					.map(Throwable::getCause)
					.map(Throwable::getMessage)
					.map(m -> format(" - Caused By: %s", m))
					.orElse(EMPTY);

			// return all message parts joined
			return join(generated, message, caused);

		}

		// return null by default
		return null;

	}

}
