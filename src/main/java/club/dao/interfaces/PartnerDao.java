package club.dao.interfaces;

import club.dto.PartnerDto;

public interface PartnerDao {
	public void createPartner(PartnerDto partnerDto) throws Exception;
	public PartnerDto findById(PartnerDto idDto) throws Exception ;
}

