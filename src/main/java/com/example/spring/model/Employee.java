package com.example.spring.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;


@Getter
@Setter
public class Employee {
    private Long id;
    @NotBlank(message = "姓名不能为空")

    private String name; //姓名
    private String gender; //性别
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday; //出生日期
    @Pattern(regexp = "(^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}$)", message = "身份证号码格式错误")
    private String idCard; //身份证号码
    private String wedlock; //婚姻状况
    @Email(message = "邮箱格式不正确")
    private String email; //电子邮箱
    @Pattern(regexp = "^(((\\+\\d{2}-)?0\\d{2,3}-\\d{7,8})|((\\+\\d{2}-)?(\\d{2,3}-)?(1[3-9]\\d{9})))$",message = "请输入正确的手机号")
    private String phone; //电话号码
    private String address; //联系地址
    private String nativePlace; //籍贯
    @JsonIgnore
    private Long nationId; //民族
    private Nation nation;
    @JsonIgnore
    private String nationName;
    @JsonIgnore
    private Long politicId; //政治面貌id
    @JsonIgnore
    private String politicName;
    private PoliticsStatus politicsStatus;
    @JsonIgnore
    private Long departmentId; //部门
    @JsonIgnore
    private String departmentName;
    private Department department;
    @JsonIgnore
    private Long jobLevelId; //职称
    @JsonIgnore
    private String jobLevelName;
    private JobLevel jobLevel;
    @JsonIgnore
    private Long posId; //职位
    private String posName;
    private Position position;
    private String engageForm; //聘用形式
    private String tiptopDegree; //最高学历
    private String specialty; //专业
    private String school; //毕业院校
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date beginDate; //入职日期
    private String workState;
    private String workID; //工号
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date conversionTime; //转正日期
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date notWorkDate;
    private Double contractTerm;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date beginContract; //合同起始日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date endContract; //合同终止日期
    @Range(max = 20)
    private Integer workAge; //工龄
    private Salary salary;

}
