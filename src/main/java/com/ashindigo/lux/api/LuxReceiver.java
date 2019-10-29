package com.ashindigo.lux.api;

public interface LuxReceiver {

	/**
	 * Receive lux from another source
	 * @param lux Type of lux being inserted
	 * @param amount Amount of lux to be received
	 * @return The remainder of the lux
	 */
	int receiveLux(LuxElements lux, int amount);

	/**
	 * Can this receive Lux
	 * @param lux Type of Lux
	 * @return Whether or not this machine can receive Lux
	 */
	boolean canReceive(LuxElements lux);
}
