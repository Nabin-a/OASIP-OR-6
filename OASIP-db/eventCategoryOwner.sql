use mydb;
insert into eventcategoryowner (userId, eventCategoryId)
values(2,1),(2,2),(5,2),(6,3),(4,4),(3,5),(2,5); 

select c.CategoryName, u.name from user u, category c, eventcategoryowner o where u.userId = o.userId and c.eventCategoryId = o.eventCategoryId and u.userId = 3;   
