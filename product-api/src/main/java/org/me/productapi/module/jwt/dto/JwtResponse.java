package org.me.productapi.module.jwt.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
    
    private Integer id;
    private String name;
    private String email;

    public static JwtResponse getUser(Claims claims){

        try {

            return new ObjectMapper().convertValue(claims.get("authUser"), JwtResponse.class);
        } catch (Exception e){

            e.printStackTrace();
            return null;
        }
    }
}
