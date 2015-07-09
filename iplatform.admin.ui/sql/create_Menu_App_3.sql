/*/*Dorg.apache.coyote.http11.Http11Protocol.MAX_HEADER_SIZE=7340032" */*/
declare
 l_appId number;
 l_menuId  number;
 l_menuId1 number;
 l_menuId2 number;
 l_menuId3 number;
 
 l_ADMIN_menuId number;
l_CREATE_DOC_menuId number;
begin
l_appId :=3;
 --select id_app into l_appId from mdb.app_module


DELETE DF.SEC_ROLE_ACTION
 where id in (select id_menu from mdb.app_menu where id_app =l_appId);
 
delete mdb.app_menu
 where ID_APP = l_appId;
/*

 INSERT INTO MDB.APP_MODULE   (ID_APP, NAME ) 
 	VALUES  (l_appId, 'iPaltform administration console' );
*/

 /*Hot Menu*/
insert into mdb.app_menu (id_menu_parent, id_app, name, action, img_path)
  values (null, l_appId, 'Home', 'Home', 'silk/cube_green.png') returning id_menu into l_menuId;
 
 
  
 /*Клиенты*/ 
insert into mdb.app_menu (id_menu_parent, id_app, name)
  values (null, l_appId, 'Клиенты') returning id_menu  into l_menuId;
  
  insert into mdb.app_menu (id_menu_parent, id_app, name, action)
  values (l_menuId, l_appId, 'Физические лица', 'ClientListIndividual');
  
  insert into mdb.app_menu (id_menu_parent, id_app, name, action)
  values (l_menuId, l_appId, 'Юридические лица', 'CliLeagal');
  
 
  /*Клиенты*/ 
insert into mdb.app_menu (id_menu_parent, id_app, name)
  values (null, l_appId, 'Счета') returning id_menu  into l_menuId;
  
  insert into mdb.app_menu (id_menu_parent, id_app, name, action)
  values (l_menuId, l_appId, 'Все счета', 'AccAll');
  
  
  insert into mdb.app_menu (id_menu_parent, id_app, name, img_path, action, shortcut_key,visible)
  values (null, l_appId, 'Поиск', 'silk/find.png', 'Search', 'Ctrl+F', 1);  
  
 
  
  /*Справочники*/
 insert into mdb.app_menu (id_menu_parent, id_app, name)
  values (null, l_appId, 'Справочники') returning id_menu  into l_menuId;  
    
  insert into mdb.app_menu (id_menu_parent, id_app, name, action)
    values (l_menuId, l_appId, 'Валюты и курсы', 'DicCurrency') ;
    
 insert into mdb.app_menu (id_menu_parent, id_app, name, action)    
     values (l_menuId, l_appId, 'Отделения','DicBranches');            
  
  insert into mdb.app_menu (id_menu_parent, id_app, name, action)    
     values (l_menuId, l_appId, 'Банки Украины','DicUaBanks');
	
  
  /*Администрирование*/
  insert into mdb.app_menu (id_menu_parent, id_app, name)
    values (null, l_appId, 'Администрирование') returning id_menu  into l_menuId;
 
 insert into mdb.app_menu (id_menu_parent, id_app, name, action)    
     values (l_menuId, l_appId, 'Пользователи','Users');            
 
  
  l_ADMIN_menuId:=l_menuId;
  
 
  /*ORG UNIT*/
  /*
  insert into mdb.app_menu (id_menu_parent, id_app, name)
    values (l_menuId1, l_appId, 'Организационные единицы') returning id_menu  into l_menuId2;
  */

  
  /*Отчеты*/
  insert into mdb.app_menu (id_menu_parent, id_app, name, img_path, action)
    values (null, l_appId, 'Отчеты',  'silk/printer.png', null) returning id_menu  into l_menuId;
  



insert into mdb.app_menu (id_menu_parent, id_app, name)
    values (null, l_appId, 'Помощь') returning id_menu  into l_menuId;

insert into mdb.app_menu (id_menu_parent, id_app, name, action)    
    values (l_menuId, l_appId, 'Инстукция пользователя', 'UserGuide');    




insert into DF.SEC_ROLE_ACTION (ID_ROLE,    ID_ACTION,      date_b,   ID )     
select 1,1, sysdate,  id_menu
    from mdb.app_menu 
    where id_app = l_appId and visible =1
    connect by prior id_menu = id_menu_parent 
    start with id_menu_parent  is null     
    order siblings by sort
;

/*
insert into DF.SEC_ROLE_ACTION (ID_ROLE,    ID_ACTION,      date_b,   ID )     
select 2,1, sysdate,  id_menu
    from mdb.app_menu 
    where id_app =l_appId and visible =1
    connect by prior id_menu = id_menu_parent 
    start with id_menu_parent  is null and  id_menu <>l_ADMIN_menuId
    order siblings by sort
    */

   
end;

