package com.ashindigo.lux.api;

public interface LuxReceiver {

	void receiveLux(LuxElements lux, int amount);

	boolean canRecieve(LuxElements lux);
}
