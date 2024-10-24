package club.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.dao.interfaces.PartnerDao;
import club.dao.repository.PartnerRepository;
import club.dto.PartnerDto;
import club.dto.UserDto;
import club.helpers.Helper;
import club.model.Partner;
import club.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Service
public class PartnerDaoImplementation implements PartnerDao{
	@Autowired
	public PartnerRepository partnerRepository;

	@Override
	public void createPartner(PartnerDto partnerDto) throws Exception {
		Partner partner = Helper.parse(partnerDto);
		partnerRepository.save(partner);
	}
	
	@Override
	public PartnerDto findPartnerByUserId(UserDto userDto) throws Exception {
		User user = Helper.parse(userDto);
		Partner partner = partnerRepository.findPartnerByUserId(user);
		return Helper.parse(partner);
	}
	
}
