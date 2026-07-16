package com.gym.gymmgmsys.service.impl;

import com.gym.gymmgmsys.dto.request.MemberRequest;
import com.gym.gymmgmsys.dto.response.MemberResponse;
import com.gym.gymmgmsys.entity.Member;
import com.gym.gymmgmsys.entity.User;
import com.gym.gymmgmsys.mapper.MemberMapper;
import com.gym.gymmgmsys.repository.MemberRepository;
import com.gym.gymmgmsys.repository.UserRepository;
import com.gym.gymmgmsys.service.MemberService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {


    private final MemberRepository memberRepository;


    private final UserRepository userRepository;


    private final MemberMapper mapper;

    public MemberServiceImpl(MemberRepository memberRepository, UserRepository userRepository, MemberMapper mapper) {
        this.memberRepository = memberRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }


    @Override
    public MemberResponse create(
            Long userId,
            MemberRequest request
    ){


        User user =
                userRepository.findById(userId)
                        .orElseThrow();


        Member member =
                new Member();


        member.setUser(user);


        member.setAge(
                request.getAge()
        );


        member.setGender(
                request.getGender()
        );


        member.setHeight(
                request.getHeight()
        );


        member.setWeight(
                request.getWeight()
        );


        member.setAddress(
                request.getAddress()
        );


        member.setJoinDate(
                LocalDate.now()
        );


        return mapper.toResponse(
                memberRepository.save(member)
        );

    }





    @Override
    public MemberResponse getById(Long id){

        return memberRepository.findById(id)

                .map(mapper::toResponse)

                .orElseThrow();

    }





    @Override
    public List<MemberResponse> getAll(){

        return memberRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();

    }





    @Override
    public MemberResponse update(
            Long id,
            MemberRequest request
    ){


        Member member =
                memberRepository.findById(id)
                        .orElseThrow();



        member.setAge(
                request.getAge()
        );


        member.setGender(
                request.getGender()
        );


        member.setHeight(
                request.getHeight()
        );


        member.setWeight(
                request.getWeight()
        );


        member.setAddress(
                request.getAddress()
        );


        return mapper.toResponse(
                memberRepository.save(member)
        );

    }





    @Override
    public void delete(Long id){

        memberRepository.deleteById(id);

    }

}
