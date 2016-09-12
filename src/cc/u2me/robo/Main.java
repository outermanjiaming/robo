package cc.u2me.robo;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Context adam = new Context();
		//初始细胞
		adam.newCell(new Hello()).newCell(new Learn()).newCell(new Question()).growUp();
		while(sc.hasNext()){
			String line = sc.nextLine();
			System.err.println(adam.deal(line));
			//不断成长
			adam.growUp();
		}
		sc.close();
	}
}
