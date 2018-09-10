package br.com.trendsoftware.mlProvider.service;

import org.apache.logging.log4j.Logger;

import br.com.trendsoftware.mlProvider.http.client.MeliClient;


public class MlService {
	
	protected MeliClient meli;
	
	private Logger logger;
	
	public MlService(){
		meli=new MeliClient();
	}

	public MeliClient getMeli() {
		return meli;
	}

	public void setMeli(MeliClient meli) {
		this.meli = meli;
	}
	
	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	
}
