package s3t3e1.GardenShop.application.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import s3t3e1.GardenShop.application.port.in.RemoveProduct;
import s3t3e1.GardenShop.application.port.out.ProductRepository;
import s3t3e1.GardenShop.domain.Product;
import s3t3e1.GardenShop.domain.enums.ProductType;
import s3t3e1.GardenShop.infrastructure.repository.TxtGardenShopRepository;

public class RemoveProductService implements RemoveProduct {

	private final ProductRepository repository;
	private String filePath = "GardenShop.txt";
	
	public RemoveProductService(ProductRepository repository) {
		this.repository = repository;
	}

	@Override
	public void removeProduct(Product product) {
		
		 String prodToRemove = product.toString();

	        String tempFile = "temp.txt";
	        File oldFile = new File(filePath);
	        File newFile = new File(tempFile);

	        int line = 0;
	        String currentLine;

	        try {
	            FileWriter fw = new FileWriter(tempFile, true);
	            BufferedReader bw = new BufferedReader(fw);
	            PrintWritter pw = new PrintWritter(bw);

	            FileReader fr = new FileReader(filePath);
	            BufferedReader br = new BufferedReader(fr);

	            while ((currentLine = br.readLine()) != null) {
	                line++;

	                if (!prodToRemove.equals(line)) {
	                    pw.println(currentLine);
	                }
	            }
	            pw.flush();
	            pw.close();
	            fr.close();
	            br.close();
	            bw.close();
	            fw.close();

	            oldFile.delete();
	            File dump = new File(filePath);
	            newFile.renameTo(dump);

	        } catch (Exception e) {
	            System.out.println(e);
	        }
		
		repository.removeProduct(product);	
	}

}
