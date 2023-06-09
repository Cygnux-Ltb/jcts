
# 投资组合接口
## 获取用户投资组合

**URL:** `/portfolio`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=UTF-8`

**Description:** 获取用户投资组合



**Query-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|userId|int32|true|   用户ID|-|
|group|string|true|投资组合名|-|


**Request-example:**
```
curl -X GET -i /portfolio?userId=0&group=
```

**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|userId|int32|用户ID|-|
|portfolioName|string|投资组合名称|-|
|instrumentCodes|array|交易标的列表|-|

**Response-example:**
```
{
  "userId": 0,
  "portfolioName": "",
  "instrumentCodes": [
    ""
  ]
}
```

