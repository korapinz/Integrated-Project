use mydb;
delete from mydb.announces where announcementId=1;
delete from mydb.announces where announcementId=2;
delete from mydb.announces where announcementId=3;
delete from mydb.announces where announcementId=4;

delete from mydb.categories where categoryId=1;
delete from mydb.categories where categoryId=2;
delete from mydb.categories where categoryId=3;

INSERT INTO mydb.categories (categoryName) 
VALUES ('หางาน'),('ทุนการศึกษา'),('ทั่วไป');


INSERT INTO mydb.announces (announcementTitle, announcementDescription, publishDate, closeDate, announcementDisplay, categoryId) 
VALUES 
('บริษัท เน็ตเซอร์พลัส จำกัด รับสมัครงาน 2 ตำแหน่ง', 'บริษัท เน็ตเซอร์พลัส จำกัด เปิดรับสมัครงาน 2 ตำแหน่ง Application Support และ Customer Support', null, null, 'N', 1),
('รายชื่อนักศึกษาที่ได้รับทุนการศึกษาประเภท "ทุนจ้างงาน" 2/2565', 'คณะ ฯ ประกาศรายชื่อนักศึกษาที่ได้รับทุนการศึกษาประเภท "ทุนจ้างงาน" ประจำภาคการศึกษา 2/2565', null, '2566-05-31 11:00:00', 'Y', 2),
('แนวปฎิบัติการสอบออนไลน์ พ.ศ. 2565', 'ประกาศมหาวิทยาลัยเทคโนโลยีพระจอมเกล้าธนบุรี เรื่องแนวทางปฎิบัติการสอบออนไลน์ พ.ศ. 2565', '2566-01-26 23:00:00', null, 'Y', 3),
('กิจกรรมพี่อ้อย พี่ฉอด On Tour 2566', 'ขอเชิญนักศึกษาทุกชั้นปี เข้าร่วมกิจกรรมพี่อ้อย พี่ฉอด On Tour', '2566-04-18 23:00:00',  '2566-05-08 11:00:00', 'Y', 3);