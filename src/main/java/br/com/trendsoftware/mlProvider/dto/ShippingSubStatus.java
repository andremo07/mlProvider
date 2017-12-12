package br.com.trendsoftware.mlProvider.dto;

public enum ShippingSubStatus {

		PRINTED("printed"),
		READY_TO_PRINT("ready_to_print");
		
		private String name;

		private ShippingSubStatus(String name) {
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
		    for (ShippingSubStatus c : ShippingSubStatus.values())
		        if (c.name.equals(name))
		            return true;
		    return false;
		}
		
		public static ShippingSubStatus lookup(String name) 
		{
			for ( ShippingSubStatus topic : ShippingSubStatus.values() )
				if ( name.equals(topic.getName()) )
					return topic;
			return null;
		}
		
}
