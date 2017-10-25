package br.com.trendsoftware.mlProvider.dto;

public enum ListingType {

		CLASSICO("gold_special"),
		PREMIUM("gold_pro");
		
		private String name;

		private ListingType(String name) {
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
		    for (ListingType c : ListingType.values())
		        if (c.name.equals(name))
		            return true;
		    return false;
		}
		
		public static ListingType lookup(String name) 
		{
			for ( ListingType topic : ListingType.values() )
				if ( name.equals(topic.getName()) )
					return topic;
			return null;
		}
		
}
