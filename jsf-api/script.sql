--MYSQL
INSERT INTO `jsf-project`.`usr_user` (`USR_ENABLE`, `USR_LOGIN`, `USR_PASSWORD`) VALUES (1, 'adm', '$2a$10$/rMGxGoKcgLMN4cgJf/iQO2zpnxbNAkol0n33z7f0vMJ.8teoYSKS');
INSERT INTO `jsf-project`.`usl_user_level` (`USL_LEVEL`,`USR_ID`) VALUES ('ROLE_ADMIN', 1);
INSERT INTO `jsf-project`.`usl_user_level` (`USL_LEVEL`,`USR_ID`) VALUES ('ROLE_VISITOR', 1);
INSERT INTO `jsf-project`.`usl_user_level` (`USL_LEVEL`,`USR_ID`) VALUES ('ROLE_CUSTOMER', 1);

INSERT INTO `jsf-project`.`usr_user` (`USR_ENABLE`, `USR_LOGIN`, `USR_PASSWORD`) VALUES (1, 'visitor', '$2a$10$/rMGxGoKcgLMN4cgJf/iQO2zpnxbNAkol0n33z7f0vMJ.8teoYSKS');
INSERT INTO `jsf-project`.`usl_user_level` (`USL_LEVEL`,`USR_ID`) VALUES ('ROLE_VISITOR', 2);

INSERT INTO `jsf-project`.`usr_user` (`USR_ENABLE`, `USR_LOGIN`, `USR_PASSWORD`) VALUES (1, 'customer', '$2a$10$/rMGxGoKcgLMN4cgJf/iQO2zpnxbNAkol0n33z7f0vMJ.8teoYSKS');
INSERT INTO `jsf-project`.`usl_user_level` (`USL_LEVEL`,`USR_ID`) VALUES ('ROLE_CUSTOMER', 3);

--POSTGRESQL
INSERT INTO usr_user (USR_ID, USR_ENABLE, USR_LOGIN, USR_PASSWORD) VALUES (1, true, 'adm', '$2a$10$/rMGxGoKcgLMN4cgJf/iQO2zpnxbNAkol0n33z7f0vMJ.8teoYSKS');
INSERT INTO usl_user_level (USL_ID, USL_LEVEL,USR_ID) VALUES (1, 'ROLE_ADMIN', 1);

INSERT INTO usr_user (USR_ID, USR_ENABLE, USR_LOGIN, USR_PASSWORD) VALUES (2, true, 'visitor', '$2a$10$/rMGxGoKcgLMN4cgJf/iQO2zpnxbNAkol0n33z7f0vMJ.8teoYSKS');
INSERT INTO usl_user_level (USL_ID, USL_LEVEL,USR_ID) VALUES (2, 'ROLE_VISITOR', 2);

INSERT INTO usr_user (USR_ID, USR_ENABLE, USR_LOGIN, USR_PASSWORD) VALUES (3, true, 'customer', '$2a$10$/rMGxGoKcgLMN4cgJf/iQO2zpnxbNAkol0n33z7f0vMJ.8teoYSKS');
INSERT INTO usl_user_level (USL_ID, USL_LEVEL,USR_ID) VALUES (3, 'ROLE_CUSTOMER', 3);


