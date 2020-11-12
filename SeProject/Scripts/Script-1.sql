SELECT * FROM PRODUCT WHERE PRODUCT_NAME LIKE '%Æú%';
SELECT * FROM PRODUCT WHERE brand LIKE '%P%';
SELECT * FROM PRODUCT WHERE price 

select * from topcategory where topcategory_id =(
select topcategory_id  from subcategory where subcategory_id =
) ;