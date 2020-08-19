描述：
1. 有两类商品，具有不同的逻辑，common和Backstage pass
2. 所有商品具有2个属性：SellIn和Quality
3. 0 <= Quality <= 50
4. 对于common商品，SellIn前（包含SellIn）每天减1点Quality，SellIn后每天减2点Quality
5. 对于Backstage pass，SellIn前10天到SellIn前5天，每天Quality增加2点；SellIn前5天（包含SellIn）到SellIn，每天Quality增加3点；过了SellIn，Quality为0；

产出：
1. 有2个类对应不同的商品
2. 建立商品Model，具有2个属性
3. 设置条件公共类
4. common商品的update方法
    a. SellIn > 0, Quality -= 1
    b. SellIn <= 0, Quality -= 2
    c. edge case: 
        i. SellIn > 0, Quality already is 0
5. Backstage pass的更新方法
    a. SellIn > 10, Quality += 1
    b. 10 >= SellIn >5, Quality += 2
    c. 5 >= SellIn > 0, Quality += 3
    d. 0 >= Quality, Quality = 0 
    e. edge case:
        i. SellIn > 0, Quality already is 50
6. 创建validation类，如果不需要更新，则不用继续执行update方法
7. 做一个入口方法模拟每天执行更新方法

#### 普通商品

| sellIn | quality | updatedSellIn | updatedQuality |
| ------ | ------- | ------------- | -------------- |
| 10     | 20      | 9             | 19             |
| 2      | 0       | 1             | 0              |
| 3      | 6       | 2             | 5              |
| 0      | 6       | -1            | 4              |
| -1     | 6       | -2            | 4              |

#### 后台门票

| sellIn | quality | updatedSellIn | updatedQuality |
| ------ | ------- | ------------- | -------------- |
| 15     | 20      | 14            | 21             |
| 10     | 45      | 9             | 47             |
| 9      | 45      | 8             | 47             |
| 10     | 49      | 9             | 50             |
| 10     | 50      | 9             | 50             |
| 5      | 49      | 4             | 50             |
| 5      | 45      | 4             | 48             |
| 1      | 20      | 0             | 23             |
| 0      | 20      | -1            | 0              |
