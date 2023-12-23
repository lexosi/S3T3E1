package s3t3e1.GardenShop.infrastructure.cli.menu;

import s3t3e1.GardenShop.application.utilities.Input_sc;

public class ChooseOptions {

	// Choose Flower colour
		public static String chooseColour() {
			
			String[] colours = {"Red", "Blue", "Green", "Pink", "Yellow", "Orange", "Purple"};
			
			boolean quit = false;
			String color = "";
			
			do {
				byte choice = showColours();
				
				if(choice >= 1 && choice <= 7){
					color = colours[choice -1];
				} else {
			        System.out.println("Enter a valid number between 1 and 7");
				}
				
			} while(!quit);
		
			return color;
		}
		
		
		public static byte showColours(){
			byte coloursOption = Input_sc.enterByte("Choose the flower's colour:\n"
					+ "1. Red\n"
					+ "2. Blue\n"
					+ "3. Green\n"
					+ "4. Pink\n"
					+ "5. Yellow\n"
					+ "6. Orange\n"
					+ "7. Purple");
			
			return coloursOption;
		}
		
		// Choose Decoration material
		public static boolean chooseMaterial() {

			boolean material = false;
			byte materialsOption = showMaterials();

			if(materialsOption < 1 || materialsOption > 2) {
				System.out.println("Enter a valid number between 1 and 2");
				return material; // O devuelve un valor predeterminado o lanza una excepción
			}

			return materialsOption == 2;
		}


		public static byte showMaterials() {
			byte materialsOption = Input_sc.enterByte("Choose the decoration's material:\n"
					+ "1. Wood\n"
					+ "2. Plastic");
			return materialsOption;
		}

}
