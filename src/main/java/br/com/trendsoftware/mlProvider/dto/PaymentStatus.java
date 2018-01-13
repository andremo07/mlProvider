package br.com.trendsoftware.mlProvider.dto;

public enum PaymentStatus {

		APPROVED("approved"),
		REJECT("reject");
		
		private String name;

		private PaymentStatus(String name) {
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
		    for (PaymentStatus c : PaymentStatus.values())
		        if (c.name.equals(name))
		            return true;
		    return false;
		}
		
		public static PaymentStatus lookup(String name) 
		{
			for ( PaymentStatus topic : PaymentStatus.values() )
				if ( name.equals(topic.getName()) )
					return topic;
			return null;
		}
		
}
