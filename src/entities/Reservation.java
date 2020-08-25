package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date check_in;
	private Date check_out;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Integer roomNumber, Date check_in, Date check_out) {
		super();
		this.roomNumber = roomNumber;
		this.check_in = check_in;
		this.check_out = check_out;
	}

	/*****************************************************************/

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheck_in() {
		return check_in;
	}

	public Date getCheck_out() {
		return check_out;
	}

	/******************************************************************/

	public long duration() {
		long diff = check_out.getTime() - check_in.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date check_in, Date check_out) {
		this.check_in = check_in;
		this.check_out = check_out;
	}

	@Override
	public String toString() {
		return "Room " + roomNumber + ", check-in: " + sdf.format(check_in) + ", check-out: " + sdf.format(check_out) + ", " + duration() + " nights";
	}

}