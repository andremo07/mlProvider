package br.com.trendsoftware.mlProvider.dataprovider;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

public abstract class MlProvider
{
	private Logger logger;
	
	private Gson parser;
		
	public MlProvider(){
		parser = new Gson();
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public Gson getParser() {
		return parser;
	}

	public void setParser(Gson parser) {
		this.parser = parser;
	}
}
