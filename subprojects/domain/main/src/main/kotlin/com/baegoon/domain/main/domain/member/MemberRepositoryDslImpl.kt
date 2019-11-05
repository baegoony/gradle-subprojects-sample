package com.baegoon.domain.main.domain.member

import com.baegoon.domain.main.domain.member.QMember.member
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
class MemberRepositoryDslImpl : MemberRepositoryDsl, QuerydslRepositorySupport(Member::class.java) {

    override fun findAllBasic(): List<Member> {
        return this.from(member)
            .where(
                member.memberType.eq(MemberType.BASIC),
                member.gender.`in`(MemberGender.MALE, MemberGender.FEMALE)
            )
            .fetch()
    }
}
