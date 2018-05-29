delete from restaurant;

delete from city;
delete from country;

delete from category;

INSERT INTO category(id,name) VALUES(1000,'Comida rápida');
INSERT INTO category(id,name) VALUES(1001,'Desayuno');
INSERT INTO category(id,name) VALUES(1002,'Almuerzo');
INSERT INTO category(id,name) VALUES(1003,'Cena');

INSERT INTO country(id,name) VALUES(1001,'Bolivia');
INSERT INTO country(id,name) VALUES(1002,'Chile');


INSERT INTO city(id,name,country_id) VALUES(1001,'Santa Cruz',1001);
INSERT INTO city(id,name,country_id) VALUES(1002,'La Paz',1001);
INSERT INTO city(id,name,country_id) VALUES(1000,'Cochabamba',1001);

INSERT INTO city(id,name,country_id) VALUES(1003,'Iquique',1002);
INSERT INTO city(id,name,country_id) VALUES(1004,'Santiago',1002);


