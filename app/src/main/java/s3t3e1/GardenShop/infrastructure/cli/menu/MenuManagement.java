package s3t3e1.GardenShop.infrastructure.cli.menu;

import s3t3e1.GardenShop.application.utilities.Input_sc;
import s3t3e1.GardenShop.domain.enums.Colours;

public class MenuManagement {
    
	 public Colours chooseColour() {
	        boolean quit = false;
	        do {
	        String color = Input_sc.enterStr("Enter the flower's colour\n"
	                + "(Red, Blue, Green, Pink, Yellow, Orange, Purple):");
	        if(){ //aqui tendria que validar si el String es un color valido
	            quit = true;
	        }
	        else {
	            System.out.println("Enter a valid colour");
	        }
	        } while(!quit);
	        Colours colour = valueOf(color.toUpperCase());

	        return colour;
	    }

	    public boolean chooseMaterial() {
	        boolean quit = false;
	        int material;
	        do {
	            material = Input_sc.enterInt("Choose the decoration material:\n"
	                    + "1: Plastic\n"
	                    + "2: Wood");
	            if ((material == 1) || (material == 2)) {
	                quit = true;
	            } else {
	                System.out.println("Enter a valid input");
	            }
	        } while (!quit);

	        return material == 1;

	    }

}
