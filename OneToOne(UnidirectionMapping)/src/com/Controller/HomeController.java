package com.Controller;

import java.util.Scanner;

import com.Servise.ServiseImpl;

public class HomeController {

	public static void main(String[] args) {

		ServiseImpl s = new ServiseImpl();
		

		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			
			System.out.println("1.AddPersonWithAdhar");
			System.out.println("2.GetPersonOnlyUsingPersonId");
			System.out.println("3.GetAdharOnlyUsingPersonId");
			System.out.println("4.UpdatePersonOnlyUsingPersonId");
			System.out.println("5.UpdateAdharOnlyUsingPersonId");
			System.out.println("6.DeletePersonOnlyUsingPersonId");
			System.out.println("7.DeleteAdharOnlyUsingPersonId");
			System.out.println("8.AddPersonOnly");
			System.out.println("9.AddAdharOnly");
			System.out.println("10.Exit");
			System.out.println("Enter the choise");
			int a = sc.nextInt();

			switch (a) {
			case 1:
				s.AddPersonWithhAdhar();
				break;

			case 2:
				s.GetPersonOnlyUsingPersonId();
				break;
			case 3:
				s.GetAdharOnlyUsingPersonId();
				break;
			case 4:
				s.UpdatePersonOnlyUsingPersonId();
				break;
			case 5:
				s.UpdateAdharOnlyUsingPersonId();

				break;
			case 6:
				s.DeletePersonOnlyUsingPersonId();

				break;
			case 7:
				s.DeleteAdharOnlyUsingPersonId();

				break;
			case 8:
				s.AddPersonOnly();

				break;
			case 9:

				s.AddAdharOnly();
				break;
			case 10:
				flag = false;
				System.out.println("exit");
				break;

			default:
				System.out.println("Enter the valid choise");
				break;
			}

		}

	}
}
