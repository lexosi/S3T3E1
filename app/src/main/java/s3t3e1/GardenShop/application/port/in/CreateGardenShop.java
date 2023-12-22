package s3t3e1.GardenShop.application.port.in;

//import s3t3.GardenShop.application.utilities.Input_sc;
import s3t3e1.GardenShop.domain.GardenShop;

public interface CreateGardenShop {

	GardenShop createGardenShop(String name);
	
//	String shopName = Input_sc.enterStr("Enter the name of the Garden Shop:");
//	GardenShop garden = new GardenShop(shopName);
}
