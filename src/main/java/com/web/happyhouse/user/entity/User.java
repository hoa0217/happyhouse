package com.web.happyhouse.user.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.web.happyhouse.base.BaseTimeEntity;
import com.web.happyhouse.user.dto.UserRq;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity implements UserDetails {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long userId; // 사용자ID

    @Column(nullable = false, unique = true, length = 30)
    private String email; // 이메일

    @Column(nullable = false, length = 100)
    private String name; // 이름

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(length = 100)
    private String password; // 비밀번호

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles
                .stream().map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public String getUsername() {
        return String.valueOf(this.userId);
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isEnabled() {
        return true;
    }

    @Builder
    private User(Long userId, String email, String name, String password, List<String> roles) {
        this.userId = userId;
        this.email = email;
        this.name = name;
        this.password = password;
        if (roles != null && !roles.isEmpty()) this.roles = roles;
        else roles = new ArrayList<>();
    }

    public static UserRq toDto(User entity) {
        UserRq dto = new UserRq();
        dto.setUserId(entity.getUserId());
        dto.setEmail(entity.getEmail());
        dto.setName(entity.getName());
        dto.setPassword(entity.getPassword());
        dto.setRoles(entity.getRoles());

        return dto;
    }

    public static User toEntity(UserRq dto) {
        User entity = User.builder()
                .userId(dto.getUserId())
                .email(dto.getEmail())
                .name(dto.getName())
                .password(dto.getPassword())
                .roles(dto.getRoles())
                .build();

        return entity;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void updatePassword(String password){
        this.password = password;
    }

}
