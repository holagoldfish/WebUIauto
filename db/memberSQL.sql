create table t_MemberPage  
(    
     ID                          NUMBER(11)                      not null,
     
     ui_url                      VARCHAR(100),          ----������˻����ġ�����
     text_url                    VARCHAR(300),
     value_url                   VARCHAR(300),   
     
     ui_memberurl                VARCHAR(100),          ---���롰��Ա������
     text_memberurl              VARCHAR(300),
     value_memberurl             VARCHAR(300),         
     
     ui_contactName                 VARCHAR(100),       ---��ϵ��
     text_contactName               VARCHAR(300),
     value_contactName              VARCHAR(300),  
     
     ui_checkcontactName                      VARCHAR(100),  ---check��ϵ��
     text_checkcontactName                   VARCHAR(300),
     value_checkcontactName                   VARCHAR(300),     
     
     ui_companyName                      VARCHAR(100),  ---��˾
     text_companyName                   VARCHAR(300),
     value_companyName                   VARCHAR(300),   
     
     ui_checkcompanyName                      VARCHAR(100),  ---check��˾
     text_checkcompanyName                   VARCHAR(300),
     value_checkcompanyName                   VARCHAR(300), 
     
     ui_fixedTelphonePrefix                     VARCHAR(100),  ---��˾����
     text_fixedTelphonePrefix                   VARCHAR(300),
     value_fixedTelphonePrefix                  VARCHAR(300),   
     
     ui_checkfixedTelphonePrefix                      VARCHAR(100),  ---check��˾����
     text_checkfixedTelphonePrefix                   VARCHAR(300),
     value_checkfixedTelphonePrefix                   VARCHAR(300),
     
     ui_fixedTelphone                     VARCHAR(100),  ---��˾�̻�
     text_fixedTelphone                   VARCHAR(300),
     value_fixedTelphone                  VARCHAR(300),   
     
     ui_checkfixedTelphone                      VARCHAR(100),  ---check��˾�̻�
     text_checkfixedTelphone                   VARCHAR(300),
     value_checkfixedTelphone                   VARCHAR(300),

     ui_province                     VARCHAR(100),  ---����ʡ��
     text_province                   VARCHAR(300),
     value_province                  VARCHAR(300),  
      
     ui_city                     VARCHAR(100),  ---��������
     text_city                   VARCHAR(300),
     value_city                  VARCHAR(300), 
     
     ui_checkcity                      VARCHAR(100),  ---check��������
     text_checkcity                    VARCHAR(300),
     value_checkcity                   VARCHAR(300),     

     ui_companyAddress                    VARCHAR(100),  ---��˾��ַ
     text_companyAddress                  VARCHAR(300),
     value_companyAddress                 VARCHAR(300), 

     ui_checkcompanyAddress                    VARCHAR(100),  ---check��˾��ַ
     text_checkcompanyAddress                  VARCHAR(300),
     value_checkcompanyAddress                 VARCHAR(300), 


     ui_contactEmail                    VARCHAR(100),  ---��ϵ����
     text_contactEmail                  VARCHAR(300),
     value_contactEmail                 VARCHAR(300),      
     
     ui_department                    VARCHAR(100),  ---���ڲ���
     text_department                  VARCHAR(300),
     value_department                 VARCHAR(300),      
     
     ui_position                    VARCHAR(100),  ---ְλ
     text_position                  VARCHAR(300),
     value_position                 VARCHAR(300),      

     ui_companyIndustry                    VARCHAR(100),  ---��ҵ
     text_companyIndustry                  VARCHAR(300),
     value_companyIndustry                VARCHAR(300),           
     
     ui_companyWebsite                    VARCHAR(100),  ---��˾��ַ
     text_companyWebsite                  VARCHAR(300),
     value_companyWebsite                VARCHAR(300),  
     
     ui_bankNames                    VARCHAR(100),  ---��������
     text_bankNames                  VARCHAR(300),
     value_bankNames                VARCHAR(300),  
     
     ui_checkbankNames                    VARCHAR(100),  ---check��������
     text_checkbankNames                  VARCHAR(300),
     value_checkbankNames                 VARCHAR(300),     
     
     ui_subbranch                    VARCHAR(100),  ---������
     text_subbranch                  VARCHAR(300),
     value_subbranch                VARCHAR(300),      

     ui_checksubbranch                    VARCHAR(100),  ---check��������
     text_checksubbranch                  VARCHAR(300),
     value_checksubbranch                 VARCHAR(300),     

     ui_account                    VARCHAR(100),  ---��������
     text_account                  VARCHAR(300),
     value_account                VARCHAR(300),

     ui_checkaccount                     VARCHAR(100),  ---check��������
     text_checkaccount                   VARCHAR(300),
     value_checkaccount                  VARCHAR(300),     
               
     ui_btn                                  VARCHAR(100),  ---�ύ
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

1	1	By.id([����])	000005	[click]	By.xpath([����])	//a[@class='apply' and @href='/memberInfoForm']	[click]	By.id([����])	contactName	[clear:text]:aaaa	By.xpath([����])	//span[@class='error' and @for='contactName']	[result:text]:��ѡ�ֶ�							By.id([����])	next_btn	[click]					
									
select * from t_MemberPage;--�˻�����>��Ա��Ϣ

select * from t_LoginPage;

select * from table_RegisterPage;

select * from t_MemberPage for update;   ----- //span[@class='error' and @for='username']    //a[@class='apply' and @href='/memberInfoForm']
                                                                                             //span[@class='error' and @for='fixedTelphonePrefix']
                                                                                             
                                       
update t_MemberPage t set t.ui_memberurl='By.xpath([����])'  ;-----By.xpath([����]) 


delete from  t_MemberPage t where t.id not in(1);                                                  
                                                                                             
[sendkey]:fdjfjj
