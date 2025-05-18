package com.Controller;

import java.util.Scanner;

import com.Servise.Serviseimpl;

public class HomeController {

	

	public static void main(String[] args) {
		     Serviseimpl s = new Serviseimpl();
		
		
			Scanner sc = new Scanner(System.in);
			boolean flag = true;
			while (flag) {
                System.out.println("-----------one to bidirectional mapping-------------");
			    System.out.println("1. AddPersonWithAdhar");

			    System.out.println("2.GetPersonOnlyUsingPersonId");
			    System.out.println("3. GetPersonOnlyUsingAdharId");
			    System.out.println("4. GetAdharOnlyUsingPersonId");
			    System.out.println("5. GetAdharOnlyUsingAdharId");
			    System.out.println("6. UpdatePersonOnlyUsingPersonId");
			    System.out.println("7. UpdatePersonOnlyUsingAdahrId");

			    System.out.println("8.UpdateAdharOnlyUsingPersonId");
			    System.out.println("9.UpdateAdharOnlyUsingAdahrId");
			    System.out.println("10.DeletePersonOnlyUsingPersonId");
			    System.out.println("11.DeletePersonOnlyUsingAdharId");
			    System.out.println("12.DeleteAdharOnlyUsingPersonId");
			    System.out.println("13.DeleteAdharOnlyUsingAdharId");
			    System.out.println("14.AddPersonOnly");
			    System.out.println("15.AddAdharOnly");
			    System.out.println("16.Exit");
			System.out.println("--------------------------------------------------------------");
				
				System.out.println("Enter the choise");
				int a = sc.nextInt();

				switch (a) {
				case 1:
					s.AddPersonWithAdhar();
					break;

				case 2:
					s.GetPersonOnlyUsingPersonId();
					break;
				case 3:
					s.GetPersonOnlyUsingAdharId();
					break;
				case 4:
					s.GetAdharOnlyUsingPersonId();
					break;
				case 5:
					s.GetAdharOnlyUsingAdharId();

					break;
				case 6:
					s.UpdatePersonOnlyUsingPersonId();

					break;
				case 7:
					s.UpdatePersonOnlyUsingAdahrId();

					break;
				case 8:
					s.UpdateAdharOnlyUsingPersonId();

					break;
				case 9:

					s.UpdateAdharOnlyUsingAdahrId();
					break;
					
				case 10:
					
					s.DeletePersonOnlyUsingPersonId();
					break;
				case 11:
					s.DeletePersonOnlyUsingAdharId();
					break;
				case 12:
					s.DeleteAdharOnlyUsingPersonId();
					break;
				case 13:
					s.DeleteAdharOnlyUsingAdharId();
					break;
				case 14: 
						s.AddPersonOnly();
					break;
				case 15:
					s.AddAdharOnly();
					break;
				case 16:
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
