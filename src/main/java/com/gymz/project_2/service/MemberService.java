package com.gymz.project_2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gymz.project_2.domain.Member;
import com.gymz.project_2.repository.MemberRepository;

@Service
public class MemberService {
    public final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getAllMember() {
        return this.memberRepository.findAll();
    }

    public Member handleSaveMember(Member member) {
        return this.memberRepository.save(member);
    }

}