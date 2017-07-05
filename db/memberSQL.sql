create table t_MemberPage  
(    
     ID                          NUMBER(11)                      not null,
     
     ui_url                      VARCHAR(100),          ----点击“账户中心”链接
     text_url                    VARCHAR(300),
     value_url                   VARCHAR(300),   
     
     ui_memberurl                VARCHAR(100),          ---申请“会员”链接
     text_memberurl              VARCHAR(300),
     value_memberurl             VARCHAR(300),         
     
     ui_contactName                 VARCHAR(100),       ---联系人
     text_contactName               VARCHAR(300),
     value_contactName              VARCHAR(300),  
     
     ui_checkcontactName                      VARCHAR(100),  ---check联系人
     text_checkcontactName                   VARCHAR(300),
     value_checkcontactName                   VARCHAR(300),     
     
     ui_companyName                      VARCHAR(100),  ---公司
     text_companyName                   VARCHAR(300),
     value_companyName                   VARCHAR(300),   
     
     ui_checkcompanyName                      VARCHAR(100),  ---check公司
     text_checkcompanyName                   VARCHAR(300),
     value_checkcompanyName                   VARCHAR(300), 
     
     ui_fixedTelphonePrefix                     VARCHAR(100),  ---公司区号
     text_fixedTelphonePrefix                   VARCHAR(300),
     value_fixedTelphonePrefix                  VARCHAR(300),   
     
     ui_checkfixedTelphonePrefix                      VARCHAR(100),  ---check公司区号
     text_checkfixedTelphonePrefix                   VARCHAR(300),
     value_checkfixedTelphonePrefix                   VARCHAR(300),
     
     ui_fixedTelphone                     VARCHAR(100),  ---公司固话
     text_fixedTelphone                   VARCHAR(300),
     value_fixedTelphone                  VARCHAR(300),   
     
     ui_checkfixedTelphone                      VARCHAR(100),  ---check公司固话
     text_checkfixedTelphone                   VARCHAR(300),
     value_checkfixedTelphone                   VARCHAR(300),

     ui_province                     VARCHAR(100),  ---所属省份
     text_province                   VARCHAR(300),
     value_province                  VARCHAR(300),  
      
     ui_city                     VARCHAR(100),  ---所属城市
     text_city                   VARCHAR(300),
     value_city                  VARCHAR(300), 
     
     ui_checkcity                      VARCHAR(100),  ---check所属城市
     text_checkcity                    VARCHAR(300),
     value_checkcity                   VARCHAR(300),     

     ui_companyAddress                    VARCHAR(100),  ---公司地址
     text_companyAddress                  VARCHAR(300),
     value_companyAddress                 VARCHAR(300), 

     ui_checkcompanyAddress                    VARCHAR(100),  ---check公司地址
     text_checkcompanyAddress                  VARCHAR(300),
     value_checkcompanyAddress                 VARCHAR(300), 


     ui_contactEmail                    VARCHAR(100),  ---联系邮箱
     text_contactEmail                  VARCHAR(300),
     value_contactEmail                 VARCHAR(300),      
     
     ui_department                    VARCHAR(100),  ---所在部门
     text_department                  VARCHAR(300),
     value_department                 VARCHAR(300),      
     
     ui_position                    VARCHAR(100),  ---职位
     text_position                  VARCHAR(300),
     value_position                 VARCHAR(300),      

     ui_companyIndustry                    VARCHAR(100),  ---行业
     text_companyIndustry                  VARCHAR(300),
     value_companyIndustry                VARCHAR(300),           
     
     ui_companyWebsite                    VARCHAR(100),  ---公司网址
     text_companyWebsite                  VARCHAR(300),
     value_companyWebsite                VARCHAR(300),  
     
     ui_bankNames                    VARCHAR(100),  ---银行名称
     text_bankNames                  VARCHAR(300),
     value_bankNames                VARCHAR(300),  
     
     ui_checkbankNames                    VARCHAR(100),  ---check银行名称
     text_checkbankNames                  VARCHAR(300),
     value_checkbankNames                 VARCHAR(300),     
     
     ui_subbranch                    VARCHAR(100),  ---开户行
     text_subbranch                  VARCHAR(300),
     value_subbranch                VARCHAR(300),      

     ui_checksubbranch                    VARCHAR(100),  ---check银行名称
     text_checksubbranch                  VARCHAR(300),
     value_checksubbranch                 VARCHAR(300),     

     ui_account                    VARCHAR(100),  ---开户卡号
     text_account                  VARCHAR(300),
     value_account                VARCHAR(300),

     ui_checkaccount                     VARCHAR(100),  ---check开户卡号
     text_checkaccount                   VARCHAR(300),
     value_checkaccount                  VARCHAR(300),     
               
     ui_btn                                  VARCHAR(100),  ---提交
     text_btn                   VARCHAR(300),
     value_btn                   VARCHAR(300), 
     
     

     re_expected                 VARCHAR(300),
     re_actual                   VARCHAR(300),
     re_picture                  VARCHAR(500),
     re_option                   VARCHAR(10),
     re_memo                     VARCHAR(500),  
     constraint PK_t_MemberPage primary key (ID)
);

drop table t_MemberPage cascade constraints;

1	1	By.id([参数])	000005	[click]	By.xpath([参数])	//a[@class='apply' and @href='/memberInfoForm']	[click]	By.id([参数])	contactName	[clear:text]:aaaa	By.xpath([参数])	//span[@class='error' and @for='contactName']	[result:text]:必选字段							By.id([参数])	next_btn	[click]					
									
select * from t_MemberPage;--账户中心>会员信息

select * from t_LoginPage;

select * from table_RegisterPage;

select * from t_MemberPage for update;   ----- //span[@class='error' and @for='username']    //a[@class='apply' and @href='/memberInfoForm']
                                                                                             //span[@class='error' and @for='fixedTelphonePrefix']
                                                                                             
                                       
update t_MemberPage t set t.ui_memberurl='By.xpath([参数])'  ;-----By.xpath([参数]) 


delete from  t_MemberPage t where t.id not in(1);                                                  
                                                                                             
[sendkey]:fdjfjj
