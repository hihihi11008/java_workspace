/*최상위 카테고리*/
CREATE TABLE topcategory(
	topcategory_id NUMBER
	,name varchar(25)
	,PRIMARY key(topcategory_id)
);

CREATE SEQUENCE seq_topcategory
INCREMENT BY 1
START WITH 1;

/*하위 카테고리*/
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


/*데이터 넣기 */
INSERT INTO TOPCATEGORY (TOPCATEGORY_ID,NAME) values(seq_topcategory.nextval,'상의');
INSERT INTO TOPCATEGORY (TOPCATEGORY_ID,NAME) values(seq_topcategory.nextval,'하의');
INSERT INTO TOPCATEGORY (TOPCATEGORY_ID,NAME) values(seq_topcategory.nextval,'악세서리');
INSERT INTO TOPCATEGORY (TOPCATEGORY_ID,NAME) values(seq_topcategory.nextval,'신발');

SELECT * FROM TOPCATEGORY;

INSERT INTO subcategory (subcategory_id,topcategory_id, name) values(seq_subcategory.nextval,1,'가디건');
insert into subcategory (subcategory_id,topcategory_id, name) values(seq_subcategory.nextval,1,'셔츠');
insert into subcategory (subcategory_id,topcategory_id, name) values(seq_subcategory.nextval,1,'티셔츠');
insert into subcategory (subcategory_id,topcategory_id, name) values(seq_subcategory.nextval,1,'니트');

insert into subcategory (subcategory_id,topcategory_id, name) values(seq_subcategory.nextval,2,'청바지');
insert into subcategory (subcategory_id,topcategory_id, name) values(seq_subcategory.nextval,2,'치마');
insert into subcategory (subcategory_id,topcategory_id, name) values(seq_subcategory.nextval,2,'면바지');
insert into subcategory (subcategory_id,topcategory_id, name) values(seq_subcategory.nextval,2,'슬랙스');

insert into subcategory (subcategory_id,topcategory_id, name) values(seq_subcategory.nextval,3,'귀걸이');
insert into subcategory (subcategory_id,topcategory_id, name) values(seq_subcategory.nextval,3,'팔찌');
insert into subcategory (subcategory_id,topcategory_id, name) values(seq_subcategory.nextval,3,'목걸이');
insert into subcategory (subcategory_id,topcategory_id, name) values(seq_subcategory.nextval,3,'반지');

insert into subcategory (subcategory_id,topcategory_id, name) values(seq_subcategory.nextval,4,'구두');
insert into subcategory (subcategory_id,topcategory_id, name) values(seq_subcategory.nextval,4,'샌들');
insert into subcategory (subcategory_id,topcategory_id, name) values(seq_subcategory.nextval,4,'슬리퍼');
insert into subcategory (subcategory_id,topcategory_id, name) values(seq_subcategory.nextval,4,'운동화');

SELECT * FROM SUBCATEGORY;

COMMIT;

COMMIT;

SELECT * FROM SUBCATEGORY WHERE TOPCATEGORY_ID =1;


