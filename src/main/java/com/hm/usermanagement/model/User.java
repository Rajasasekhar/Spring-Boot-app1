package com.hm.usermanagement.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private long id;
    private String password;
    private String userName;
    private String email;
}
