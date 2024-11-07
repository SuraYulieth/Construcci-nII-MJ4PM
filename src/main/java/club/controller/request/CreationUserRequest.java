package club.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CreationUserRequest {
    private String name;
    private Long document;
    private String cellPhoneNumber;
    private String userName;
    private String password;
}
