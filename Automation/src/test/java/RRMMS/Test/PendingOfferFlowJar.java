package RRMMS.Test;

import org.testng.TestNG;

public class PendingOfferFlowJar {

	public static void main(String[] args) {
		 TestNG testng = new TestNG();
         Class[] classes = new Class[]{PendingOfferFlow.class};
         Class[] classes2 = new Class[]{PendingDueDiligence_Flow.class};
         testng.setTestClasses(classes);
         testng.setTestClasses(classes2);
         testng.run();
	}

}
