package br.com.trendsoftware.mlProvider.dto;

public enum Topic {

		ITEMS("items"),
		SHIPMENTS("shipments"),
		ORDERS("orders_v2"),
		QUESTIONS("questions"),
		PAYMENTS("payments");
		
		private String name;

		private Topic(String name) {
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
		    for (Topic c : Topic.values())
		        if (c.name.equals(name))
		            return true;
		    return false;
		}
		
		public static Topic lookup(String name) 
		{
			for ( Topic topic : Topic.values() )
				if ( name.equals(topic.getName()) )
					return topic;
			return null;
		}
		
}
