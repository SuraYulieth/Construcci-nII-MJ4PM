package club.dao;

import java.sql.PreparedStatement;

import club.config.MYSQLConnection;
import club.dao.interfaces.GuestDao;
import club.dto.GuestDto;
import club.helpers.Helper;
import club.model.Guest;

public class GuestDaoImplementation implements GuestDao{

	@Override
	public void createGuest(GuestDto guestDto) throws Exception {
		Guest guest = Helper.parse(guestDto);
		String query = "INSERT INTO GUEST(USERID,PARTNERID,STATUS) VALUES (?,?,?) ";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setLong(1, guest.getUsarId().getId());
		preparedStatement.setLong(2, guest.getId().getId());
		preparedStatement.setString(3, guest.getInvitationStatus());
		preparedStatement.execute();
		preparedStatement.close();
		
	}

}
