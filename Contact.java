public class Contact implements Comparable{
	private String fName, lName, phone, pic;
	
	public Contact(String fName, String lName, String phone, String pic){
		this.fName = fName;
		this.lName = lName;
		this.phone = phone;
		this.pic = pic;
	}
	
	public String getFirst(){
		return fName;
	}
	
	public String getLast(){
		return lName;
	}
	
	public String getPhone(){
		return phone;
	}
	
	public String getPic(){
		return pic;
	}
	
	public int compareTo(Object O){
		String first = ((Contact) O).getFirst();
		if(fName.compareTo(first) < 0){
			return -1;
		}else if(fName.compareTo(first) > 0){
			return 1;
		}else{
			return 0;
		}		
	}
	
	public String toString(){
		return lName + ", " + fName + " " + phone + " " + pic; 
	}

}
