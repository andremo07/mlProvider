package br.com.trendsoftware.mlProvider.service;

import org.apache.log4j.Logger;

import br.com.trendsoftware.mlProvider.http.client.Meli;


public class MlService {
	
	protected Meli meli;
	
	private Logger logger;
	
	public MlService(){
	}

	public Meli getMeli() {
		return meli;
	}

	public void setMeli(Meli meli) {
		this.meli = meli;
	}
	
	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	
}
