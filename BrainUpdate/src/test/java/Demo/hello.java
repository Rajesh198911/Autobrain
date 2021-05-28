package Demo;





public class hello {
	public static final String ANSI_RED = "\033[0;31m"; 
	public static final String ANSI_RESET = "\u001B[0m";
	
	
	public static void main(String[] args) {
		System.out.println(ANSI_RED + "This text is red!" + ANSI_RESET); 
		System.out.println("HI");
	}
	

}
