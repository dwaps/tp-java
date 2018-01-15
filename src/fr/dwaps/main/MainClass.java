package fr.dwaps.main;

import java.util.List;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		FileGenerator fg = new FileGenerator();
		List<String> entities = fg.getEntitiesName("docs.properties");
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Quel fichier json voulez-vous obtenir ?");
			
			for (int i = 0; i < entities.size(); i++) {
				String entity = entities.get(i);
				System.out.println((i+1) + "/ " + entity);
			}
			
			try {
				System.out.print("Votre réponse : ");
				int indexOfEntity = sc.nextInt();
				fg.generateDoc(entities.get(indexOfEntity-1));
				break;
			}
			catch (Exception e) {
				sc.skip(".*");
			}
		}
		
		System.out.println("\nFin du programme");
		sc.close();
	}

}