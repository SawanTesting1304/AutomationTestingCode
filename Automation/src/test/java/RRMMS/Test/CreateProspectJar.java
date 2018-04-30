package RRMMS.Test;
import org.testng.TestNG;
public class CreateProspectJar {

		 public static void main(String[] args) {
		  // TODO Auto-generated method stub
		  
		          TestNG testng = new TestNG();
		           Class[] classes = new Class[]{CreateProspect.class};
		           testng.setTestClasses(classes);
		           testng.run();

		  
		 }
	}


