create table t_LoginPage  
(    
     ID                          NUMBER(11)                      not null,
     
     ui_url                      VARCHAR(100), 
     text_url                    VARCHAR(300),
     value_url                   VARCHAR(300),      
     
     ui_username                 VARCHAR(100), 
     text_username               VARCHAR(300),
     value_username              VARCHAR(300),  
     
     ui_pwd                      VARCHAR(100), 
     text_pwd                    VARCHAR(300),
     value_pwd                   VARCHAR(300),
     
     ui_loginbtn                 VARCHAR(100), 
     text_loginbtn               VARCHAR(300),
     value_loginbtn              VARCHAR(300),  
     
     ui_result                   VARCHAR(100), 
     text_result                 VARCHAR(300),
     value_result                VARCHAR(300),     

     re_expected                 VARCHAR(300),
     re_actual                   VARCHAR(300),
     re_picture                  VARCHAR(500),
     re_option                   VARCHAR(10),
     re_memo                     VARCHAR(500),  
     constraint PK_t_LoginPage primary key (ID)
);

drop table t_LoginPage cascade constraints;

select * from t_LoginPage for update;

insert into t_LoginPage values(1,'By.linkText([参数])','登录','[click]','By.id([参数])','phone','','By.id([参数])','password_label','','By.id([参数])','next_btn','[click]','By.xpath([参数])','','[result]','','','','','用户名、密码为空');

select * from table_loginpage

//span[contains(text(),'您输入的用户名与密码不匹配！')]
//li[contains(text(),'，你好！')]



create table t_RegisterPage 
(    ID                    NUMBER(11)                      not null,
     ui_url                VARCHAR(100),              ----注册
     text_url              VARCHAR(300),
     value_url             VARCHAR(300),  
     
     ui_name                  VARCHAR(100),              ---注册：用户名
     text_name                VARCHAR(300),
     value_name               VARCHAR(300),
      
     ui_checkname             VARCHAR(100),              ---注册：用户名验证提示
     text_checkname           VARCHAR(300),
     value_checkname          VARCHAR(300), 
     
     ui_pwd                   VARCHAR(100),              ---注册：密码
     text_pwd                 VARCHAR(300),
     value_pwd                VARCHAR(300), 
     
     ui_checkpwd             VARCHAR(100),              ---注册：密码验证提示
     text_checkpwd           VARCHAR(300),
     value_checkpwd          VARCHAR(300),
     
     ui_repeatpwd             VARCHAR(100),              ---注册：重输入密码
     text_repeatpwd           VARCHAR(300),
     value_repeatpwd          VARCHAR(300),
     
     ui_checkrepeatpwd             VARCHAR(100),              ---注册：重输入密码验证提示
     text_checkrepeatpwd           VARCHAR(300),
     value_checkrepeatpwd          VARCHAR(300),
     
     ui_company             VARCHAR(100),              ---注册：公司名称
     text_company           VARCHAR(300),
     value_company          VARCHAR(300),   
     
     ui_checkcompany             VARCHAR(100),              ---注册：公司名称验证提示
     text_checkcompany           VARCHAR(300),
     value_checkcompany          VARCHAR(300),         
          
     ui_contactname             VARCHAR(100),              ---注册：联系人姓名
     text_contactname           VARCHAR(300),
     value_contactname          VARCHAR(300),    
     
     ui_checkcontactname             VARCHAR(100),              ---注册：联系人姓名验证提示
     text_checkcontactname          VARCHAR(300),
     value_checkcontactname         VARCHAR(300),  
     
     ui_prefixphone             VARCHAR(100),              ---注册：固话1
     text_prefixphone           VARCHAR(300),
     value_prefixphone          VARCHAR(300),    
     
     ui_checkprefixphone             VARCHAR(100),              ---注册：固话1验证提示
     text_checkprefixphone           VARCHAR(300),
     value_checkprefixphone          VARCHAR(300),      
     
     ui_fixphone             VARCHAR(100),              ---注册：固话2
     text_fixphone           VARCHAR(300),
     value_fixphone          VARCHAR(300),    
     
     ui_checkfixphone             VARCHAR(100),              ---注册：固话2验证提示
     text_checkfixphone           VARCHAR(300),
     value_checkfixphone          VARCHAR(300),  
     
     ui_mobile             VARCHAR(100),              ---注册：手机号
     text_mobile           VARCHAR(300),
     value_mobile          VARCHAR(300),    
     
     ui_checkmobile             VARCHAR(100),              ---注册：手机号验证提示
     text_checkmobile           VARCHAR(300),
     value_checkmobile          VARCHAR(300),  
     
     ui_validatecode             VARCHAR(100),              ---注册：手机号验证码
     text_validatecode           VARCHAR(300),
     value_validatecode          VARCHAR(300),  
     
     ui_checkvalidatecode             VARCHAR(100),              ---注册：手机号验证码验证提示
     text_checkvalidatecode           VARCHAR(300),
     value_checkvalidatecode          VARCHAR(300),  
     
     ui_validatecodebtn             VARCHAR(100),              ---注册：重新获取
     text_validatecodebtn           VARCHAR(300),
     value_validatecodebtn          VARCHAR(300),  
     
     ui_isagree             VARCHAR(100),              ---注册：阅读规则
     text_isagree           VARCHAR(300),
     value_isagree          VARCHAR(300), 
     
     ui_subtn             VARCHAR(100),              ---注册：提交
     text_subtn           VARCHAR(300),
     value_subtn          VARCHAR(300),  
     
     ui_subtnResult             VARCHAR(100),              ---注册：提交后结果
     text_subtnResult           VARCHAR(300),
     value_subtnResult          VARCHAR(300),  
     
     re_expected          VARCHAR(90),
     re_actual            VARCHAR(90),
     re_picture           VARCHAR(300),
     re_option            VARCHAR(4),
     re_memo              VARCHAR(300),  
     constraint PK_t_RegisterPage primary key (ID)
);

select * from t_LoginPage for update;
select * from t_RegisterPage for update;   

select * from table_RegisterPage;

select * from t_RegisterPage;

select * from t_MemberPage for update;



