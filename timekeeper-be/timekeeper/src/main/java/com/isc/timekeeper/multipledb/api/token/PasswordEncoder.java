package com.isc.timekeeper.multipledb.api.token;

import javax.persistence.PrePersist;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString
@Component
public class PasswordEncoder {
	
	
	@PrePersist
    public String hashPassword(String string){
      
        String hashed = BCrypt.hashpw(string, BCrypt.gensalt(15));
        
        return hashed;
    }
	
	public String encode(String string) {
		return new BCrypt().hashpw(string, BCrypt.gensalt(10));
	}
}
