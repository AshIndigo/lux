package com.ashindigo.lux.api;

/**
 * Defines a block as a source of Lux
 */
public interface LuxSource {

	/**
	 * Whether or not the source can output Lux
	 *
	 * @return Can it generate?
	 */
	boolean canRun();

	/**
	 * Is the source generating Lux?
	 *
	 * @return Is it currently generating
	 */
	boolean isGenerating();


}
