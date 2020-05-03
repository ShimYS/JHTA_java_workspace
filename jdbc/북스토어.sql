
/* Drop Indexes */

DROP INDEX LIKES_UK;
DROP INDEX REVIEWS_UK;



/* Drop Tables */

DROP TABLE HR.SAMPLE_BOOK_LIKES CASCADE CONSTRAINTS;
DROP TABLE HR.SAMPLE_BOOK_ORDER CASCADE CONSTRAINTS;
DROP TABLE HR.SAMPLE_BOOK_REVIEWS CASCADE CONSTRAINTS;
DROP TABLE HR.SAMPLE_BOOKS CASCADE CONSTRAINTS;
DROP TABLE HR.SAMPLE_BOOK_ANSWERS CASCADE CONSTRAINTS;
DROP TABLE HR.SAMPLE_BOOK_QUESTIONS CASCADE CONSTRAINTS;
DROP TABLE HR.SAMPLE_BOOK_USERS CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE HR.SAMPLE_BOOKS
(
	BOOK_NO number(6) NOT NULL,
	BOOK_TITLE varchar2(500 char) NOT NULL,
	BOOK_WRITER varchar2(200 char) NOT NULL,
	BOOK_GENRE varchar2(200 char) NOT NULL,
	BOOK_PUBLISHER varchar2(200 char) NOT NULL,
	BOOK_PRICE number(7,0) NOT NULL,
	BOOK_DISCOUNT_PRICE number(7,0) NOT NULL,
	BOOK_REGISTERED_DATE date DEFAULT sysdate ,
	BOOK_STOCK number(5,0) DEFAULT 100 ,
	BOOK_POINT number(2,1) DEFAULT 0 ,
	BOOK_LIKE number(7,0) DEFAULT 0 ,
	CONSTRAINT SYS_C007028 PRIMARY KEY (BOOK_NO)
);


CREATE TABLE HR.SAMPLE_BOOK_ANSWERS
(
	ANSWER_NO number(7,0) NOT NULL,
	ANSWER_CONTENT varchar2(4000 char) NOT NULL,
	ANSWER_REGISTERED_DATE date DEFAULT sysdate,
	QUESTION_NO number(7,0) UNIQUE,
	CONSTRAINT SYS_C007059 PRIMARY KEY (ANSWER_NO)
);


CREATE TABLE HR.SAMPLE_BOOK_LIKES
(
	BOOK_NO number(6) NOT NULL,
	USER_ID varchar2(50 char) NOT NULL
);


CREATE TABLE HR.SAMPLE_BOOK_ORDER
(
	ORDER_NO number(6) NOT NULL,
	USER_ID varchar2(50 char) NOT NULL,
	BOOK_NO number(6) NOT NULL,
	ORDER_PRICE number(7,0),
	ORDER_AMOUNT number(3,0),
	ORDER_REGISTERED_DATE date DEFAULT sysdate ,
	CONSTRAINT SYS_C007033 PRIMARY KEY (ORDER_NO)
);


CREATE TABLE HR.SAMPLE_BOOK_QUESTIONS
(
	QUESTION_NO number(7,0) NOT NULL,
	QUESTION_TITLE varchar2(500 char) NOT NULL,
	USER_ID varchar2(50 char),
	QUESTION_CONTENT varchar2(4000 char) NOT NULL,
	QUESTION_VIEW_COUNT number(7,0) DEFAULT 0,
	QUESTION_REGISTERED_DATE date DEFAULT sysdate,
	QUESTION_STATUS char(1 char) DEFAULT '''N''',
	QUESTION_TYPE varchar2(200 char) NOT NULL,
	CONSTRAINT SYS_C007056 PRIMARY KEY (QUESTION_NO)
);


CREATE TABLE HR.SAMPLE_BOOK_REVIEWS
(
	REVIEW_NO number(7,0) NOT NULL,
	REVIEW_CONTENT varchar2(2000 char) NOT NULL,
	REVIEW_POINT number(1),
	REVIEW_REGISTERED_DATE date DEFAULT SYSDATE,
	BOOK_NO number(6),
	USER_ID varchar2(50 char),
	CONSTRAINT REVIEW_NO_PK PRIMARY KEY (REVIEW_NO)
);


CREATE TABLE HR.SAMPLE_BOOK_USERS
(
	USER_ID varchar2(50 char) NOT NULL,
	USER_PASSWORD varchar2(50 char) NOT NULL,
	USER_NAME varchar2(100 char) NOT NULL,
	USER_EMAIL varchar2(256 char),
	USER_POINT number(10,0) DEFAULT 0 ,
	USER_REGISTERED_DATE date DEFAULT sysdate ,
	CONSTRAINT SYS_C007032 PRIMARY KEY (USER_ID)
);



/* Create Foreign Keys */

ALTER TABLE HR.SAMPLE_BOOK_LIKES
	ADD CONSTRAINT LIKES_BOOKNO_FK FOREIGN KEY (BOOK_NO)
	REFERENCES HR.SAMPLE_BOOKS (BOOK_NO)
;


ALTER TABLE HR.SAMPLE_BOOK_ORDER
	ADD CONSTRAINT SYS_C007035 FOREIGN KEY (BOOK_NO)
	REFERENCES HR.SAMPLE_BOOKS (BOOK_NO)
;


ALTER TABLE HR.SAMPLE_BOOK_REVIEWS
	ADD CONSTRAINT REVIEW_BOOKNO_FK FOREIGN KEY (BOOK_NO)
	REFERENCES HR.SAMPLE_BOOKS (BOOK_NO)
;


ALTER TABLE HR.SAMPLE_BOOK_ANSWERS
	ADD CONSTRAINT SYS_C007060 FOREIGN KEY (QUESTION_NO)
	REFERENCES HR.SAMPLE_BOOK_QUESTIONS (QUESTION_NO)
;


ALTER TABLE HR.SAMPLE_BOOK_LIKES
	ADD CONSTRAINT LIKES_USERID_FK FOREIGN KEY (USER_ID)
	REFERENCES HR.SAMPLE_BOOK_USERS (USER_ID)
;


ALTER TABLE HR.SAMPLE_BOOK_ORDER
	ADD CONSTRAINT SYS_C007034 FOREIGN KEY (USER_ID)
	REFERENCES HR.SAMPLE_BOOK_USERS (USER_ID)
;


ALTER TABLE HR.SAMPLE_BOOK_QUESTIONS
	ADD CONSTRAINT SYS_C007057 FOREIGN KEY (USER_ID)
	REFERENCES HR.SAMPLE_BOOK_USERS (USER_ID)
;


ALTER TABLE HR.SAMPLE_BOOK_REVIEWS
	ADD CONSTRAINT REVIEW_USERID_FK FOREIGN KEY (USER_ID)
	REFERENCES HR.SAMPLE_BOOK_USERS (USER_ID)
;



/* Create Indexes */

CREATE UNIQUE INDEX LIKES_UK ON HR.SAMPLE_BOOK_LIKES (BOOK_NO, USER_ID);
CREATE UNIQUE INDEX REVIEWS_UK ON HR.SAMPLE_BOOK_REVIEWS (BOOK_NO, USER_ID);



