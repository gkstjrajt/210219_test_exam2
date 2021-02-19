INSERT INTO BOARD_TBL VALUES (BOARD_SEQ_IDX.NEXTVAL, '김회원', '정보처리 산업기사 쉽다', 'jsp 쉽네요', SYSDATE);
INSERT INTO BOARD_TBL VALUES (BOARD_SEQ_IDX.NEXTVAL, '김회원', '웹 디자인 기능사 어렵다', 'jquery 어렵네요', SYSDATE);
INSERT INTO BOARD_TBL VALUES (BOARD_SEQ_IDX.NEXTVAL, '이회원', '정보처리 산업기사 어렵다', 'jsp 어렵네요', SYSDATE);
INSERT INTO BOARD_TBL VALUES (BOARD_SEQ_IDX.NEXTVAL, '이회원', '정보처리 산업기사 쉽다', 'jquery 쉽네요', SYSDATE);
INSERT INTO BOARD_TBL VALUES (BOARD_SEQ_IDX.NEXTVAL, '박회원', 'ㅈㄱㄴ', '제목 그대로 내용', SYSDATE);
INSERT INTO BOARD_TBL VALUES (BOARD_SEQ_IDX.NEXTVAL, '박회원', '제목 그대로 내용', 'ㅈㄱㄴ', SYSDATE);
INSERT INTO BOARD_TBL VALUES (BOARD_SEQ_IDX.NEXTVAL, '강회원', '하드코딩하는 사람들', '가입하면 좋음', SYSDATE);
INSERT INTO BOARD_TBL VALUES (BOARD_SEQ_IDX.NEXTVAL, '나회원', 'git허브를 사용합시다', '신세계', SYSDATE);
INSERT INTO BOARD_TBL VALUES (BOARD_SEQ_IDX.NEXTVAL, '문회원', '노는 게 제일좋아', '모두들 모여라', SYSDATE);
INSERT INTO BOARD_TBL VALUES (BOARD_SEQ_IDX.NEXTVAL, '지회원', '여름아', '부탁해', SYSDATE);

SELECT * FROM BOARD_TBL;

INSERT INTO COMMENT_TBL VALUES (1, 1, '김회원', 'Lorem ipsum dolor sit amet', SYSDATE);
INSERT INTO COMMENT_TBL VALUES (2, 3, '김회원', 'consectetur adipiscing elit', SYSDATE);
INSERT INTO COMMENT_TBL VALUES (3, 5, '이회원', 'sed do eiusmod tempor', SYSDATE);
INSERT INTO COMMENT_TBL VALUES (4, 7, '이회원', 'incididunt ut labore et', SYSDATE);
INSERT INTO COMMENT_TBL VALUES (5, 9, '박회원', 'dolore magna aliqua', SYSDATE);
INSERT INTO COMMENT_TBL VALUES (6, 2, '박회원', 'minim veniam, quis nostrud', SYSDATE);
INSERT INTO COMMENT_TBL VALUES (7, 3, '강회원', 'exercitation ullamco laboris', SYSDATE);
INSERT INTO COMMENT_TBL VALUES (8, 5, '나회원', 'nisi ut aliquip ', SYSDATE);
INSERT INTO COMMENT_TBL VALUES (9, 7, '문회원', 'ex ea commodo consequat', SYSDATE);
INSERT INTO COMMENT_TBL VALUES (10, 2, '지회원', 'Duis aute irure dolor', SYSDATE);

SELECT * FROM COMMENT_TBL ORDER BY IDX;