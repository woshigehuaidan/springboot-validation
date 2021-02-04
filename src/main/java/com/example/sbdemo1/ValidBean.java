package com.example.sbdemo1;

import com.example.validation.ErrorCode;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

public class ValidBean {
    @NotBlank(message="用户名不能为空")
//    @ErrorCode(code = 1,type = NotBlank.class)
    @Length(max = 10,message = "名字长度不在范围之内")
//    @ErrorCode(code = 2,type = Length.class)
    private String name;
    @Range(max = 10,min = 5,message = "年龄不在范围之内")
//    @ErrorCode(code = 3,type = Range.class)
    @NotNull(message = "年龄不能为空")
//    @ErrorCode(code = 4,type = NotNull.class)
    private Integer age;
    @Email(message = "邮箱格式不对")
//    @ErrorCode(code = 5,type = Email.class)
    @NotBlank(message = "邮箱不能为空")
//    @ErrorCode(code = 6,type = NotBlank.class)
    private String emailnumber;
    @Pattern(regexp = "(^\\d{8}(0\\d|10|11|12)([0-2]\\d|30|31)\\d{3}$)|(^\\d{6}(18|19|20)\\d{2}(0[1-9]|10|11|12)([0-2]\\d|30|31)\\d{3}(\\d|X|x)$)",message = "不合法的身份证号码")
//    @ErrorCode(code = 7,type = Pattern.class)
    private String idNum;
    @Pattern(regexp = "^(?![a-zA-Z]+$)(?![A-Z0-9]+$)(?![A-Z\\W_]+$)(?![a-z0-9]+$)(?![a-z\\W_]+$)(?![0-9\\W_]+$)[a-zA-Z0-9\\W_]{8,16}$",message = "密码格式不符合")
//    @ErrorCode(code = 8,type = Pattern.class)
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmailnumber() {
        return emailnumber;
    }

    public void setEmailnumber(String emailnumber) {
        this.emailnumber = emailnumber;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
