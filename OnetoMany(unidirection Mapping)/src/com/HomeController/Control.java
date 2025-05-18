package com.HomeController;

import java.util.Scanner;

import com.Servise.ServiseImpl;

public class Control {
	public static void main(String[] args) {
		ServiseImpl s = new ServiseImpl();

		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag) {

			System.out.println("1.AddStudentWithSubject");
			System.out.println("2.DisplayOnlyStudentDetails");
			System.out.println("3.DisplayAllDetails");
			System.out.println("4.DisplayOnlySubjectDetails");
			System.out.println("5.UpdateOnlyStudentDetailsUsingStudentID");
			System.out.println("6.UpdateOnlySubjectDetailsUsingStudentID");
			System.out.println("7.DeleteOnlyStudentDetailsUsingStudentID");
			System.out.println("8.DeleteOnlySubjectDetailsUsingStudentID");

			System.out.println("9.Exit");
			System.out.println("Enter the choise");
			int a = sc.nextInt();

			switch (a) {
			case 1:
				s.AddStudentWithSubject();
				break;

			case 2:
				s.DisplayOnlyStudentDetails();
				break;
			case 3:
				s.DisplayAllDetails();
				break;
			case 4:
				s.DisplayOnlySubjectDetails();
				break;
			case 5:
				s.UpdateOnlyStudentDetailsUsingStudentID();

				break;
			case 6:
				s.UpdateOnlySubjectDetailsUsingStudentID();

				break;
			case 7:
				s.DeleteOnlyStudentDetailsUsingStudentID();

				break;
			case 8:
				s.DeleteOnlySubjectDetailsUsingStudentID();

				break;
			case 9:
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
