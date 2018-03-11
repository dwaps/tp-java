package fr.kaiqiang.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Drawer {
	private String symbol = "0 ";
	Scanner scanner = new Scanner(System.in);

	public void rect(int width, int height) {
		while (height > 0) {
			for (int i = 0; i < width; i++) {
				System.out.print(symbol);
				
			}
			System.out.println();
			height--;
		}
	}
	
	public void rectanimated(int width, int height) {
		for(Vitesse vite : Vitesse.values()) {
			System.out.println(vite);
		}
		int fast = 250; int medium = 500; int slow = 1000; int time = 0;
		System.out.println("Choose Speed : ");
		String speed = scanner.nextLine();
		System.out.println(speed);
		String firstcondition = "fast"; String scdcondition = "medium"; String thrdcondition = "slow";
		while (true) {
			if (speed == firstcondition) {
				time = 150;
				break;
			}
			else if(speed == scdcondition) {
				time = 500;
				break;
			}
			else if(speed == thrdcondition) {
				time = 1000;
				break;
			}
		}
		
		while (height > 0) {
			for (int i = 0; i < width; i++) {
				System.out.print(symbol);
				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println();
			height--;
		}
	}
	
	public enum Vitesse {
		fast,
		medium,
		slow;
		 
	}

	public void setSymbol(String p) {
		if (p.length() > 3) return;
		symbol = p;
	}

	public void DimensionsIn() {
		int larg = 0, haut = 0;
		
		
		while (true) {
			System.out.print("Largeur : ");
			
			try {
				larg = Math.abs(scanner.nextInt());
				System.out.print("Hauteur : ");
				haut = Math.abs(scanner.nextInt());
				break;
			}
			catch (InputMismatchException e) {
				scanner.nextLine();
			}
		}
		System.out.println("Mode animé ? 0 pour Oui ou 1 pour Non");
		int animationmod = scanner.nextInt();
			while(true) {
				if (animationmod == 0) {
					System.out.println("Mode animé : " + animationmod);
					rectanimated(larg, haut);
					break;
				}
				else if(animationmod == 1) {
					System.out.println("Mode animé : " + animationmod);
					rect(larg, haut);
					break;
				}
				
					
				
			}
			
		}
	
	}



