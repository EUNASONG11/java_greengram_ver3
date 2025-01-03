package com.green.greengramver.feed.model;

import com.green.greengramver.common.model.Paging;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.BindParam;

@Slf4j
@Getter
@ToString(callSuper = true) //부모 클래스의 필드들도 포함해서 toString() 메소드를 생성
public class FeedGetReq extends Paging {
    @Schema(title="로그인 유저 PK", name="signed_user_id", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private long signedUserId;

    @Schema(title="프로필 유저 PK", name="profile_user_id", example = "2", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Long profileUserId;

    //@ConstructorProperties({"page", "size", "signed_user_id"})
    public FeedGetReq(Integer page, Integer size, @BindParam("signed_user_id") long signedUserId, @BindParam("profile_user_id") Long profileUserId) {
        super(page, size);
        this.signedUserId = signedUserId;
        this.profileUserId = profileUserId;
    }
}
