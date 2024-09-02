package club.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import club.config.MYSQLConnection;
import club.dao.interfaces.PartnerDao;
import club.dto.PartnerDto;
import club.helpers.Helper;
import club.model.Partner;
import club.model.User;

public class PartnerDaoImplementation implements PartnerDao{
	
	public void createPartner(PartnerDto partnerDto) throws Exception {
		Partner partner = Helper.parse(partnerDto);
		String query = "INSERT INTO PARTNER(USERID,AMOUNT,TYPE,CREATIONDATE) VALUES (?,?,?,?) ";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setLong(1, partner.getUserId().getId());
		preparedStatement.setDouble(2, partner.getAvaibleFunds());
		preparedStatement.setString(3, partner.getSuscriptionType());
		preparedStatement.setDate(4, partner.getAfiliationDate());
		preparedStatement.execute();
		preparedStatement.close();
	}

	public PartnerDto findById(PartnerDto partnerDto) throws Exception {
		String query = "SELECT ID,USERID,AMOUNT,TYPE,CREATIONDATE FROM PARTNER WHERE ID = ?";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setLong(1, partnerDto.getIdDto());
		ResultSet resulSet = preparedStatement.executeQuery();
		if (resulSet.next()) {
			Partner partner = new Partner();
			partner.setId(resulSet.getLong("ID"));
			User user = new User();
			user.setId(resulSet.getLong("USERID"));
			partner.setAvaibleFunds(resulSet.getDouble("AMOUNT"));
			partner.setSuscriptionType(resulSet.getString("TYPE"));
			partner.setAfiliationDate(resulSet.getDate("CREATIONDATE"));
			resulSet.close();
			preparedStatement.close();
			return Helper.parse(partner);
		}
		resulSet.close();
		preparedStatement.close();
		return null;
	}
	
}
