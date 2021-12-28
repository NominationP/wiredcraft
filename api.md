[toc]
* [1 userDetail-create](#1)
* [2 userDetail-update](#2)
* [3 userDetail-get](#3)
* [4 userDetail-delete](#4)
* [5 basicAuth-getToken](#5)
* [6 follow-following](#6)
* [7 follow-unfollowing](#7)
* [8 follow-showFans](#8)
* [9 follow-showFollowing](#9)
* [10 geo-add](#10)
* [11 geo-findNearby](#11)

## wiredcraft back-end test api


### `localhost:8500`

### NOTICE:
1. code:10000 means success
2. get 5.basicAuth first, and take token to each API header:Authorization , bearer+" "+{token}





## <a name="1" />1 userDetail-create

### URL
POST `userDetail/`

### Detail
create user


### 入参
| 字段 | 类型 | 说明 | 是否必填 |
| ---------- | ------ | ------------------ | -------- |
| address | String | address | 是 |
| dob | String | birthday | 是 |
| name | String | 名称 | 是 |
| description | String | desc | 是 |

### 返回
| 字段 | 类型 | 说明 | 是否必填 |
| ---------- | ------ | ------------------ | -------- |
| data | String | data | 是 |
| message | String | message | 是 |
| status | Integer | 标识 | 是 |
| timestamp | Long | timestamp | 是 |

### 实例
```json
{
    "name":"boo",
    "dob":"2010-10-20",
    "address":"shanghai",
    "description":"I like tennis"
}
```
```json
{
    "status": 10000,
    "message": "success",
    "data": "success to create user",
    "timestamp": 1640511450050
}
```
## <a name="2" />2 userDetail-update

### URL
PUT `userDetail/{id}`

### Detail
update user


### 入参
| 字段 | 类型 | 说明 | 是否必填 |
| ---------- | ------ | ------------------ | -------- |
| address | String | address | 是 |
| dob | String | birthday | 是 |
| name | String | 名称 | 是 |
| description | String | desc | 是 |

### 返回
| 字段 | 类型 | 说明 | 是否必填 |
| ---------- | ------ | ------------------ | -------- |
| data | String | data | 是 |
| message | String | message | 是 |
| status | Integer | 标识 | 是 |
| timestamp | Long | timestamp | 是 |

### 实例
```json
{
    "name":"boo",
    "dob":"2010-10-20",
    "address":"shanghai",
    "description":"I like tennis"
}
```
```json
{
    "status": 10000,
    "message": "success",
    "data": "success to update user",
    "timestamp": 1640511450050
}
```
## <a name="3" />3 userDetail-get

### URL
GET `userDetail/{id}`

### Detail
show user


### 入参

### 返回
| 字段 | 类型 | 说明 | 是否必填 |
| ---------- | ------ | ------------------ | -------- |
| data | Null | data | 是 |
| message | String | message | 是 |
| status | Integer | 标识 | 是 |
| timestamp | Long | timestamp | 是 |

### 实例
```json

```
```json
{
    "status": 10099,
    "message": "user dose not exist",
    "data": null,
    "timestamp": 1640657805680
}
```
## <a name="4" />4 userDetail-delete

### URL
DELETE `userDetail/{id}`

### Detail
delete user


### 入参

### 返回
| 字段 | 类型 | 说明 | 是否必填 |
| ---------- | ------ | ------------------ | -------- |
| data | String | data | 是 |
| message | String | message | 是 |
| status | Integer | 标识 | 是 |
| timestamp | Long | timestamp | 是 |

### 实例
```json

```
```json
{
    "status": 10000,
    "message": "success",
    "data": "fail to delete user",
    "timestamp": 1640657983739
}
```
## <a name="5" />5 basicAuth-getToken

### URL
POST `oauth/token`

### Detail
basic auth
- username:client
- password:112233
body (x-www-form-uriencoded)


### 入参
| 字段 | 类型 | 说明 | 是否必填 |
| ---------- | ------ | ------------------ | -------- |
| password | String | pwd | 是 |
| grant_type | String | grant_type : passwrod / token .. | 是 |
| scope | String | all | 是 |
| username | String | 员工编号 | 是 |

### 返回
| 字段 | 类型 | 说明 | 是否必填 |
| ---------- | ------ | ------------------ | -------- |
| **data** | **Object** | **data** | **是** |
| access_token | String | token | 是 |
| refresh_token | String | 刷新token | 是 |
| scope | String | all | 是 |
| token_type | String | {bearer}+' '+token | 是 |
| expires_in | Integer | 过期时间 | 是 |
| jti | String | jti | 是 |
| enhance | String | enhance info | 是 |
| message | String | message | 是 |
| status | Integer | 标识 | 是 |
| timestamp | Long | timestamp | 是 |

### 实例
```json
{
    "grant_type":"password",
    "scope":"all",
    "username":"admin",
    "password":"123456"
}
```
```json
{
    "status": 10000,
    "message": "success",
    "data": {
        "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbImFsbCJdLCJleHAiOjE2NDA2NTgzOTMsImF1dGhvcml0aWVzIjpbImFkbWluIl0sImp0aSI6IjRmMzJjM2I2LWJjOGUtNDIxZS1hNjVlLWIwMzRiZTJmYWQyMyIsImNsaWVudF9pZCI6ImNsaWVudCIsImVuaGFuY2UiOiLlop7lvLrnmoTkv6Hmga8ifQ.RM9KOfzKVHJxeyGNw5vx_ec_ms4IELqRmllpVeGtS6Y",
        "token_type": "bearer",
        "refresh_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbImFsbCJdLCJhdGkiOiI0ZjMyYzNiNi1iYzhlLTQyMWUtYTY1ZS1iMDM0YmUyZmFkMjMiLCJleHAiOjE2NDA3NDQxOTMsImF1dGhvcml0aWVzIjpbImFkbWluIl0sImp0aSI6IjlkYmM5YzkwLTI4YjMtNGY3ZC1hYjkxLTg0N2U4NjI3YjEyMiIsImNsaWVudF9pZCI6ImNsaWVudCIsImVuaGFuY2UiOiLlop7lvLrnmoTkv6Hmga8ifQ.6pK132o_btiaCQxIhTbEeu-NymQnAMvXBN9NL6w4D2I",
        "expires_in": 599,
        "scope": "all",
        "enhance": "增强的信息",
        "jti": "4f32c3b6-bc8e-421e-a65e-b034be2fad23"
    },
    "timestamp": 1640657793827
}
```
## <a name="6" />6 follow-following

### URL
POST `userFollow/following`

### Detail


### 入参
| 字段 | 类型 | 说明 | 是否必填 |
| ---------- | ------ | ------------------ | -------- |
| followingUserId | Integer | followingUserId | 是 |
| followingUserName | String | followingUserName | 是 |
| userName | String | 用户工号(与竹云名称一致) | 是 |
| userId | Integer | 用户ID | 是 |

### 返回
| 字段 | 类型 | 说明 | 是否必填 |
| ---------- | ------ | ------------------ | -------- |
| data | Null | data | 是 |
| message | String | message | 是 |
| status | Integer | 标识 | 是 |
| timestamp | Long | timestamp | 是 |

### 实例
```json
[
    {
        "userId": 1,
        "followingUserId": 2,
        "userName": "bo",
        "followingUserName": "lu"
    }
]
```
```json
{
    "status": 10099,
    "message": "duplication...",
    "data": null,
    "timestamp": 1640660547933
}
```
## <a name="7" />7 follow-unfollowing

### URL
POST `userFollow/unfollowing`

### Detail


### 入参
| 字段 | 类型 | 说明 | 是否必填 |
| ---------- | ------ | ------------------ | -------- |
| userId | Integer | 用户ID | 是 |
| unfollowingUserId | Integer | unfollowingUserId | 是 |

### 返回
| 字段 | 类型 | 说明 | 是否必填 |
| ---------- | ------ | ------------------ | -------- |
| data | String | data | 是 |
| message | String | message | 是 |
| status | Integer | 标识 | 是 |
| timestamp | Long | timestamp | 是 |

### 实例
```json
{
    "userId":1,
    "unfollowingUserId":2
}
```
```json
{
    "status": 10000,
    "message": "success",
    "data": "unfollow success",
    "timestamp": 1640660636012
}
```
## <a name="8" />8 follow-showFans

### URL
POST `userFollow/showFans`

### Detail


### 入参
| 字段 | 类型 | 说明 | 是否必填 |
| ---------- | ------ | ------------------ | -------- |
| pageSize | Integer | 每页数量 | 是 |
| userId | Integer | 用户ID | 是 |
| pageNum | Integer | 第几页 | 是 |

### 返回
| 字段 | 类型 | 说明 | 是否必填 |
| ---------- | ------ | ------------------ | -------- |
| **data** | **Object** | **data** | **是** |
| startRow | Integer | 当前页面第一个元素在数据库中的行号 | 是 |
| **navigatepageNums** | **Array** | **所有导航页号** | **是** |
| prePage | Integer | 前一页 | 是 |
| hasNextPage | Boolean | 是否有下一页 | 是 |
| nextPage | Integer | 下一页 | 是 |
| pageSize | Integer | 每页数量 | 是 |
| endRow | Integer | 当前页面最后一个元素在数据库中的行号 | 是 |
| **list** | **Array** | **结果集** | **是** |
| createdAt | String | 创建时间 | 是 |
| followingUserId | Integer | followingUserId | 是 |
| followedName | String | followedName | 是 |
| id | Integer | id | 是 |
| userName | String | 用户工号(与竹云名称一致) | 是 |
| userId | Integer | 用户ID | 是 |
| updatedAt | String | 更新时间 | 是 |
| pageNum | Integer | 第几页 | 是 |
| navigatePages | Integer | 导航页码数 | 是 |
| total | Integer | 总记录数 | 是 |
| navigateFirstPage | Integer | 导航条上的第一页 | 是 |
| pages | Integer | 总页数 | 是 |
| size | Integer | 当前页的数量 | 是 |
| isLastPage | Boolean | 是否为最后一页 | 是 |
| hasPreviousPage | Boolean | 是否有前一页 | 是 |
| navigateLastPage | Integer | 导航条上的最后一页 | 是 |
| isFirstPage | Boolean | 是否为第一页 | 是 |
| message | String | message | 是 |
| status | Integer | 标识 | 是 |
| timestamp | Long | timestamp | 是 |

### 实例
```json
{
    "userId":3,
    "pageNum":1,
    "pageSize":5
}
```
```json
{
    "status": 10000,
    "message": "success",
    "data": {
        "total": 1,
        "list": [
            {
                "id": 12,
                "userId": 1,
                "followingUserId": 3,
                "createdAt": "2021-12-28",
                "updatedAt": "2021-12-28",
                "userName": "bo",
                "followedName": "lu"
            }
        ],
        "pageNum": 1,
        "pageSize": 5,
        "size": 1,
        "startRow": 1,
        "endRow": 1,
        "pages": 1,
        "prePage": 0,
        "nextPage": 0,
        "isFirstPage": true,
        "isLastPage": true,
        "hasPreviousPage": false,
        "hasNextPage": false,
        "navigatePages": 8,
        "navigatepageNums": [
            1
        ],
        "navigateFirstPage": 1,
        "navigateLastPage": 1
    },
    "timestamp": 1640660712803
}
```
## <a name="9" />9 follow-showFollowing

### URL
POST `userFollow/showFollowing`

### Detail


### 入参
| 字段 | 类型 | 说明 | 是否必填 |
| ---------- | ------ | ------------------ | -------- |
| pageSize | Integer | 每页数量 | 是 |
| userId | Integer | 用户ID | 是 |
| pageNum | Integer | 第几页 | 是 |

### 返回
| 字段 | 类型 | 说明 | 是否必填 |
| ---------- | ------ | ------------------ | -------- |
| **data** | **Object** | **data** | **是** |
| startRow | Integer | 当前页面第一个元素在数据库中的行号 | 是 |
| **navigatepageNums** | **Array** | **所有导航页号** | **是** |
| prePage | Integer | 前一页 | 是 |
| hasNextPage | Boolean | 是否有下一页 | 是 |
| nextPage | Integer | 下一页 | 是 |
| pageSize | Integer | 每页数量 | 是 |
| endRow | Integer | 当前页面最后一个元素在数据库中的行号 | 是 |
| **list** | **Array** | **结果集** | **是** |
| createdAt | String | 创建时间 | 是 |
| followingUserId | Integer | followingUserId | 是 |
| followedName | String | followedName | 是 |
| id | Integer | id | 是 |
| userName | String | 用户工号(与竹云名称一致) | 是 |
| userId | Integer | 用户ID | 是 |
| updatedAt | String | 更新时间 | 是 |
| createdAt | String | 创建时间 | 是 |
| followingUserId | Integer | followingUserId | 是 |
| followedName | String | followedName | 是 |
| id | Integer | id | 是 |
| userName | String | 用户工号(与竹云名称一致) | 是 |
| userId | Integer | 用户ID | 是 |
| updatedAt | String | 更新时间 | 是 |
| pageNum | Integer | 第几页 | 是 |
| navigatePages | Integer | 导航页码数 | 是 |
| total | Integer | 总记录数 | 是 |
| navigateFirstPage | Integer | 导航条上的第一页 | 是 |
| pages | Integer | 总页数 | 是 |
| size | Integer | 当前页的数量 | 是 |
| isLastPage | Boolean | 是否为最后一页 | 是 |
| hasPreviousPage | Boolean | 是否有前一页 | 是 |
| navigateLastPage | Integer | 导航条上的最后一页 | 是 |
| isFirstPage | Boolean | 是否为第一页 | 是 |
| message | String | message | 是 |
| status | Integer | 标识 | 是 |
| timestamp | Long | timestamp | 是 |

### 实例
```json
{
    "userId":1,
    "pageNum":1,
    "pageSize":5
}
```
```json
{
    "status": 10000,
    "message": "success",
    "data": {
        "total": 2,
        "list": [
            {
                "id": 12,
                "userId": 1,
                "followingUserId": 3,
                "createdAt": "2021-12-28",
                "updatedAt": "2021-12-28",
                "userName": "bo",
                "followedName": "lu"
            },
            {
                "id": 13,
                "userId": 1,
                "followingUserId": 5,
                "createdAt": "2021-12-28",
                "updatedAt": "2021-12-28",
                "userName": "bo",
                "followedName": "l"
            }
        ],
        "pageNum": 1,
        "pageSize": 5,
        "size": 2,
        "startRow": 1,
        "endRow": 2,
        "pages": 1,
        "prePage": 0,
        "nextPage": 0,
        "isFirstPage": true,
        "isLastPage": true,
        "hasPreviousPage": false,
        "hasNextPage": false,
        "navigatePages": 8,
        "navigatepageNums": [
            1
        ],
        "navigateFirstPage": 1,
        "navigateLastPage": 1
    },
    "timestamp": 1640660794881
}
```
## <a name="10" />10 geo-add

### URL
POST `userGeo/`

### Detail


### 入参
| 字段 | 类型 | 说明 | 是否必填 |
| ---------- | ------ | ------------------ | -------- |
| latitude | Double | lat | 是 |
| userId | Integer | 用户ID | 是 |
| username | Integer | 员工编号 | 是 |
| longitude | Double | log | 是 |

### 返回
| 字段 | 类型 | 说明 | 是否必填 |
| ---------- | ------ | ------------------ | -------- |
| data | String | data | 是 |
| message | String | message | 是 |
| status | Integer | 标识 | 是 |
| timestamp | Long | timestamp | 是 |

### 实例
```json
{
    "userId":1,
    "username":1,
    "latitude":82.23,
    "longitude":120.23
}
```
```json
{
    "status": 10000,
    "message": "success",
    "data": "success add geo",
    "timestamp": 1640656614582
}
```
## <a name="11" />11 geo-findNearby

### URL
POST `findNearby/`

### Detail


### 入参
| 字段 | 类型 | 说明 | 是否必填 |
| ---------- | ------ | ------------------ | -------- |
| distance | Integer | distance nearby | 是 |
| **userDetail** | **Object** | **userDetail** | **是** |
| name | String | 名称 | 是 |
| Id | Integer | id | 是 |
| count | Integer | limit count | 是 |

### 返回
| 字段 | 类型 | 说明 | 是否必填 |
| ---------- | ------ | ------------------ | -------- |
| **data** | **Object** | **data** | **是** |
| **averageDistance** | **Object** | **averageDistance** | **是** |
| metric | String | metric | 是 |
| value | Double | value | 是 |
| **content** | **Array** | **content** | **是** |
| **distance** | **Object** | **distance nearby** | **是** |
| metric | String | metric | 是 |
| value | Double | value | 是 |
| **content** | **Object** | **content** | **是** |
| name | String | 名称 | 是 |
| **point** | **Object** | **point** | **是** |
| x | Double | log | 是 |
| y | Double | lat | 是 |
| **distance** | **Object** | **distance nearby** | **是** |
| metric | String | metric | 是 |
| value | Double | value | 是 |
| **content** | **Object** | **content** | **是** |
| name | String | 名称 | 是 |
| **point** | **Object** | **point** | **是** |
| x | Double | log | 是 |
| y | Double | lat | 是 |
| **distance** | **Object** | **distance nearby** | **是** |
| metric | String | metric | 是 |
| value | Double | value | 是 |
| **content** | **Object** | **content** | **是** |
| name | String | 名称 | 是 |
| **point** | **Object** | **point** | **是** |
| x | Double | log | 是 |
| y | Double | lat | 是 |
| message | String | message | 是 |
| status | Integer | 标识 | 是 |
| timestamp | Long | timestamp | 是 |

### 实例
```json
{
    "userDetail": {
        "Id": 1,
        "name": "bo"
    },
    "distance": 100,
    "count": 5
}
```
```json
{
    "status": 10000,
    "message": "success",
    "data": {
        "averageDistance": {
            "value": 3.0175666666666676,
            "metric": "KILOMETERS"
        },
        "content": [
            {
                "content": {
                    "name": "bo",
                    "point": {
                        "x": 116.40426903963089,
                        "y": 39.909178316988886
                    }
                },
                "distance": {
                    "value": 0.0,
                    "metric": "KILOMETERS"
                }
            },
            {
                "content": {
                    "name": "boo",
                    "point": {
                        "x": 116.4044138789177,
                        "y": 39.91504619647275
                    }
                },
                "distance": {
                    "value": 0.6528,
                    "metric": "KILOMETERS"
                }
            },
            {
                "content": {
                    "name": "lu",
                    "point": {
                        "x": 116.36244267225266,
                        "y": 39.97755242026205
                    }
                },
                "distance": {
                    "value": 8.3999,
                    "metric": "KILOMETERS"
                }
            }
        ]
    },
    "timestamp": 1640657230110
}
```
