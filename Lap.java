import java.util.Scanner;

public class Lap {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		device d=new device("lg","v1.0","2000GB");
		d.getdetails();
		battery b=new battery("Thosiba",4000);
		processor p;
		keybord k;
		display dpy=new display("led","lg");
		p=new processor("Intel","Dual-core",dpy);
		k=new keybord("Dell","wired",p,"hello hi");
		Laptop l=new Laptop("hp","11-gen","1TB","12GB","windows",b,dpy,k);
		l.getdetails();
		System.out.println("-------------");
		b.plugin=true;
		b.Charging();
		
		
		

	}

}
class device{
	String company;
	String version;
	String storage;
	public device(String company, String version, String storage) {
		super();
		this.company = company;
		this.version = version;
		this.storage = storage;
	}
	void getdetails() {
		System.out.println("company of ur device: "+company);
		System.out.println("version of ur device: "+version);
		System.out.println("storage of ur device: "+storage);
		
	}
	
	
	
}
class Laptop extends device{
	String ram;
	String os;
	battery b;
	display d;
	keybord k;
	public Laptop(String company, String version, String storage, String ram, String os, battery b, display d,
			keybord k) {
		super(company, version, storage);
		this.ram = ram;
		this.os = os;
		this.b = b;
		this.d = d;
		this.k = k;
	}
	void getdetails() {
		super.getdetails();
		System.out.println("Ram of ur Laptap: "+company);
		System.out.println("OS of ur Laptop: "+os);
		System.out.println("battery details of ur Laptop: "+"company: "+b.company+"capacity: "+ b.capacity);
		System.out.println("disply details of ur Laptop: "+"company: "+d.company+"type: "+ d.type);
		System.out.println("keybord details of ur Laptop: "+"company: "+k.company+"connection: "+ k.connection);
	}
	
	
}
class battery{
	String company;//presario,thosiba ,samsung,hitachi
	float capacity;
	boolean plugin;
	int currentCharge;
	void Charging() throws InterruptedException {
		 if(currentCharge<100) {
			 System.out.println("charging....");
			 while(plugin) {
				 currentCharge++;
				 System.out.println(currentCharge);
				 Thread.sleep(100);
				 if(currentCharge==100) {
					 plugin=false;
					 break;
				 }
				
			}
		 }
	}
	public battery(String company, float capacity) {
		super();
		this.company = company;
		this.capacity = capacity;

	}
	
}
class processor{
	String company;//AMD,Intel
	String Core;//single-core,dual-core ,multi-core
	String input;
	String output;
	keybord k;
	display d;
	public processor(String company, String core, display d) {
		super();
		this.company = company;
		Core = core;
		this.d = d;
		
	}
	void sendToDisplay() {
		System.out.println("send the output to disply based on input");
		Scanner Sc=new Scanner(System.in);
		output=Sc.next();
		d.input=output;
	}
	
	
}
class keybord{
	String company;//FILCO,DELL ,TVS
	String connection;// via wired|bluetooth|Ethernet
	String request;
	processor p;
	
	
	
	public keybord(String company, String connection, processor p,String request) {
		super();
		this.company = company;
		this.connection = connection;
		this.p = p;
		this.request=request;
	}


	void sendRequest() {
		System.out.println("type the reguest");
		Scanner sc=new Scanner(System.in);
		request=sc.next();
		p.input=request;
		System.out.println("request send to processor");
		
	}
	
	
}
class display{
	String type;//IPS,LED
	String company;//lG,SAMSUNG,TOSHIBA
	String input;
	
	public display(String type, String company) {
		super();
		this.type = type;
		this.company = company;
	}
	void receive() {
		System.out.println("receive message from processor is: "+input);
		
	}
	void printDetails(){
		System.out.println(input);
		
	}
	
}
