package club.controller.validator;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Component
public class InvoiceDetailValidator extends CommonsValidator{

    public double validAmount(String amountDto) throws Exception{
		return super.isValidDouble("The amount ", amountDto);
	}

    public int validItem(String itemDto) throws Exception{
        return super.isValidInteger("The item ", itemDto);
    }

    public void validDescription(String descriptionDto) throws Exception{
        super.isValidString("Description ", descriptionDto);
    }
}
