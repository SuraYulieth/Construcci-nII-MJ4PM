package club.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreationInvoiceRequest {
    private double amount;
    private int item;
    private String description;
}
