-- calendar 테이블 추가
CREATE TABLE CALENDAR (
  _id VARCHAR(10), 
  title VARCHAR(30),
  description VARCHAR(100),
  start VARCHAR(20),
  end VARCHAR(20),
  type VARCHAR(20),
  username VARCHAR(20),
  backgroundColor VARCHAR(10),
  textColor VARCHAR(10),
  allDay VARCHAR(5)
);	