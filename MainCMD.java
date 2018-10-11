package j8.kotcmm;

import java.util.Scanner;

public class MainCMD {

	public static void main(String[] args) {
		try {
			Core core = new Core(4,4);
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			while(true){
				
				for(int i =0;i<core.getY();i++){
					for(int j = 0;j<core.getX();j++){
						System.out.print(core.getData()[i][j]);
						System.out.print("\t");
					}
					System.out.println();
				}
				System.out.println("======================================");
				if(core.isGameOver()){
					System.out.println("Game Over");
				}
				
				int r = sc.nextInt();
				switch (r) {
				case 1:
					core.moveLeft();
					break;
				case 2:
					core.moveRight();
					break;
				case 3:
					core.moveUp();
					break;
				case 4:
					core.moveDown();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
