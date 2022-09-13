package com.example.eunboard.domain.dto;

import com.example.eunboard.domain.entity.MemberRole;
import lombok.Data;

import java.io.Serializable;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class MemberDTO implements Serializable {
    private Long id;
    private String userId;
    private String userPassword;
    private String nickname;
    private String memberRole;
}
