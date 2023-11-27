-- 查询ecshop中各个类别中价格最高的商品
use ecshop;

select *
from ecs_goods;

select cat_id, max(shop_price)
from ecs_goods
group by cat_id;

select goods_id, temp.cat_id, goods_name, shop_price
from (select cat_id, max(shop_price) as price
      from ecs_goods
      group by cat_id) as temp,
     ecs_goods
where temp.cat_id = ecs_goods.cat_id
and temp.price = ecs_goods.shop_price;




