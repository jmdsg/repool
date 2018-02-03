package com.fiberg.repool.util;

import javax.annotation.Nonnull;

import static org.apache.commons.lang3.ObjectUtils.firstNonNull;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Util class with utility methods to join namesm suffixes and prefixes.
 */
public final class Utils {

	/**
	 * Private empty constructor.
	 */
	private Utils() {  }

	/** Java name separator */
	public static final String NAME_SEPARATOR = ".";

	/**
	 * Method that adds to a name a suffix with the given separator.
	 *
	 * @param name      name to process
	 * @param suffix    suffix to add
	 * @param separator separator to use
	 * @return the name concatenated with the separator and the suffix
	 */
	@Nonnull
	public static String addSuffixOf(@Nonnull final String name,
	                                 final String suffix,
	                                 final String separator) {
		return isNotBlank(suffix) ? name + firstNonNull(separator, EMPTY) + suffix : name;
	}

	/**
	 * Method that adds to a name a suffix with an empty separator.
	 *
	 * @param name      name to process
	 * @param suffix    suffix to add
	 * @return the name concatenated with the suffix
	 */
	@Nonnull
	public static String addSuffix(@Nonnull final String name,
	                               final String suffix) {
		return addSuffixOf(name, suffix, EMPTY);
	}

	/**
	 * Method that adds to a name a suffix with a name separator.
	 *
	 * @param name      name to process
	 * @param suffix    suffix to add
	 * @return the name concatenated with the name separator and the suffix
	 */
	@Nonnull
	public static String addSuffixName(@Nonnull final String name,
	                                   final String suffix) {
		return addSuffixOf(name, suffix, NAME_SEPARATOR);
	}

	/**
	 * Method that adds to a name a prefix with the given separator.
	 *
	 * @param name      name to process
	 * @param prefix    prefix to add
	 * @param separator separator to use
	 * @return the prefix concatenated with the separator and the name
	 */
	@Nonnull
	public static String addPrefixOf(@Nonnull final String name,
	                                 final String prefix,
	                                 final String separator) {
		return isNotBlank(prefix) ? prefix + firstNonNull(separator, EMPTY) + name : name;
	}

	/**
	 * Method that adds to a name a prefix with an empty separator.
	 *
	 * @param name      name to process
	 * @param prefix    prefix to add
	 * @return the prefix concatenated with the name
	 */
	@Nonnull
	public static String addPrefix(@Nonnull final String name,
	                               final String prefix) {
		return addPrefixOf(name, prefix, EMPTY);
	}

	/**
	 * Method that adds to a name a prefix with the name separator.
	 *
	 * @param name      name to process
	 * @param prefix    prefix to add
	 * @return the prefix concatenated with the name separator and the name
	 */
	@Nonnull
	public static String addPrefixName(@Nonnull final String name,
	                                   final String prefix) {
		return addPrefixOf(name, prefix, NAME_SEPARATOR);
	}

	/**
	 * Method that adds to a name a suffix and prefix with the given separator.
	 *
	 * @param name      name to process
	 * @param prefix    prefix to add
	 * @param suffix    suffix to add
	 * @param separator separator to use
	 * @return the prefix concatenated with the separator, the name, the separator again and the suffix
	 */
	@Nonnull
	public static String addWrapOf(@Nonnull final String name,
	                               final String prefix,
	                               final String suffix,
	                               final String separator) {
		return addSuffixOf(addPrefixOf(name, prefix, separator), suffix, separator);
	}

	/**
	 * Method that adds to a name a suffix and prefix with an empty separator.
	 *
	 * @param name      name to process
	 * @param prefix    prefix to add
	 * @param suffix    suffix to add
	 * @return the prefix concatenated with the name and the suffix
	 */
	@Nonnull
	public static String addWrap(@Nonnull final String name,
	                             final String prefix,
	                             final String suffix) {
		return addWrapOf(name, prefix, suffix, EMPTY);
	}

	/**
	 * Method that adds to a name a suffix and prefix with the name separator.
	 *
	 * @param name      name to process
	 * @param prefix    prefix to add
	 * @param suffix    suffix to add
	 * @return the prefix concatenated with the name separator, the name, the separator again and the suffix
	 */
	@Nonnull
	public static String addWrapName(@Nonnull final String name,
	                                 final String prefix,
	                                 final String suffix) {
		return addWrapOf(name, prefix, suffix, NAME_SEPARATOR);
	}

}
