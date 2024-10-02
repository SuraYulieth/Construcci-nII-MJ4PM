package club.dao.interfaces;

import club.dto.PartnerDto;
import club.dto.UserDto;

public interface PartnerDao {
	public void createPartner(PartnerDto partnerDto) throws Exception;
	public PartnerDto findPartnerByUserId(UserDto userDto) throws Exception;
}

