package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Scanner scFile = null;

		List<Product> list = new ArrayList<>();

		File caminhoArquivo = new File("D:\\ProgramasJava\\out\\summary.txt");

		System.out.print("Quantidade de produtos: ");
		int num = sc.nextInt();

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {
			for (int i = 1; i <= num; i++) {
				System.out.println("Product #" + i + " Data:");
				System.out.print("Nome: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Preço: ");
				Double price = sc.nextDouble();
				System.out.print("Quantidade: ");
				int quantity = sc.nextInt();
				list.add(new Product(name, price, quantity));
			}

			String productVect[] = new String[num];
			int cont = 0;
			for (Product p : list) {
				productVect[cont] = p.toString();
				cont++;
			}

			boolean sucess = new File(caminhoArquivo + "\\out").mkdir();
			System.out.println("Diretório criado com sucesso: " + sucess);

			for (String line : productVect) {
				bw.write(line);
				bw.newLine();
			}
			File fileOut = new File("D:\\ProgramasJava\\out\\summary.txt");
			scFile = new Scanner(fileOut);
			
			while (scFile.hasNextLine() == true) {
				System.out.println(scFile.nextLine());
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			if (scFile != null) {
				sc.close();
			}

		}
	}
}
