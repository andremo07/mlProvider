package br.com.trendsoftware.mlProvider.dto;

public enum ShippingStatus {

		TO_BE_AGREED("to_be_agreed"),
		PENDING("pending"),
		HANDLING("handling"),
		READY_TO_SHIP("ready_to_ship"),
		SHIPPED("shipped"),
		DELIVERED("delivered"),
		NOT_DELIVERED("delivered"),
		CANCELLED("cancelled");
		
		private String name;

		private ShippingStatus(String name) {
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
		    for (ShippingStatus c : ShippingStatus.values())
		        if (c.name.equals(name))
		            return true;
		    return false;
		}
		
		public static ShippingStatus lookup(String name) 
		{
			for ( ShippingStatus topic : ShippingStatus.values() )
				if ( name.equals(topic.getName()) )
					return topic;
			return null;
		}
		
}
