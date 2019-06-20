--------------------------------------------------------
--  File created - Wednesday-June-19-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Procedure UPDATE_ADDRESS_DETAILS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "HR"."UPDATE_ADDRESS_DETAILS" 
(
  IN_ADDRESS_TYPE IN VARCHAR2 
, IN_AD_NUMBER IN NUMBER 
, IN_STREET IN VARCHAR2 
, IN_UNIT IN VARCHAR2 
, IN_CITY IN VARCHAR2 
, IN_STATE IN VARCHAR2 
, IN_ZIPCODE IN VARCHAR2 
, IN_ADDRESS_ID IN NUMBER,
RESPONSE_MSG OUT VARCHAR2
) AS 
max_id_lst_mdf_ts varchar2(20);
max_address_id number;
BEGIN
    select max(id_lst_mdf_ts) into max_id_lst_mdf_ts from identification;
    select contact_id into max_address_id from identification where id_lst_mdf_ts = max_id_lst_mdf_ts;
if in_address_id is null then 
    INSERT INTO Address(address_type, ad_number, street,unit,city,states,zipcode,ADDRESS_ID,ad_lst_mdf_ts)
    VALUES(IN_ADDRESS_TYPE,IN_AD_NUMBER,IN_STREET,IN_UNIT,IN_CITY,IN_STATE,IN_ZIPCODE,max_address_id,to_char(current_date,'DD-MM-YYYY HH:MM:SS'));
    commit;
    RESPONSE_MSG := 'Record inserted successfully';
else
  update Address
  set address_type=IN_ADDRESS_TYPE, ad_number=IN_AD_NUMBER, street=IN_STREET,unit=IN_UNIT,city=IN_CITY,states=IN_STATE,zipcode=IN_ZIPCODE,ad_lst_mdf_ts=to_char(current_date,'DD-MM-YYYY HH:MM:SS')
    where ADDRESS_ID = IN_ADDRESS_ID;
    commit;
    RESPONSE_MSG := 'Record updated successfully';
end if;
END UPDATE_ADDRESS_DETAILS;

/
--------------------------------------------------------
--  DDL for Procedure ADD_ID_DETAILS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "HR"."ADD_ID_DETAILS" 
(
  IN_CONTACT_ID IN NUMBER,
  IN_FIRST_NAME IN VARCHAR2, 
  IN_LAST_NAME IN VARCHAR2 ,
  IN_DATE_OF_BIRTH IN VARCHAR2,
  IN_GENDER IN VARCHAR2, 
  IN_TITLE IN VARCHAR2,
  RESPONSE_MSG OUT VARCHAR2
) AS 
BEGIN
if IN_CONTACT_ID is null then
    INSERT INTO identification(contact_id, first_name, last_name,date_of_birth,gender,title,id_lst_mdf_ts)
    VALUES(IDENTIFICATION_SEQ.nextval,IN_FIRST_NAME,IN_LAST_NAME,IN_DATE_OF_BIRTH,IN_GENDER,IN_TITLE,to_char(current_date,'DD-MM-YYYY HH:MM:SS'));
    commit;
    RESPONSE_MSG := 'Record inserted successfully';
    else
    INSERT INTO identification(contact_id, first_name, last_name,date_of_birth,gender,title,id_lst_mdf_ts)
    VALUES(IN_CONTACT_ID,IN_FIRST_NAME,IN_LAST_NAME,IN_DATE_OF_BIRTH,IN_GENDER,IN_TITLE,to_char(current_date,'DD-MM-YYYY HH:MM:SS'));
    commit;
    RESPONSE_MSG := 'Record inserted successfully';
end if;
END ADD_ID_DETAILS;

/
--------------------------------------------------------
--  DDL for Procedure ADD_ADDRESS_DETAILS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "HR"."ADD_ADDRESS_DETAILS" 
(
  IN_ADDRESS_TYPE IN VARCHAR2 
, IN_AD_NUMBER IN NUMBER 
, IN_STREET IN VARCHAR2 
, IN_UNIT IN VARCHAR2 
, IN_CITY IN VARCHAR2 
, IN_STATE IN VARCHAR2 
, IN_ZIPCODE IN VARCHAR2 
, IN_ADDRESS_ID IN NUMBER,
RESPONSE_MSG OUT VARCHAR2
) AS
max_id_lst_mdf_ts varchar2(20);
max_address_id number;
BEGIN
    select max(id_lst_mdf_ts) into max_id_lst_mdf_ts from identification;
    select contact_id into max_address_id from identification where id_lst_mdf_ts = max_id_lst_mdf_ts;    
    if in_address_id is null then 
    INSERT INTO Address(address_type, ad_number, street,unit,city,states,zipcode,ADDRESS_ID,ad_lst_mdf_ts)
    VALUES(IN_ADDRESS_TYPE,IN_AD_NUMBER,IN_STREET,IN_UNIT,IN_CITY,IN_STATE,IN_ZIPCODE,max_address_id,to_char(current_date,'DD-MM-YYYY HH:MM:SS'));
    commit;
    RESPONSE_MSG := 'Record inserted successfully';
    else
  INSERT INTO Address(address_type, ad_number, street,unit,city,states,zipcode,ADDRESS_ID,ad_lst_mdf_ts)
    VALUES(IN_ADDRESS_TYPE,IN_AD_NUMBER,IN_STREET,IN_UNIT,IN_CITY,IN_STATE,IN_ZIPCODE,IN_ADDRESS_ID,to_char(current_date,'DD-MM-YYYY HH:MM:SS'));
    RESPONSE_MSG := 'Record inserted successfully';
    commit;
     end if;
END ADD_ADDRESS_DETAILS;

/
--------------------------------------------------------
--  DDL for Procedure ADD_COMMUNICATION_DETAILS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "HR"."ADD_COMMUNICATION_DETAILS" 
(
  IN_COM_TYPE IN VARCHAR2 
, IN_VALUE IN VARCHAR2 
, IN_PREFERRED IN VARCHAR2 
, IN_COM_ID IN NUMBER,
RESPONSE_MSG OUT VARCHAR2
) AS 
max_id_lst_mdf_ts varchar2(20);
max_communication_id number;
BEGIN
    select max(id_lst_mdf_ts) into max_id_lst_mdf_ts from identification;
    select contact_id into max_communication_id from identification where id_lst_mdf_ts = max_id_lst_mdf_ts;
    if in_com_id is null then 
        INSERT INTO COMMUNICATION(COM_TYPE,VALUESS,PREFERRED,COM_ID,COM_LST_MDF_TS) 
        VALUES(IN_COM_TYPE,IN_VALUE,IN_PREFERRED,max_communication_id,to_char(current_date,'DD-MM-YYYY HH:MM:SS'));
        commit;
    RESPONSE_MSG := 'Record inserted successfully';
else
  INSERT INTO COMMUNICATION(COM_TYPE,VALUESS,PREFERRED,COM_ID,COM_LST_MDF_TS) 
  VALUES(IN_COM_TYPE,IN_VALUE,IN_PREFERRED,IN_COM_ID,to_char(current_date,'DD-MM-YYYY HH:MM:SS'));
    commit;
    RESPONSE_MSG := 'Record inserted successfully';
    end if;
END ADD_COMMUNICATION_DETAILS;

/
--------------------------------------------------------
--  DDL for Procedure UPDATE_COMMUNICATION_DETAILS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "HR"."UPDATE_COMMUNICATION_DETAILS" 
(
  IN_COM_TYPE IN VARCHAR2 
, IN_VALUE IN VARCHAR2 
, IN_PREFERRED IN VARCHAR2 
, IN_COM_ID IN NUMBER,
RESPONSE_MSG OUT VARCHAR2
) AS 
max_id_lst_mdf_ts varchar2(20);
max_communication_id number;
BEGIN
    select max(id_lst_mdf_ts) into max_id_lst_mdf_ts from identification;
    select contact_id into max_communication_id from identification where id_lst_mdf_ts = max_id_lst_mdf_ts;
    if in_com_id is null then 
        INSERT INTO COMMUNICATION(COM_TYPE,VALUESS,PREFERRED,COM_ID,COM_LST_MDF_TS) 
        VALUES(IN_COM_TYPE,IN_VALUE,IN_PREFERRED,max_communication_id,to_char(current_date,'DD-MM-YYYY HH:MM:SS'));
        commit;
    RESPONSE_MSG := 'Record inserted successfully';  
    else
        update COMMUNICATION
  set COM_TYPE=IN_COM_TYPE, VALUESS=IN_VALUE,PREFERRED=IN_PREFERRED,COM_LST_MDF_TS=to_char(current_date,'DD-MM-YYYY HH:MM:SS')
    where COM_ID = IN_COM_ID;
    commit;
    RESPONSE_MSG := 'Record updated successfully';
  end if;
END UPDATE_COMMUNICATION_DETAILS;

/
--------------------------------------------------------
--  DDL for Procedure UPDATE_ID_DETAILS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "HR"."UPDATE_ID_DETAILS" 
(
  IN_CONTACT_ID IN NUMBER,
  IN_FIRST_NAME IN VARCHAR2, 
  IN_LAST_NAME IN VARCHAR2 ,
  IN_DATE_OF_BIRTH IN VARCHAR2,
  IN_GENDER IN VARCHAR2, 
  IN_TITLE IN VARCHAR2,
  RESPONSE_MSG OUT VARCHAR2
) AS 
BEGIN
if IN_CONTACT_ID is null then
    INSERT INTO identification(contact_id, first_name, last_name,date_of_birth,gender,title,id_lst_mdf_ts)
    VALUES(IDENTIFICATION_SEQ.nextval,IN_FIRST_NAME,IN_LAST_NAME,IN_DATE_OF_BIRTH,IN_GENDER,IN_TITLE,to_char(current_date,'DD-MM-YYYY HH:MM:SS'));
    commit;
    RESPONSE_MSG := 'Record inserted successfully';
    else
    update identification
    set first_name=IN_FIRST_NAME,last_name=IN_LAST_NAME,date_of_birth=IN_DATE_OF_BIRTH,gender=IN_GENDER,title=IN_TITLE,id_lst_mdf_ts=to_char(current_date,'DD-MM-YYYY HH:MM:SS')   
    where contact_id = IN_CONTACT_ID;
    commit;
    RESPONSE_MSG := 'Record updated successfully';
end if;
END UPDATE_ID_DETAILS;

/
