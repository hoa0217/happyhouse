package com.web.happyhouse.user.entity;

import com.web.happyhouse.base.BaseEntity;
import com.web.happyhouse.user.dto.UserDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name="user_id")
    private Long userId; // 사용자ID

    @Column(nullable = false)
    private String email; // 이메일

    @Column(nullable = false)
    private String name; // 이름

    private String password; // 비밀번호

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role; // 역할

    @Builder
    private User(Long userId, String email, String name, String password, Role role) {
        this.userId = userId;
        this.email = email;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public static UserDto toDto(User entity){
        UserDto dto = new UserDto();
        dto.setUserId(entity.getUserId());
        dto.setEmail(entity.getEmail());
        dto.setName(entity.getName());
        dto.setPassword(entity.getPassword());
        dto.setRole(entity.getRole());

        return dto;
    }

    public static User toEntity(UserDto dto){
        User entity = User.builder()
                .userId(dto.getUserId())
                .email(dto.getEmail())
                .name(dto.getName())
                .password(dto.getPassword())
                .role(dto.getRole())
                .build();

        return entity;
    }

    public User update(String name, String password){
        this.name = name;
        this.password = password;

        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }

}
