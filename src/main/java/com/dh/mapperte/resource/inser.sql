-- teacher
create table  `teacher`
(
  `id`              INT auto_increment primary key not null comment 'id',
  `tname`           VARCHAR(50) not null comment '老师名',
  `tel`             VARCHAR(11) comment '电话号码',
  `tno`             VARCHAR(12) comment '教师号',
  `pwd`             VARCHAR(16) not null comment '密码',
  `faculty`         VARCHAR(200) not null comment '院系'
);
create unique index `IDU_teacher_tel` on `teacher`(`tel`);
create unique index `IDU_teacher_tno` on `teacher`(`tno`);
alter table `teacher` comment= '老师表';

-- Message
create table  `Message`
(
  `id`              INT auto_increment primary key not null comment 'id',
  `teacher`         VARCHAR(2000) not null comment '老师',
  `subject`         VARCHAR(2000) comment '科目',
  `xhours`          NUMERIC(3) not null comment '学时',
  `source`          VARCHAR(2000) not null comment '阅卷方式',
  `classnum`        NUMERIC(6) not null comment '班级人数',
  `realnum`         NUMERIC(6) not null comment '参加考试人数',
  `lessnum`         NUMERIC(6) not null comment '缺考人数',
  `testmethod`      VARCHAR(2000) not null comment '考试方式',
  `markingmethod`   VARCHAR(2000) not null comment '阅卷方式',
  `startyear`       VARCHAR(10) not null comment '开始年月',
  `endyear`         VARCHAR(10) not null comment '结束年月',
  `semester`        VARCHAR(500) not null comment '学期',
  `tno`             INT comment '老师id'
);
create index `IDX_Message_tno` on `Message`(`tno`);
alter table `Message` comment= '基本信息记录';

-- scroe
create table  `scroe`
(
  `id`              INT auto_increment primary key not null comment 'id',
  `scroelist`       VARCHAR(200) not null comment '大题得分',
  `sum`             NUMERIC(4) comment '总分',
  `standardScore`   DOUBLE(10) comment '标准分',
  `mid`             INT comment '基本信息表的外键'
  );
alter table `scroe` comment= '成绩';

-- topic
create table  `topic`
(
  `id`              INT auto_increment primary key not null comment '自身id',
  `mid`             INT comment '记录表的id',
  `quetions`        VARCHAR(2000) not null comment '每个大题的类型',
  `toscore`         NUMERIC(4) not null comment '大题的分数',
  `tnindex`         NUMERIC(3) not null comment '大题序号'
);
alter table `topic` comment= '题目表和每题的类型';

alter  table `Message`
  add constraint `FK_Message_tno` foreign key (`tno`)
    references `teacher`(`tno`);

alter  table `scroe`
  add constraint `FK_scroe_mid` foreign key (`mid`)
    references `Message`(`id`);

alter  table `topic`
  add constraint `FK_topic_mid` foreign key (`mid`)
    references `Message`(`id`);

