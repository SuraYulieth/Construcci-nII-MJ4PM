package club.service.interfaces;

import club.dto.PartnerDto;
import club.dto.UserDto;

@SuppressWarnings("unused")
public interface AdminService {
	 public void createPartner(PartnerDto partnerDto) throws Exception;
}
