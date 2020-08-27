package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.Exception.DomainException;
import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();

			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date check_in = sdf.parse(sc.next());

			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date check_out = sdf.parse(sc.next());

			Reservation reservation = new Reservation(number, check_in, check_out);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data update the reservation: ");

			System.out.print("Check-in date (dd/MM/yyyy): ");
			check_in = sdf.parse(sc.next());

			System.out.print("Check-out date (dd/MM/yyyy): ");
			check_out = sdf.parse(sc.next());

			reservation.updateDates(check_in, check_out);
			System.out.println("Reservation: " + reservation);
		} catch (ParseException e) {
			System.out.println("Invalid date format");
		} catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}catch(RuntimeException e) {
			System.out.println("Unexpecteed error");
		}

		sc.close();
	}

}
