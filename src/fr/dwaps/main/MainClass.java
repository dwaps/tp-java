package fr.dwaps.main;

public class MainClass {

	public static void main(String[] args) {
		Drawer drawer = new Drawer();
		drawer.setAnimated(true);
		drawer.setBordered(false);
		drawer.setSpeed(Drawer.SPEED_FAST);
		drawer.house(7,7);
	}

}