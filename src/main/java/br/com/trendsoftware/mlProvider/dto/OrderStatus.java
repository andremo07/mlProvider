package br.com.trendsoftware.mlProvider.dto;

public enum OrderStatus {

		TREND_STORE("TrendStore"),
		B2W("B2W"),
		MERCADO_LIVRE("MercadoLivre"),
		MAGENTO("Magento"),
		CNOVA("Cnova"),
		AMAZON("Amazon");
		
		private String name;

		private OrderStatus(String name) {
			this.name = name;
		}
		
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public static boolean contains(String name)
		{
		    for (OrderStatus c : OrderStatus.values())
		        if (c.name.equals(name))
		            return true;
		    return false;
		}
		
		public static OrderStatus lookup(String name) 
		{
			for ( OrderStatus topic : OrderStatus.values() )
				if ( name.equals(topic.getName()) )
					return topic;
			return null;
		}
		
}
