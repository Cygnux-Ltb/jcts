
# 交易标的查询接口
## 获取结算信息

**URL:** `/instrument/settlement`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=UTF-8`

**Description:** 获取结算信息



**Query-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|td|int32|true|    int|-|
|code|string|true|交易标的 [查询多个标的使用','分割]|-|


**Request-example:**
```
curl -X GET -i /instrument/settlement?td=0&code=
```

**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|instrumentCode|string|交易标的代码|-|
|tradingDay|int32|交易日|-|
|closePrice|double|收盘价|-|
|openPrice|double|开盘价|-|
|settlementPrice|double|结算价|-|

**Response-example:**
```
[
  {
    "instrumentCode": "",
    "tradingDay": 0,
    "closePrice": 0.0,
    "openPrice": 0.0,
    "settlementPrice": 0.0
  }
]
```

## 获取最新价格

**URL:** `/instrument/price`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=UTF-8`

**Description:** 获取最新价格



**Query-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|code|string|true|交易标的 [查询多个标的使用','分割]|-|


**Request-example:**
```
curl -X GET -i /instrument/price?code=
```

**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|instrumentCode|string|交易标的|-|
|lastPrice|double|最新价格|-|

**Response-example:**
```
[
  {
    "instrumentCode": "",
    "lastPrice": 0.0
  }
]
```

## 更新最新价格 (內部接口)

**URL:** `/instrument/price`

**Type:** `PUT`


**Content-Type:** `application/x-www-form-urlencoded;charset=UTF-8`

**Description:** 更新最新价格 (內部接口)





**Request-example:**
```
curl -X PUT -i /instrument/price
```

**Response-example:**
```
OK
```

## 获取交易费用

**URL:** `/instrument/fee`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=UTF-8`

**Description:** 获取交易费用



**Query-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|code|string|true|交易标的 [查询多个标的使用','分割]|-|


**Request-example:**
```
curl -X GET -i /instrument/fee?code=
```

**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|instrumentCode|string|交易标的代码|-|
|instrumentType|string|交易标的类型|-|
|exchangeCode|string|交易所代码|-|
|fee|double|交易费用|-|
|tradable|boolean|可交易标识|-|

**Response-example:**
```
[
  {
    "instrumentCode": "",
    "instrumentType": "",
    "exchangeCode": "",
    "fee": 0.0,
    "tradable": true
  }
]
```

## 获取可交易标的

**URL:** `/instrument/tradable`

**Type:** `GET`


**Content-Type:** `application/x-www-form-urlencoded;charset=UTF-8`

**Description:** 获取可交易标的



**Query-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|td|int32|true|    交易日|-|
|code|string|true|交易标的 [查询多个标的使用','分割]|-|


**Request-example:**
```
curl -X GET -i /instrument/tradable?td=0&code=
```

**Response-example:**
```
OK
```

