CREATE TABLE board(
board_id NUMBER PRIMARY KEY,
title varchar(20),
writer varchar(20),
content clob,
regdate DATE DEFAULT sysdate,
hit NUMBER DEFAULT 0
);

CREATE SEQUENCE seq_board
INCREMENT BY 1
START WITH 1;

SELECT * FROM BOARD;

DELETE FROM board WHERE BOARD_ID =2;


