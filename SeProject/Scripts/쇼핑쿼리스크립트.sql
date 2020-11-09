/*�ֻ��� ī�װ�*/
CREATE TABLE topcategory(
	topcategory_id NUMBER
	,name varchar(25)
	,PRIMARY key(topcategory_id)
);

CREATE SEQUENCE seq_topcategory
INCREMENT BY 1
START WITH 1;

/*���� ī�װ�*/
CREATE TABLE subcategory(
	subcategory_id NUMBER
	,topcategory_id number
	,name varchar(25)
	,PRIMARY key(subcategory_id)
	,CONSTRAINT fk_topcategory FOREIGN key(topcategory_id) 
		REFERENCES topcategory(topcategory_id)
);

CREATE SEQUENCE seq_subcategory
INCREMENT BY 1
START WITH 1;

CREATE TABLE product(
   product_id NUMBER,
   subcategory_id NUMBER,
   product_name varchar(30),
   band varchar(20),
   price NUMBER DEFAULT 0,
   filename varchar(20),
   PRIMARY KEY(product_id),
   CONSTRAINTS fk_subcategory FOREIGN KEY(subcategory_id)
   REFERENCES subcategory(subcategory_id)
);

CREATE SEQUENCE seq_product
INCREMENT BY 1
START WITH 1;


/*������ �ֱ� */
INSERT INTO TOPCATEGORY (TOPCATEGORY_ID,NAME) values(seq_topcategory.nextval,'����');
INSERT INTO TOPCATEGORY (TOPCATEGORY_ID,NAME) values(seq_topcategory.nextval,'����');
INSERT INTO TOPCATEGORY (TOPCATEGORY_ID,NAME) values(seq_topcategory.nextval,'�Ǽ�����');
INSERT INTO TOPCATEGORY (TOPCATEGORY_ID,NAME) values(seq_topcategory.nextval,'�Ź�');

SELECT * FROM TOPCATEGORY;

INSERT INTO subcategory (subcategory_id,topcategory_id, name) values(seq_subcategory.nextval,1,'�����');
insert into subcategory (subcategory_id,topcategory_id, name) values(seq_subcategory.nextval,1,'����');
insert into subcategory (subcategory_id,topcategory_id, name) values(seq_subcategory.nextval,1,'Ƽ����');
insert into subcategory (subcategory_id,topcategory_id, name) values(seq_subcategory.nextval,1,'��Ʈ');

insert into subcategory (subcategory_id,topcategory_id, name) values(seq_subcategory.nextval,2,'û����');
insert into subcategory (subcategory_id,topcategory_id, name) values(seq_subcategory.nextval,2,'ġ��');
insert into subcategory (subcategory_id,topcategory_id, name) values(seq_subcategory.nextval,2,'�����');
insert into subcategory (subcategory_id,topcategory_id, name) values(seq_subcategory.nextval,2,'������');

insert into subcategory (subcategory_id,topcategory_id, name) values(seq_subcategory.nextval,3,'�Ͱ���');
insert into subcategory (subcategory_id,topcategory_id, name) values(seq_subcategory.nextval,3,'����');
insert into subcategory (subcategory_id,topcategory_id, name) values(seq_subcategory.nextval,3,'�����');
insert into subcategory (subcategory_id,topcategory_id, name) values(seq_subcategory.nextval,3,'����');

insert into subcategory (subcategory_id,topcategory_id, name) values(seq_subcategory.nextval,4,'����');
insert into subcategory (subcategory_id,topcategory_id, name) values(seq_subcategory.nextval,4,'����');
insert into subcategory (subcategory_id,topcategory_id, name) values(seq_subcategory.nextval,4,'������');
insert into subcategory (subcategory_id,topcategory_id, name) values(seq_subcategory.nextval,4,'�ȭ');

SELECT * FROM SUBCATEGORY;

COMMIT;

COMMIT;

SELECT * FROM SUBCATEGORY WHERE TOPCATEGORY_ID =1;


