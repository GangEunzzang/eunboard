package com.example.eunboard.domain.dto.response;

import com.example.eunboard.domain.entity.Member;
import com.example.eunboard.domain.entity.MemberRole;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MemberResponseDTO {

    private String token;

    @JsonIgnore
    private Long id;

    private String email;

    private String studentNumber;

    private String memberName;

    private String department;

    private String phoneNumber;

    private MemberRole auth;

    private String profileImage;

    public static MemberResponseDTO toDTO(Member entity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entity, MemberResponseDTO.class);
    }
}
