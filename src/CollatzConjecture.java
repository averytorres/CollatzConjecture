
public class CollatzConjecture {

	private String message="";
	private int num;

	public int getNum() {
		return num;
	}
	
	public static void main(String[] args) {

		CollatzConjecture c = new CollatzConjecture(143);
		
		while(c.getNum()!=1){
			c.HOTPO(c.getNum());
		}
		
		System.out.println(c.getMessage());
	}
	
	public CollatzConjecture(int pass){

		num=pass;
		setMessage(num);

	}
	
	public int HOTPO(int pass) {
		
		//passed in number is even
		if(pass%2==0){
			num=pass/2;			
			setMessage(num);
		}
		//passed in number is odd
		else{
			num=(pass*3)+1;
			setMessage(num);
		}
		
		return num;
	}
	
	private void setMessage(int num) {
		if(num==1){
			this.message = message+num;
		}
		else{
			this.message = message+num+"->";
		}
	}

	public String getMessage() {
		return message;
	}

}
