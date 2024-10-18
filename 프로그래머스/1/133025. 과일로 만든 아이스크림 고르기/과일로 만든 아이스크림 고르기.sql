-- 코드를 입력하세요
SELECT A.FLAVOR
FROM FIRST_HALF as A
join ICECREAM_INFO as b
    on A.FLAVOR = B.FLAVOR
WHERE A.TOTAL_ORDER  >= 3000 && B.INGREDIENT_TYPE like 'fruit_based'
ORDER BY A.TOTAL_ORDER DESC