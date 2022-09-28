package com.web.happyhouse.user.controller;

import com.web.happyhouse.login.dto.LoginRq;
import com.web.happyhouse.network.ResponseCode;
import com.web.happyhouse.network.ResponseDto;
import com.web.happyhouse.user.dto.UserRs;
import com.web.happyhouse.user.dto.UserUpdateNameRq;
import com.web.happyhouse.user.dto.UserUpdatePasswordRq;
import com.web.happyhouse.user.service.UserService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags ={"User 관리 Controller"})
@RestController
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('USER','AGENT','ADMIN')")
public class UserController {

    private final UserService userService;

    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "Authorization",
                    value = "로그인 성공 후 AccessToken",
                    required = true, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "현재 로그인된 User 조회 (인증정보)", notes="인증정보로 User 조회하기")
    @GetMapping("/user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK 회원조회를 성공했습니다."),
            @ApiResponse(code = 400, message = "BAD_REQUEST 유저찾기를 실패했습니다."),
            @ApiResponse(code = 401, message = "UNAUTHORIZED 잘못된 접근입니다."),
            @ApiResponse(code = 403, message = "FORBIDDEN 권한이 없습니다."),
    })
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto<UserRs> getMyUserInfo() {
        return ResponseDto.res(ResponseCode.OK, "회원조회를 성공했습니다.", userService.getMyUserWithAuthorities());
    }

    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "Authorization",
                    value = "로그인 성공 후 AccessToken",
                    required = true, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "User 조회 (아이디)", notes="userId로 User 조회하기")
    @GetMapping("/user/id/{userId}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK 회원조회를 성공했습니다."),
            @ApiResponse(code = 400, message = "BAD_REQUEST 유저찾기를 실패했습니다."),
            @ApiResponse(code = 401, message = "UNAUTHORIZED 잘못된 접근입니다."),
            @ApiResponse(code = 403, message = "FORBIDDEN 권한이 없습니다."),
    })
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto<UserRs> get(@PathVariable("userId") Long userId){
        return ResponseDto.res(ResponseCode.OK, "회원조회를 성공했습니다.", userService.getById(userId));
    }

    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "Authorization",
                    value = "로그인 성공 후 AccessToken",
                    required = true, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "User 조회 (이메일)", notes="email로 User 조회하기")
    @GetMapping("/user/email/{email}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK 회원조회를 성공했습니다."),
            @ApiResponse(code = 400, message = "BAD_REQUEST 유저찾기를 실패했습니다."),
            @ApiResponse(code = 401, message = "UNAUTHORIZED 잘못된 접근입니다."),
            @ApiResponse(code = 403, message = "FORBIDDEN 권한이 없습니다."),
    })
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto<UserRs> get(@PathVariable("email") String email){
        return ResponseDto.res(ResponseCode.OK, "회원조회를 성공했습니다.", userService.getByEmail(email));
    }

    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "Authorization",
                    value = "로그인 성공 후 AccessToken",
                    required = true, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "User 비밀번호 수정", notes="User 정보수정하기(비밀번호)")
    @PatchMapping("/user-password")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK 회원정보 업데이트를 성공했습니다."),
            @ApiResponse(code = 400, message = "BAD_REQUEST 유저찾기를 실패했습니다."),
            @ApiResponse(code = 401, message = "UNAUTHORIZED 잘못된 접근입니다."),
            @ApiResponse(code = 403, message = "FORBIDDEN 권한이 없습니다."),
            @ApiResponse(code = 409, message = "CONFLICT 비밀번호가 맞지 않습니다."),
    })
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto<Long> updatePassword(@Valid @RequestBody UserUpdatePasswordRq updateRq) {
        Long updateId = userService.updatePassword(updateRq);
        return ResponseDto.res(ResponseCode.OK, "회원정보 업데이트를 성공했습니다.", updateId);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "Authorization",
                    value = "로그인 성공 후 AccessToken",
                    required = true, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "User 이름 수정", notes="User 정보수정하기(이름)")
    @PatchMapping("/user-name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK 회원정보 업데이트를 성공했습니다."),
            @ApiResponse(code = 400, message = "BAD_REQUEST 유저찾기를 실패했습니다."),
            @ApiResponse(code = 401, message = "UNAUTHORIZED 잘못된 접근입니다."),
            @ApiResponse(code = 403, message = "FORBIDDEN 권한이 없습니다."),
    })
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto<Long> updateName(@Valid @RequestBody UserUpdateNameRq updateRq) {
        Long updateId = userService.updateName(updateRq);
        return ResponseDto.res(ResponseCode.OK, "회원정보 업데이트를 성공했습니다.", updateId);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "Authorization",
                    value = "로그인 성공 후 AccessToken",
                    required = true, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "User 탈퇴", notes="User 탈퇴하기")
    @DeleteMapping("/user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK 회원탈퇴를 완료했습니다."),
            @ApiResponse(code = 401, message = "UNAUTHORIZED 잘못된 접근입니다."),
            @ApiResponse(code = 403, message = "FORBIDDEN 권한이 없습니다."),
            @ApiResponse(code = 409, message = "CONFLICT 비밀번호가 맞지 않습니다."),
    })
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto delete(@Valid @RequestBody LoginRq loginRq) {
        userService.delete(loginRq.getEmail(), loginRq.getPassword());
        return ResponseDto.res(ResponseCode.OK, "회원탈퇴를 완료했습니다.");
    }
}
