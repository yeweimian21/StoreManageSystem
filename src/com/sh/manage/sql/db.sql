//��ѯ�������

SELECT * FROM T_User_Wash;

SELECT * FROM T_Role;

SELECT * FROM T_Right;

SELECT * FROM T_UserRole;

SELECT * FROM T_RoleRight;

//���볬������Ա������

INSERT INTO T_User_Wash VALUES(user_id_seq.nextVal,'Bob','123','male',30,'1851234123','Bob@163.com');

INSERT INTO T_Role VALUES(role_id_seq.nextVal,'SuperAdmin');

INSERT INTO T_Right VALUES(right_id_seq.nextVal,'manageAllStore');

INSERT INTO T_Right VALUES(right_id_seq.nextVal,'manageAllUser');

INSERT INTO T_UserRole VALUES(userrole_id_seq.nextVal,1,1);

INSERT INTO T_RoleRight VALUES(roleright_id_seq.nextVal,1,1);

INSERT INTO T_RoleRight VALUES(roleright_id_seq.nextVal,1,2);

//ע��һ��Ҫ�ύ

commit;