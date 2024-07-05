# USE group40FS1;
#
# CREATE TABLE IF NOT EXISTS 'manager'
# (
#     `id`            INT(11)         NOT NULL AUTO_INCREMENT,
#     `manager_name`  VARCHAR(255)    NOT NULL ,
#     `password`      VARCHAR(255)    NOT NULL ,
#     `email`         VARCHAR(255)    NOT NULL ,
#     PRIMARY KEY (`id`)
# );
#
# CREATE TABLE IF NOT EXISTS `role`
# (
#     `id`            INT(11)         NOT NULL AUTO_INCREMENT,
#     `name`          VARCHAR(255)    NOT NULL ,
#     PRIMARY KEY (`id`)
# );
#
# CREATE TABLE IF NOT EXISTS `task`
# (
#     `id`            INT(11)         NOT NULL AUTO_INCREMENT,
#     `task_name`     VARCHAR(255)    NOT NULL ,
#     `description`   VARCHAR(255)    NOT NULL ,
#     `create_date`   DATETIME        NOT NULL ,
#     `last_update`   DATETIME        NOT NULL ,
#     `deadline`      DATETIME        NOT NULL ,
#     `status`        ENUM('OPEN','CLOSE','ON_HOLD') NOT NULL ,
#     `manager_id`    INT(11)         NOT NULL ,
#     FOREIGN KEY (`manager_id`) REFERENCES `manager` (`id`),
#     PRIMARY KEY (`id`)
# );
#
# CREATE TABLE IF NOT EXISTS `manager_role`(
#         `managed_id`    INT(11) NOT NULL ,
#         `role_id`       INT(11) NOT NULL ,
#     FOREIGN KEY (`managed_id`)  REFERENCES `manager` (`id`),
#     FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
#     PRIMARY KEY (`managed_id`,`role_id`)
# );
#
#
# ALTER TABLE role
#     ADD UNIQUE (name);
#
#
# ALTER TABLE manager
#     ADD UNIQUE (manager_name,password,email);
#
