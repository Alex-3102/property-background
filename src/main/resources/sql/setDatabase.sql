CREATE DATABASE IF NOT EXISTS property CHARSET SET UTF8;
USE property;

CREATE TABLE user (
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    role INT NOT NULL COMMENT '业主是1,物业是2',
    phone_number VARCHAR(20) NOT NULL COMMENT '手机号',
    image_path VARCHAR(100) DEFAULT '/root/web/photo/default.jpg',
    PRIMARY KEY (id)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE repair_record (
  id INT NOT NULL AUTO_INCREMENT COMMENT '唯一编号',
  user_id INT NOT NULL COMMENT '外键关联user表',
  contact_person VARCHAR(30) DEFAULT '' COMMENT '联系人',
  date DATE NOT NULL COMMENT '日期',
  details VARCHAR(420) NOT NULL COMMENT '详情',
  status int NOT NULL COMMENT '状态',
  phone_number VARCHAR(20) NOT NULL COMMENT '手机号',
  address VARCHAR(20) NOT NULL COMMENT '单元楼及门牌号',
  PRIMARY KEY (id),
  FOREIGN KEY(user_id) REFERENCES user(id)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE door_record(
    id INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL COMMENT '外键关联user表',
    date DATE NOT NULL,
    name VARCHAR(20) NOT NULL,
    sex VARCHAR(5) NOT NULL,
    num VARCHAR(20),
    id_card VARCHAR(30),
    PRIMARY KEY(id),
    FOREIGN KEY(user_id) REFERENCES user(id)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE PaymentRecord(
    id INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL COMMENT '外键关联user表',
    date DATE NOT NULL,
    price INT NOT NULL DEFAULT 0,
    type INT NOT NULL COMMENT '1为天然气，2为物业，3为水费，4为宽带费，5为电费',
    PRIMARY KEY(id),
    FOREIGN KEY(user_id) REFERENCES user(id)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE notice(
    `id` INT NOT NULL AUTO_INCREMENT,
    `user_id` INT NOT NULL COMMENT '外键关联user表',
    `title` VARCHAR(60) NOT NULL COMMENT '标题',
    `desc` VARCHAR(512),
    `date` DATE,
    PRIMARY KEY(id),
    FOREIGN KEY(user_id) REFERENCES user(id)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE announcement(
    `id` INT NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(128),
    `date` DATE,
    `ano` VARCHAR(1024),
    PRIMARY KEY(id)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE activity(
    `id` int NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(42) NOT NULL,
    `address` VARCHAR(60),
    `location` VARCHAR(256),
    `business_hours` VARCHAR(128),
    `people_number` VARCHAR(128),
    `attention` VARCHAR(1024),
    `image_path` VARCHAR(128),
    `type` int comment '1是文化，2是体育',
    primary key(id)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

drop table notice;
drop table repair_record;
drop table door_record;
drop table PaymentRecord;
drop table user;

insert into user(username, password, role, phone_number) values ('admin', '123456', 1, '13145229277');
insert into user(username, password, role, phone_number) values ('user', '123456', 1, '13669482228');
insert into activity(`title`, `address`, `location`, `business_hours`, `people_number`, `attention`, `image_path`, `type`) values ('广州购书中心', '广州市天河路', '中国广东省广州市天河路123号', '10:00-21:30', '不限','1.提前一天预约，不可当日预约。如有恶意预约者，后台将取消该预约; &2.进入中心时须全程戴口罩，自觉出示“随申码”(绿色），出示身份证进行实名登记; &3.为保护您与他人的健康，请勿在整点集中进入中心，尽可能分散时间段进入;在中心期间请与其他人相互之间保持1米以上的安全距离; &4.遵守中心规章制度，配合工作人员管理，营造共同防疫、共享文化的良好氛围。', '/root/web/photo/activity1.jpg', 1);
insert into activity(`title`, `address`, `location`, `business_hours`, `people_number`, `attention`, `image_path`, `type`) values ('广州图书馆南馆', '广州市珠江新城', '中国广东省广州市珠江东路4号', '9:00-21:00', '不限','1.提前一天预约，不可当日预约。如有恶意预约者，后台将取消该预约; &2.进入中心时须全程戴口罩，自觉出示“随申码”(绿色），出示身份证进行实名登记; &3.为保护您与他人的健康，请勿在整点集中进入中心，尽可能分散时间段进入;在中心期间请与其他人相互之间保持1米以上的安全距离; &4.遵守中心规章制度，配合工作人员管理，营造共同防疫、共享文化的良好氛围。', '/root/web/photo/activity2.jpg', 1);
insert into activity(`title`, `address`, `location`, `business_hours`, `people_number`, `attention`, `image_path`, `type`) values ('西汉南越王博物馆', '广州市解放北路', '中国广东省广州市解放北路867号', '9:00-21:00', '不限','1.提前一天预约，不可当日预约。如有恶意预约者，后台将取消该预约; &2.进入中心时须全程戴口罩，自觉出示“随申码”(绿色），出示身份证进行实名登记; &3.为保护您与他人的健康，请勿在整点集中进入中心，尽可能分散时间段进入;在中心期间请与其他人相互之间保持1米以上的安全距离; &4.遵守中心规章制度，配合工作人员管理，营造共同防疫、共享文化的良好氛围。', '/root/web/photo/activity3.jpg', 1);
insert into activity(`title`, `address`, `location`, `business_hours`, `people_number`, `attention`, `image_path`, `type`) values ('广东省博物馆', '广州市珠江新城', '中国广东省广州市天河区珠江新城珠江东路2号', '9:00-17:00', '5000人','1.提前一天预约，不可当日预约。如有恶意预约者，后台将取消该预约; &2.进入中心时须全程戴口罩，自觉出示“随申码”(绿色），出示身份证进行实名登记; &3.为保护您与他人的健康，请勿在整点集中进入中心，尽可能分散时间段进入;在中心期间请与其他人相互之间保持1米以上的安全距离; &4.遵守中心规章制度，配合工作人员管理，营造共同防疫、共享文化的良好氛围。', '/root/web/photo/activity4.jpg', 1);
insert into activity(`title`, `address`, `location`, `business_hours`, `people_number`, `attention`, `image_path`, `type`) values ('广州中山纪念堂', '广州市东风中路', '中国广东省广州市越秀区东风中路299号', '8:30-18:30', '2000人','1.提前一天预约，不可当日预约。如有恶意预约者，后台将取消该预约; &2.进入中心时须全程戴口罩，自觉出示“随申码”(绿色），出示身份证进行实名登记; &3.为保护您与他人的健康，请勿在整点集中进入中心，尽可能分散时间段进入;在中心期间请与其他人相互之间保持1米以上的安全距离; &4.遵守中心规章制度，配合工作人员管理，营造共同防疫、共享文化的良好氛围。', '/root/web/photo/activity5.jpg', 1);
insert into activity(`title`, `address`, `location`, `business_hours`, `people_number`, `attention`, `image_path`, `type`) values ('广州陈家祠', '广州市中山七路', '中国广东省广州市荔湾区中山七路恩龙里34号', '8:30-17:00', '1000人','1.提前一天预约，不可当日预约。如有恶意预约者，后台将取消该预约; &2.进入中心时须全程戴口罩，自觉出示“随申码”(绿色），出示身份证进行实名登记; &3.为保护您与他人的健康，请勿在整点集中进入中心，尽可能分散时间段进入;在中心期间请与其他人相互之间保持1米以上的安全距离; &4.遵守中心规章制度，配合工作人员管理，营造共同防疫、共享文化的良好氛围。', '/root/web/photo/activity6.jpg', 1);

insert into activity(`title`, `address`, `location`, `business_hours`, `people_number`, `attention`, `image_path`, `type`) values ('广州天河体育中心', '广州市天河路', '中国广东省广州市天河区天河路299号', '6:00-22:00', '1000人','1.提前一天预约，不可当日预约。如有恶意预约者，后台将取消该预约; &2.进入中心时须全程戴口罩，自觉出示“随申码”(绿色），出示身份证进行实名登记; &3.为保护您与他人的健康，请勿在整点集中进入中心，尽可能分散时间段进入;在中心期间请与其他人相互之间保持1米以上的安全距离; &4.遵守中心规章制度，配合工作人员管理，营造共同防疫、共享文化的良好氛围。', '/root/web/photo/pe_activity1.jpg', 2);
insert into activity(`title`, `address`, `location`, `business_hours`, `people_number`, `attention`, `image_path`, `type`) values ('广州体育馆', '广州市白云大道', '中国广东省广州市白云区白云大道南783号', '9:00-21:00', '2000人','1.提前一天预约，不可当日预约。如有恶意预约者，后台将取消该预约; &2.进入中心时须全程戴口罩，自觉出示“随申码”(绿色），出示身份证进行实名登记; &3.为保护您与他人的健康，请勿在整点集中进入中心，尽可能分散时间段进入;在中心期间请与其他人相互之间保持1米以上的安全距离; &4.遵守中心规章制度，配合工作人员管理，营造共同防疫、共享文化的良好氛围。', '/root/web/photo/pe_activity2.jpg', 2);
insert into activity(`title`, `address`, `location`, `business_hours`, `people_number`, `attention`, `image_path`, `type`) values ('广东奥林匹克体育中心', '广州市黄埔大道', '中国广东省广州市天河区东圃奥体路818号', '9:00-22:00', '3000人','1.提前一天预约，不可当日预约。如有恶意预约者，后台将取消该预约; &2.进入中心时须全程戴口罩，自觉出示“随申码”(绿色），出示身份证进行实名登记; &3.为保护您与他人的健康，请勿在整点集中进入中心，尽可能分散时间段进入;在中心期间请与其他人相互之间保持1米以上的安全距离; &4.遵守中心规章制度，配合工作人员管理，营造共同防疫、共享文化的良好氛围。', '/root/web/photo/pe_activity3.jpg', 2);
insert into activity(`title`, `address`, `location`, `business_hours`, `people_number`, `attention`, `image_path`, `type`) values ('广州亚运城综合体育馆', '广州市兴亚大道', '中国广东省广州市番禺区兴亚大道33号', '9:00-21:30', '2000人','1.提前一天预约，不可当日预约。如有恶意预约者，后台将取消该预约; &2.进入中心时须全程戴口罩，自觉出示“随申码”(绿色），出示身份证进行实名登记; &3.为保护您与他人的健康，请勿在整点集中进入中心，尽可能分散时间段进入;在中心期间请与其他人相互之间保持1米以上的安全距离; &4.遵守中心规章制度，配合工作人员管理，营造共同防疫、共享文化的良好氛围。', '/root/web/photo/pe_activity4.jpg', 2);
insert into activity(`title`, `address`, `location`, `business_hours`, `people_number`, `attention`, `image_path`, `type`) values ('广州大学城体育中心', '广州市番禺区大学城内', '中国广东省广州市番禺区兴亚大道33号', '9:30-17:30', '1000人','1.提前一天预约，不可当日预约。如有恶意预约者，后台将取消该预约; &2.进入中心时须全程戴口罩，自觉出示“随申码”(绿色），出示身份证进行实名登记; &3.为保护您与他人的健康，请勿在整点集中进入中心，尽可能分散时间段进入;在中心期间请与其他人相互之间保持1米以上的安全距离; &4.遵守中心规章制度，配合工作人员管理，营造共同防疫、共享文化的良好氛围。', '/root/web/photo/pe_activity5.jpg', 2);
insert into activity(`title`, `address`, `location`, `business_hours`, `people_number`, `attention`, `image_path`, `type`) values ('广州荔湖高尔夫球会', '广州市增城区新新四路', '中国广东省广州市增城区新新四路23号', '6:00-19:00', '500人','1.提前一天预约，不可当日预约。如有恶意预约者，后台将取消该预约; &2.进入中心时须全程戴口罩，自觉出示“随申码”(绿色），出示身份证进行实名登记; &3.为保护您与他人的健康，请勿在整点集中进入中心，尽可能分散时间段进入;在中心期间请与其他人相互之间保持1米以上的安全距离; &4.遵守中心规章制度，配合工作人员管理，营造共同防疫、共享文化的良好氛围。', '/root/web/photo/pe_activity6.jpg', 2);

insert into announcement(`title`, `date`, `ano`) values ('双十一超市活动', '2020-11-5', '尊敬的业主：你们好，双十一超市最低3折起，赶快来抢购吧！');
insert into announcement(`title`, `date`, `ano`) values ('物业收费公告【1201】', '2020-12-01', '尊敬的业主，您好！物业管理处收缴物业费的工作正在展开，物业费是小区维护正常秩序、环境卫生、公共配套设施维护服务的根本保证。如果物业费不能按时缴纳，将会对物业服务工作造成不利影响，同时也侵犯了已交费业主的利益。因此，请还未缴纳物业费的业主尽快到物业处缴纳。');
insert into announcement(`title`, `date`, `ano`) values ('服务平台上线啦！！！', '2020-12-01', '本可向物业行业、公共停车场、社区等场所提供：智慧社区服务、小区电商、智能停车场、智能充电桩、云可视对讲系统等服务，为社区管理者提供了统一接入管理平台，所有数据、功能均可统一管理，无需开发3分钟即可快速接入微信小程序');

insert into notice(user_id, title, `desc`, `date`) values (1, '10至11月水电费缴费通知', '尊敬的业主：你们好，物业公司现已将2020年10月1日至2020年11月31日水电表底抄录完毕，并已导入收费系统，为了不影响您的正常使用，请您于本月15日前按时缴纳水电费。缴费方式可通过线上缴费，也可以到物业处通过支付宝、微信扫码、现金缴纳', '2020-12-11');
insert into notice(user_id, title, `desc`, `date`) values (1, '物业收费公告【1201】', '尊敬的业主，您好！物业管理处收缴物业费的工作正在展开，物业费是小区维护正常秩序、环境卫生、公共配套设施维护服务的根本保证。如果物业费不能按时缴纳，将会对物业服务工作造成不利影响，同时也侵犯了已交费业主的利益。因此，请还未缴纳物业费的业主尽快到物业处缴纳。', '2020-12-01');
insert into notice(user_id, title, `desc`, `date`) values (1, '服务平台上线啦！！！', '本可向物业行业、公共停车场、社区等场所提供：智慧社区服务、小区电商、智能停车场、智能充电桩、云可视对讲系统等服务，为社区管理者提供了统一接入管理平台，所有数据、功能均可统一管理，无需开发3分钟即可快速接入微信小程序', '2020-12-01');

insert into notice(user_id, title, `desc`, `date`) values (2, '10至11月水电费缴费通知', '尊敬的业主：你们好，物业公司现已将2020年10月1日至2020年11月31日水电表底抄录完毕，并已导入收费系统，为了不影响您的正常使用，请您于本月15日前按时缴纳水电费。缴费方式可通过线上缴费，也可以到物业处通过支付宝、微信扫码、现金缴纳', '2020-12-11');
insert into notice(user_id, title, `desc`, `date`) values (2, '通知功能测试', '测试通知功能，测试通知功能，测试通知功能，测试通知功能，测试通知功能，测试通知功能，测试通知功能，测试通知功能', '2020-12-01');


insert into repair_record(user_id, contact_person, date, details, status, phone_number, address) values (1, '杨浩', '2020-05-01', '宽带故障', 1, '13145229277', 'B栋');
insert into repair_record(user_id, contact_person, date, details, status, phone_number, address) values (1, '陈建邦', '2020-08-02', '天然气管泄露', 1, '13145229277', 'A栋');
insert into repair_record(user_id, contact_person, date, details, status, phone_number, address) values (1, '陈思蕴', '2020-08-021', '水管爆裂', 1, '13145229277', 'B栋');

insert into repair_record(user_id, contact_person, date, details, status, phone_number, address) values (2, '张三', '2020-08-08', '停电', 1, '13145229277', 'B栋');
insert into repair_record(user_id, contact_person, date, details, status, phone_number, address) values (2, '莉莉', '2020-09-08', '天然气管泄露', 1, '13145229277', 'A栋');
insert into repair_record(user_id, contact_person, date, details, status, phone_number, address) values (2, 'Alex', '2020-11-08', '水管爆裂', 1, '13145229277', 'B栋');

insert into repair_record(user_id, contact_person, date, details, status, phone_number, address) values (3, 'arc', '2020-08-08', '停电', 1, '13145229277', 'B栋');
insert into repair_record(user_id, contact_person, date, details, status, phone_number, address) values (3, '莉莉', '2020-08-18', '天然气管泄露', 1, '13145229277', 'A栋');
insert into repair_record(user_id, contact_person, date, details, status, phone_number, address) values (3, 'Alex', '2020-09-01', '水管爆裂', 1, '13145229277', 'B栋');

insert into door_record(date, user_id, name, sex, num, id_card) values ('2020-05-11', 1, '陈建邦', '男', '13145462242', '441581199704040034');
insert into door_record(date, user_id, name, sex, num, id_card) values ('2020-05-11', 1, '张九龄', '男', '13145462242', '441581199704040034');
insert into door_record(date, user_id, name, sex, num, id_card) values ('2020-05-11', 1, '周杰伦', '男', '13145462242', '441581199704040034');
insert into door_record(date, user_id, name, sex, num, id_card) values ('2020-05-11', 1, '王图图', '男', '13145462242', '441581199704040034');

insert into door_record(date, user_id, name, sex, num, id_card) values ('2020-05-11', 2, '王冰冰', '男', '13145462242', '441581199704040034');
insert into door_record(date, user_id, name, sex, num, id_card) values ('2020-06-11', 2, '张三', '男', '13145462242', '441581199704040034');
insert into door_record(date, user_id, name, sex, num, id_card) values ('2020-06-22', 2, '陈思远', '男', '13145462242', '441581199704040034');
insert into door_record(date, user_id, name, sex, num, id_card) values ('2020-07-28', 2, '杨浩', '男', '13145462242', '441581199704040034');

insert into PaymentRecord(user_id, date, price, type) values (1, '2020-01-01', 112, 1);
insert into PaymentRecord(user_id, date, price, type) values (1, '2020-01-12', -112, 2);
insert into PaymentRecord(user_id, date, price, type) values (1, '2020-02-21', -212, 3);
insert into PaymentRecord(user_id, date, price, type) values (1, '2020-06-18', 78, 4);
insert into PaymentRecord(user_id, date, price, type) values (1, '2020-11-23', 56, 5);

insert into PaymentRecord(user_id, date, price, type) values (2, '2020-01-01', 112, 1);
insert into PaymentRecord(user_id, date, price, type) values (2, '2020-01-12', -112, 2);
insert into PaymentRecord(user_id, date, price, type) values (2, '2020-02-21', -212, 3);
insert into PaymentRecord(user_id, date, price, type) values (2, '2020-06-18', 78, 4);
insert into PaymentRecord(user_id, date, price, type) values (2, '2020-11-23', 56, 5);