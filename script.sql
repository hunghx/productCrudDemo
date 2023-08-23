create DATABASE qlsp;
use qlsp;

create table Product (
                         `code` int auto_increment primary key ,
                         `product_name` varchar(50),
                         `image_url` varchar(100),
                         `price` double,
                         `stock` int
);
# lấy tất cả bản ghi
delimiter //
create procedure findAllProducts()
begin
select * from product;
end // ;
# thêm mới bản ghi
delimiter //
create procedure insertProducts(new_product_name varchar(50),product_image varchar(100),product_price double,product_stock int)
begin
insert into product (product_name, image_url, price, stock) values
    (new_product_name,product_image,product_price,product_stock);
end // ;
# chỉnh sửa bản ghi
delimiter //
create procedure updateProducts(code_product_update int,new_product_name varchar(50),product_image varchar(100),product_price double,product_stock int)
begin
update product set product_name = new_product_name, image_url=product_image, price=product_price, stock = product_stock  where code = code_product_update;
end // ;
# tìm bản ghi theo id
delimiter //
create procedure findProductById(code_product int)
begin
select * from product where code = code_product;
end // ;
# Xóa bản ghi theo id

delimiter //
create procedure deleteProductById(code_product int)
begin
delete from product where code = code_product;
end // ;