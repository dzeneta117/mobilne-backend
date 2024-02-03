package com.mobilneshop.Mobilneshop.responses;


import com.mobilneshop.Mobilneshop.entity.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private User user;
    public JwtResponse(String accessToken, User user) {
        this.token = accessToken;
        this.user=user;
    }

}
