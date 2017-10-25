package br.com.trendsoftware.mlProvider.dto;

public enum ItemStatus {

		ACTIVE("active"),
		PAUSED("paused"),
		CLOSED("closed");
		
		private String name;

		private ItemStatus(String name) {
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
		    for (ItemStatus c : ItemStatus.values())
		        if (c.name.equals(name))
		            return true;
		    return false;
		}
		
		public static ItemStatus lookup(String name) 
		{
			for ( ItemStatus topic : ItemStatus.values() )
				if ( name.equals(topic.getName()) )
					return topic;
			return null;
		}
		
}
