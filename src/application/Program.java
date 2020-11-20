package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		List<Product> product = new ArrayList<>();
 		
		for(int i = 0; i < n; i++) {
			System.out.println("Product #" + (i+1) + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char response = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if(response == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				Product imported = new ImportedProduct(name, price, customsFee);
				product.add(imported);
			}
			else if(response == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				Product used = new UsedProduct(name, price, manufactureDate);
				product.add(used);
			}
			else {
				Product common = new Product(name, price);
				product.add(common);
			}
		}
		System.out.println();
		System.out.println("PRICE TAGS:");
		for(Product p : product) {
			System.out.println(p.priceTag());
		}
		
		sc.close();
	}

}
