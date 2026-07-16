package com.gym.gymmgmsys.mapper;

import com.gym.gymmgmsys.dto.response.MemberResponse;
import com.gym.gymmgmsys.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {


    public MemberResponse toResponse(
            Member member
    ){


        return MemberResponse.builder()

                .id(
                        member.getId()
                )

                .name(
                        member.getUser()
                                .getFirstName()
                                +" "
                                +member.getUser()
                                .getLastName()
                )

                .email(
                        member.getUser()
                                .getEmail()
                )

                .age(
                        member.getAge()
                )

                .gender(
                        member.getGender()
                )

                .height(
                        member.getHeight()
                )

                .weight(
                        member.getWeight()
                )

                .address(
                        member.getAddress()
                )

                .joinDate(
                        member.getJoinDate()
                )

                .build();

    }

}