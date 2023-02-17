# online exam by springboot


**简介**:online exam by springboot


**HOST**:localhost:8080


**联系人**:liangshanguang


**Version**:2.0


**接口路径**:/v2/api-docs


[TOC]






# Exam APIs


## 获取全部考试的列表


**接口地址**:`/api/exam/all`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|Access-Token|Rest接口权限认证token,无需鉴权可为空|header|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultVO«List«ExamVo»»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||array|ExamVo|
|&emsp;&emsp;avatar||string||
|&emsp;&emsp;checkScore||integer(int32)||
|&emsp;&emsp;checks||array|ExamQuestionSelectVo|
|&emsp;&emsp;&emsp;&emsp;checked||boolean||
|&emsp;&emsp;&emsp;&emsp;id||string||
|&emsp;&emsp;&emsp;&emsp;name||string||
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;creator||string||
|&emsp;&emsp;desc||string||
|&emsp;&emsp;elapse||integer(int32)||
|&emsp;&emsp;endDate||string(date-time)||
|&emsp;&emsp;id||string||
|&emsp;&emsp;judgeScore||integer(int32)||
|&emsp;&emsp;judges||array|ExamQuestionSelectVo|
|&emsp;&emsp;&emsp;&emsp;checked||boolean||
|&emsp;&emsp;&emsp;&emsp;id||string||
|&emsp;&emsp;&emsp;&emsp;name||string||
|&emsp;&emsp;name||string||
|&emsp;&emsp;radioScore||integer(int32)||
|&emsp;&emsp;radios||array|ExamQuestionSelectVo|
|&emsp;&emsp;&emsp;&emsp;checked||boolean||
|&emsp;&emsp;&emsp;&emsp;id||string||
|&emsp;&emsp;&emsp;&emsp;name||string||
|&emsp;&emsp;score||integer(int32)||
|&emsp;&emsp;startDate||string(date-time)||
|&emsp;&emsp;updateTime||string(date-time)||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": [
		{
			"avatar": "",
			"checkScore": 0,
			"checks": [
				{
					"checked": true,
					"id": "",
					"name": ""
				}
			],
			"createTime": "",
			"creator": "",
			"desc": "",
			"elapse": 0,
			"endDate": "",
			"id": "",
			"judgeScore": 0,
			"judges": [
				{
					"checked": true,
					"id": "",
					"name": ""
				}
			],
			"name": "",
			"radioScore": 0,
			"radios": [
				{
					"checked": true,
					"id": "",
					"name": ""
				}
			],
			"score": 0,
			"startDate": "",
			"updateTime": ""
		}
	],
	"msg": ""
}
```


## 获取考试列表，适配前端卡片列表


**接口地址**:`/api/exam/card/list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|Access-Token|Rest接口权限认证token,无需鉴权可为空|header|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultVO«List«ExamCardVo»»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||array|ExamCardVo|
|&emsp;&emsp;avatar||string||
|&emsp;&emsp;content||string||
|&emsp;&emsp;elapse||integer(int32)||
|&emsp;&emsp;id||string||
|&emsp;&emsp;score||integer(int32)||
|&emsp;&emsp;title||string||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": [
		{
			"avatar": "",
			"content": "",
			"elapse": 0,
			"id": "",
			"score": 0,
			"title": ""
		}
	],
	"msg": ""
}
```


## 创建考试


**接口地址**:`/api/exam/create`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "avatar": "",
  "checkScore": 0,
  "checks": [
    {
      "checked": true,
      "id": "",
      "name": ""
    }
  ],
  "desc": "",
  "elapse": 0,
  "judgeScore": 0,
  "judges": [
    {
      "checked": true,
      "id": "",
      "name": ""
    }
  ],
  "name": "",
  "radioScore": 0,
  "radios": [
    {
      "checked": true,
      "id": "",
      "name": ""
    }
  ]
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|examCreateVo|examCreateVo|body|true|ExamCreateVo|ExamCreateVo|
|&emsp;&emsp;avatar|||false|string||
|&emsp;&emsp;checkScore|||false|integer(int32)||
|&emsp;&emsp;checks|||false|array|ExamQuestionSelectVo|
|&emsp;&emsp;&emsp;&emsp;checked|||false|boolean||
|&emsp;&emsp;&emsp;&emsp;id|||false|string||
|&emsp;&emsp;&emsp;&emsp;name|||false|string||
|&emsp;&emsp;desc|||false|string||
|&emsp;&emsp;elapse|||false|integer(int32)||
|&emsp;&emsp;judgeScore|||false|integer(int32)||
|&emsp;&emsp;judges|||false|array|ExamQuestionSelectVo|
|&emsp;&emsp;&emsp;&emsp;checked|||false|boolean||
|&emsp;&emsp;&emsp;&emsp;id|||false|string||
|&emsp;&emsp;&emsp;&emsp;name|||false|string||
|&emsp;&emsp;name|||false|string||
|&emsp;&emsp;radioScore|||false|integer(int32)||
|&emsp;&emsp;radios|||false|array|ExamQuestionSelectVo|
|&emsp;&emsp;&emsp;&emsp;checked|||false|boolean||
|&emsp;&emsp;&emsp;&emsp;id|||false|string||
|&emsp;&emsp;&emsp;&emsp;name|||false|string||
|Access-Token|Rest接口权限认证token,无需鉴权可为空|header|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultVO«Exam»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||Exam|Exam|
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;examAvatar||string||
|&emsp;&emsp;examCreatorId||string||
|&emsp;&emsp;examDescription||string||
|&emsp;&emsp;examEndDate||string(date-time)||
|&emsp;&emsp;examId||string||
|&emsp;&emsp;examName||string||
|&emsp;&emsp;examQuestionIds||string||
|&emsp;&emsp;examQuestionIdsCheck||string||
|&emsp;&emsp;examQuestionIdsJudge||string||
|&emsp;&emsp;examQuestionIdsRadio||string||
|&emsp;&emsp;examScore||integer(int32)||
|&emsp;&emsp;examScoreCheck||integer(int32)||
|&emsp;&emsp;examScoreJudge||integer(int32)||
|&emsp;&emsp;examScoreRadio||integer(int32)||
|&emsp;&emsp;examStartDate||string(date-time)||
|&emsp;&emsp;examTimeLimit||integer(int32)||
|&emsp;&emsp;updateTime||string(date-time)||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"createTime": "",
		"examAvatar": "",
		"examCreatorId": "",
		"examDescription": "",
		"examEndDate": "",
		"examId": "",
		"examName": "",
		"examQuestionIds": "",
		"examQuestionIdsCheck": "",
		"examQuestionIdsJudge": "",
		"examQuestionIdsRadio": "",
		"examScore": 0,
		"examScoreCheck": 0,
		"examScoreJudge": 0,
		"examScoreRadio": 0,
		"examStartDate": "",
		"examTimeLimit": 0,
		"updateTime": ""
	},
	"msg": ""
}
```


## 根据考试的id，获取考试详情


**接口地址**:`/api/exam/detail/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||
|Access-Token|Rest接口权限认证token,无需鉴权可为空|header|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultVO«ExamDetailVo»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||ExamDetailVo|ExamDetailVo|
|&emsp;&emsp;checkIds||array|string|
|&emsp;&emsp;exam||Exam|Exam|
|&emsp;&emsp;&emsp;&emsp;createTime||string||
|&emsp;&emsp;&emsp;&emsp;examAvatar||string||
|&emsp;&emsp;&emsp;&emsp;examCreatorId||string||
|&emsp;&emsp;&emsp;&emsp;examDescription||string||
|&emsp;&emsp;&emsp;&emsp;examEndDate||string||
|&emsp;&emsp;&emsp;&emsp;examId||string||
|&emsp;&emsp;&emsp;&emsp;examName||string||
|&emsp;&emsp;&emsp;&emsp;examQuestionIds||string||
|&emsp;&emsp;&emsp;&emsp;examQuestionIdsCheck||string||
|&emsp;&emsp;&emsp;&emsp;examQuestionIdsJudge||string||
|&emsp;&emsp;&emsp;&emsp;examQuestionIdsRadio||string||
|&emsp;&emsp;&emsp;&emsp;examScore||integer||
|&emsp;&emsp;&emsp;&emsp;examScoreCheck||integer||
|&emsp;&emsp;&emsp;&emsp;examScoreJudge||integer||
|&emsp;&emsp;&emsp;&emsp;examScoreRadio||integer||
|&emsp;&emsp;&emsp;&emsp;examStartDate||string||
|&emsp;&emsp;&emsp;&emsp;examTimeLimit||integer||
|&emsp;&emsp;&emsp;&emsp;updateTime||string||
|&emsp;&emsp;judgeIds||array|string|
|&emsp;&emsp;radioIds||array|string|
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"checkIds": [],
		"exam": {
			"createTime": "",
			"examAvatar": "",
			"examCreatorId": "",
			"examDescription": "",
			"examEndDate": "",
			"examId": "",
			"examName": "",
			"examQuestionIds": "",
			"examQuestionIdsCheck": "",
			"examQuestionIdsJudge": "",
			"examQuestionIdsRadio": "",
			"examScore": 0,
			"examScoreCheck": 0,
			"examScoreJudge": 0,
			"examScoreRadio": 0,
			"examStartDate": "",
			"examTimeLimit": 0,
			"updateTime": ""
		},
		"judgeIds": [],
		"radioIds": []
	},
	"msg": ""
}
```


## 根据用户提交的答案对指定id的考试判分


**接口地址**:`/api/exam/finish/{examId}`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|answersMap|answersMap|body|true|||
|examId|examId|path|true|string||
|Access-Token|Rest接口权限认证token,无需鉴权可为空|header|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultVO«ExamRecord»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||ExamRecord|ExamRecord|
|&emsp;&emsp;answerOptionIds||string||
|&emsp;&emsp;examId||string||
|&emsp;&emsp;examJoinDate||string(date-time)||
|&emsp;&emsp;examJoinScore||integer(int32)||
|&emsp;&emsp;examJoinerId||string||
|&emsp;&emsp;examRecordId||string||
|&emsp;&emsp;examResultLevel||integer(int32)||
|&emsp;&emsp;examTimeCost||integer(int32)||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"answerOptionIds": "",
		"examId": "",
		"examJoinDate": "",
		"examJoinScore": 0,
		"examJoinerId": "",
		"examRecordId": "",
		"examResultLevel": 0,
		"examTimeCost": 0
	},
	"msg": ""
}
```


## 获取所有问题的列表


**接口地址**:`/api/exam/question/all`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|Access-Token|Rest接口权限认证token,无需鉴权可为空|header|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultVO«List«QuestionVo»»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||array|QuestionVo|
|&emsp;&emsp;category||string||
|&emsp;&emsp;categoryId||integer(int32)||
|&emsp;&emsp;creator||string||
|&emsp;&emsp;description||string||
|&emsp;&emsp;id||string||
|&emsp;&emsp;level||string||
|&emsp;&emsp;levelId||integer(int32)||
|&emsp;&emsp;name||string||
|&emsp;&emsp;options||array|QuestionOptionVo|
|&emsp;&emsp;&emsp;&emsp;answer||boolean||
|&emsp;&emsp;&emsp;&emsp;content||string||
|&emsp;&emsp;&emsp;&emsp;description||string||
|&emsp;&emsp;&emsp;&emsp;id||string||
|&emsp;&emsp;score||integer(int32)||
|&emsp;&emsp;type||string||
|&emsp;&emsp;typeId||integer(int32)||
|&emsp;&emsp;updateTime||string(date-time)||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": [
		{
			"category": "",
			"categoryId": 0,
			"creator": "",
			"description": "",
			"id": "",
			"level": "",
			"levelId": 0,
			"name": "",
			"options": [
				{
					"answer": true,
					"content": "",
					"description": "",
					"id": ""
				}
			],
			"score": 0,
			"type": "",
			"typeId": 0,
			"updateTime": ""
		}
	],
	"msg": ""
}
```


## 创建问题


**接口地址**:`/api/exam/question/create`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "category": 0,
  "desc": "",
  "level": 0,
  "name": "",
  "option": "",
  "options": [
    {
      "answer": true,
      "content": ""
    }
  ],
  "type": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|questionCreateSimplifyVo|questionCreateSimplifyVo|body|true|QuestionCreateSimplifyVo|QuestionCreateSimplifyVo|
|&emsp;&emsp;category|||false|integer(int32)||
|&emsp;&emsp;desc|||false|string||
|&emsp;&emsp;level|||false|integer(int32)||
|&emsp;&emsp;name|||false|string||
|&emsp;&emsp;option|||false|string||
|&emsp;&emsp;options|||false|array|QuestionOptionCreateVo|
|&emsp;&emsp;&emsp;&emsp;answer|||false|boolean||
|&emsp;&emsp;&emsp;&emsp;content|||false|string||
|&emsp;&emsp;type|||false|integer(int32)||
|Access-Token|Rest接口权限认证token,无需鉴权可为空|header|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultVO«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"msg": ""
}
```


## 根据问题的id获取问题的详细信息


**接口地址**:`/api/exam/question/detail/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||
|Access-Token|Rest接口权限认证token,无需鉴权可为空|header|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultVO«QuestionDetailVo»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||QuestionDetailVo|QuestionDetailVo|
|&emsp;&emsp;answers||array|string|
|&emsp;&emsp;description||string||
|&emsp;&emsp;id||string||
|&emsp;&emsp;name||string||
|&emsp;&emsp;options||array|QuestionOption|
|&emsp;&emsp;&emsp;&emsp;questionOptionContent||string||
|&emsp;&emsp;&emsp;&emsp;questionOptionDescription||string||
|&emsp;&emsp;&emsp;&emsp;questionOptionId||string||
|&emsp;&emsp;type||string||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"answers": [],
		"description": "",
		"id": "",
		"name": "",
		"options": [
			{
				"questionOptionContent": "",
				"questionOptionDescription": "",
				"questionOptionId": ""
			}
		],
		"type": ""
	},
	"msg": ""
}
```


## 获取问题分类的相关选项


**接口地址**:`/api/exam/question/selection`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|Access-Token|Rest接口权限认证token,无需鉴权可为空|header|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultVO«QuestionSelectionVo»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||QuestionSelectionVo|QuestionSelectionVo|
|&emsp;&emsp;categories||array|QuestionCategory|
|&emsp;&emsp;&emsp;&emsp;description||string||
|&emsp;&emsp;&emsp;&emsp;id||integer||
|&emsp;&emsp;&emsp;&emsp;name||string||
|&emsp;&emsp;levels||array|QuestionLevel|
|&emsp;&emsp;&emsp;&emsp;description||string||
|&emsp;&emsp;&emsp;&emsp;id||integer||
|&emsp;&emsp;&emsp;&emsp;name||string||
|&emsp;&emsp;types||array|QuestionType|
|&emsp;&emsp;&emsp;&emsp;description||string||
|&emsp;&emsp;&emsp;&emsp;id||integer||
|&emsp;&emsp;&emsp;&emsp;name||string||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"categories": [
			{
				"description": "",
				"id": 0,
				"name": ""
			}
		],
		"levels": [
			{
				"description": "",
				"id": 0,
				"name": ""
			}
		],
		"types": [
			{
				"description": "",
				"id": 0,
				"name": ""
			}
		]
	},
	"msg": ""
}
```


## 获取问题列表，按照单选、多选和判断题分类返回


**接口地址**:`/api/exam/question/type/list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|Access-Token|Rest接口权限认证token,无需鉴权可为空|header|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultVO«ExamQuestionTypeVo»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||ExamQuestionTypeVo|ExamQuestionTypeVo|
|&emsp;&emsp;checks||array|ExamQuestionSelectVo|
|&emsp;&emsp;&emsp;&emsp;checked||boolean||
|&emsp;&emsp;&emsp;&emsp;id||string||
|&emsp;&emsp;&emsp;&emsp;name||string||
|&emsp;&emsp;judges||array|ExamQuestionSelectVo|
|&emsp;&emsp;&emsp;&emsp;checked||boolean||
|&emsp;&emsp;&emsp;&emsp;id||string||
|&emsp;&emsp;&emsp;&emsp;name||string||
|&emsp;&emsp;radios||array|ExamQuestionSelectVo|
|&emsp;&emsp;&emsp;&emsp;checked||boolean||
|&emsp;&emsp;&emsp;&emsp;id||string||
|&emsp;&emsp;&emsp;&emsp;name||string||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"checks": [
			{
				"checked": true,
				"id": "",
				"name": ""
			}
		],
		"judges": [
			{
				"checked": true,
				"id": "",
				"name": ""
			}
		],
		"radios": [
			{
				"checked": true,
				"id": "",
				"name": ""
			}
		]
	},
	"msg": ""
}
```


## 更新问题


**接口地址**:`/api/exam/question/update`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "category": "",
  "categoryId": 0,
  "creator": "",
  "description": "",
  "id": "",
  "level": "",
  "levelId": 0,
  "name": "",
  "options": [
    {
      "answer": true,
      "content": "",
      "description": "",
      "id": ""
    }
  ],
  "score": 0,
  "type": "",
  "typeId": 0,
  "updateTime": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|questionVo|questionVo|body|true|QuestionVo|QuestionVo|
|&emsp;&emsp;category|||false|string||
|&emsp;&emsp;categoryId|||false|integer(int32)||
|&emsp;&emsp;creator|||false|string||
|&emsp;&emsp;description|||false|string||
|&emsp;&emsp;id|||false|string||
|&emsp;&emsp;level|||false|string||
|&emsp;&emsp;levelId|||false|integer(int32)||
|&emsp;&emsp;name|||false|string||
|&emsp;&emsp;options|||false|array|QuestionOptionVo|
|&emsp;&emsp;&emsp;&emsp;answer|||false|boolean||
|&emsp;&emsp;&emsp;&emsp;content|||false|string||
|&emsp;&emsp;&emsp;&emsp;description|||false|string||
|&emsp;&emsp;&emsp;&emsp;id|||false|string||
|&emsp;&emsp;score|||false|integer(int32)||
|&emsp;&emsp;type|||false|string||
|&emsp;&emsp;typeId|||false|integer(int32)||
|&emsp;&emsp;updateTime|||false|string(date-time)||
|Access-Token|Rest接口权限认证token,无需鉴权可为空|header|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultVO«QuestionVo»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||QuestionVo|QuestionVo|
|&emsp;&emsp;category||string||
|&emsp;&emsp;categoryId||integer(int32)||
|&emsp;&emsp;creator||string||
|&emsp;&emsp;description||string||
|&emsp;&emsp;id||string||
|&emsp;&emsp;level||string||
|&emsp;&emsp;levelId||integer(int32)||
|&emsp;&emsp;name||string||
|&emsp;&emsp;options||array|QuestionOptionVo|
|&emsp;&emsp;&emsp;&emsp;answer||boolean||
|&emsp;&emsp;&emsp;&emsp;content||string||
|&emsp;&emsp;&emsp;&emsp;description||string||
|&emsp;&emsp;&emsp;&emsp;id||string||
|&emsp;&emsp;score||integer(int32)||
|&emsp;&emsp;type||string||
|&emsp;&emsp;typeId||integer(int32)||
|&emsp;&emsp;updateTime||string(date-time)||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"category": "",
		"categoryId": 0,
		"creator": "",
		"description": "",
		"id": "",
		"level": "",
		"levelId": 0,
		"name": "",
		"options": [
			{
				"answer": true,
				"content": "",
				"description": "",
				"id": ""
			}
		],
		"score": 0,
		"type": "",
		"typeId": 0,
		"updateTime": ""
	},
	"msg": ""
}
```


## 根据考试记录id获取考试记录详情


**接口地址**:`/api/exam/record/detail/{recordId}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|recordId|recordId|path|true|string||
|Access-Token|Rest接口权限认证token,无需鉴权可为空|header|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultVO«RecordDetailVo»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||RecordDetailVo|RecordDetailVo|
|&emsp;&emsp;answersMap||object||
|&emsp;&emsp;answersRightMap||object||
|&emsp;&emsp;examRecord||ExamRecord|ExamRecord|
|&emsp;&emsp;&emsp;&emsp;answerOptionIds||string||
|&emsp;&emsp;&emsp;&emsp;examId||string||
|&emsp;&emsp;&emsp;&emsp;examJoinDate||string||
|&emsp;&emsp;&emsp;&emsp;examJoinScore||integer||
|&emsp;&emsp;&emsp;&emsp;examJoinerId||string||
|&emsp;&emsp;&emsp;&emsp;examRecordId||string||
|&emsp;&emsp;&emsp;&emsp;examResultLevel||integer||
|&emsp;&emsp;&emsp;&emsp;examTimeCost||integer||
|&emsp;&emsp;resultsMap||object||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"answersMap": {},
		"answersRightMap": {},
		"examRecord": {
			"answerOptionIds": "",
			"examId": "",
			"examJoinDate": "",
			"examJoinScore": 0,
			"examJoinerId": "",
			"examRecordId": "",
			"examResultLevel": 0,
			"examTimeCost": 0
		},
		"resultsMap": {}
	},
	"msg": ""
}
```


## 获取当前用户的考试记录


**接口地址**:`/api/exam/record/list`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|Access-Token|Rest接口权限认证token,无需鉴权可为空|header|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultVO«List«ExamRecordVo»»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||array|ExamRecordVo|
|&emsp;&emsp;exam||Exam|Exam|
|&emsp;&emsp;&emsp;&emsp;createTime||string||
|&emsp;&emsp;&emsp;&emsp;examAvatar||string||
|&emsp;&emsp;&emsp;&emsp;examCreatorId||string||
|&emsp;&emsp;&emsp;&emsp;examDescription||string||
|&emsp;&emsp;&emsp;&emsp;examEndDate||string||
|&emsp;&emsp;&emsp;&emsp;examId||string||
|&emsp;&emsp;&emsp;&emsp;examName||string||
|&emsp;&emsp;&emsp;&emsp;examQuestionIds||string||
|&emsp;&emsp;&emsp;&emsp;examQuestionIdsCheck||string||
|&emsp;&emsp;&emsp;&emsp;examQuestionIdsJudge||string||
|&emsp;&emsp;&emsp;&emsp;examQuestionIdsRadio||string||
|&emsp;&emsp;&emsp;&emsp;examScore||integer||
|&emsp;&emsp;&emsp;&emsp;examScoreCheck||integer||
|&emsp;&emsp;&emsp;&emsp;examScoreJudge||integer||
|&emsp;&emsp;&emsp;&emsp;examScoreRadio||integer||
|&emsp;&emsp;&emsp;&emsp;examStartDate||string||
|&emsp;&emsp;&emsp;&emsp;examTimeLimit||integer||
|&emsp;&emsp;&emsp;&emsp;updateTime||string||
|&emsp;&emsp;examRecord||ExamRecord|ExamRecord|
|&emsp;&emsp;&emsp;&emsp;answerOptionIds||string||
|&emsp;&emsp;&emsp;&emsp;examId||string||
|&emsp;&emsp;&emsp;&emsp;examJoinDate||string||
|&emsp;&emsp;&emsp;&emsp;examJoinScore||integer||
|&emsp;&emsp;&emsp;&emsp;examJoinerId||string||
|&emsp;&emsp;&emsp;&emsp;examRecordId||string||
|&emsp;&emsp;&emsp;&emsp;examResultLevel||integer||
|&emsp;&emsp;&emsp;&emsp;examTimeCost||integer||
|&emsp;&emsp;user||User|User|
|&emsp;&emsp;&emsp;&emsp;createTime||string||
|&emsp;&emsp;&emsp;&emsp;updateTime||string||
|&emsp;&emsp;&emsp;&emsp;userAvatar||string||
|&emsp;&emsp;&emsp;&emsp;userDescription||string||
|&emsp;&emsp;&emsp;&emsp;userEmail||string||
|&emsp;&emsp;&emsp;&emsp;userId||string||
|&emsp;&emsp;&emsp;&emsp;userNickname||string||
|&emsp;&emsp;&emsp;&emsp;userPassword||string||
|&emsp;&emsp;&emsp;&emsp;userPhone||string||
|&emsp;&emsp;&emsp;&emsp;userRoleId||integer||
|&emsp;&emsp;&emsp;&emsp;userUsername||string||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": [
		{
			"exam": {
				"createTime": "",
				"examAvatar": "",
				"examCreatorId": "",
				"examDescription": "",
				"examEndDate": "",
				"examId": "",
				"examName": "",
				"examQuestionIds": "",
				"examQuestionIdsCheck": "",
				"examQuestionIdsJudge": "",
				"examQuestionIdsRadio": "",
				"examScore": 0,
				"examScoreCheck": 0,
				"examScoreJudge": 0,
				"examScoreRadio": 0,
				"examStartDate": "",
				"examTimeLimit": 0,
				"updateTime": ""
			},
			"examRecord": {
				"answerOptionIds": "",
				"examId": "",
				"examJoinDate": "",
				"examJoinScore": 0,
				"examJoinerId": "",
				"examRecordId": "",
				"examResultLevel": 0,
				"examTimeCost": 0
			},
			"user": {
				"createTime": "",
				"updateTime": "",
				"userAvatar": "",
				"userDescription": "",
				"userEmail": "",
				"userId": "",
				"userNickname": "",
				"userPassword": "",
				"userPhone": "",
				"userRoleId": 0,
				"userUsername": ""
			}
		}
	],
	"msg": ""
}
```


## 更新考试


**接口地址**:`/api/exam/update`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "avatar": "",
  "checkScore": 0,
  "checks": [
    {
      "checked": true,
      "id": "",
      "name": ""
    }
  ],
  "createTime": "",
  "creator": "",
  "desc": "",
  "elapse": 0,
  "endDate": "",
  "id": "",
  "judgeScore": 0,
  "judges": [
    {
      "checked": true,
      "id": "",
      "name": ""
    }
  ],
  "name": "",
  "radioScore": 0,
  "radios": [
    {
      "checked": true,
      "id": "",
      "name": ""
    }
  ],
  "score": 0,
  "startDate": "",
  "updateTime": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|examVo|examVo|body|true|ExamVo|ExamVo|
|&emsp;&emsp;avatar|||false|string||
|&emsp;&emsp;checkScore|||false|integer(int32)||
|&emsp;&emsp;checks|||false|array|ExamQuestionSelectVo|
|&emsp;&emsp;&emsp;&emsp;checked|||false|boolean||
|&emsp;&emsp;&emsp;&emsp;id|||false|string||
|&emsp;&emsp;&emsp;&emsp;name|||false|string||
|&emsp;&emsp;createTime|||false|string(date-time)||
|&emsp;&emsp;creator|||false|string||
|&emsp;&emsp;desc|||false|string||
|&emsp;&emsp;elapse|||false|integer(int32)||
|&emsp;&emsp;endDate|||false|string(date-time)||
|&emsp;&emsp;id|||false|string||
|&emsp;&emsp;judgeScore|||false|integer(int32)||
|&emsp;&emsp;judges|||false|array|ExamQuestionSelectVo|
|&emsp;&emsp;&emsp;&emsp;checked|||false|boolean||
|&emsp;&emsp;&emsp;&emsp;id|||false|string||
|&emsp;&emsp;&emsp;&emsp;name|||false|string||
|&emsp;&emsp;name|||false|string||
|&emsp;&emsp;radioScore|||false|integer(int32)||
|&emsp;&emsp;radios|||false|array|ExamQuestionSelectVo|
|&emsp;&emsp;&emsp;&emsp;checked|||false|boolean||
|&emsp;&emsp;&emsp;&emsp;id|||false|string||
|&emsp;&emsp;&emsp;&emsp;name|||false|string||
|&emsp;&emsp;score|||false|integer(int32)||
|&emsp;&emsp;startDate|||false|string(date-time)||
|&emsp;&emsp;updateTime|||false|string(date-time)||
|Access-Token|Rest接口权限认证token,无需鉴权可为空|header|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultVO«Exam»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||Exam|Exam|
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;examAvatar||string||
|&emsp;&emsp;examCreatorId||string||
|&emsp;&emsp;examDescription||string||
|&emsp;&emsp;examEndDate||string(date-time)||
|&emsp;&emsp;examId||string||
|&emsp;&emsp;examName||string||
|&emsp;&emsp;examQuestionIds||string||
|&emsp;&emsp;examQuestionIdsCheck||string||
|&emsp;&emsp;examQuestionIdsJudge||string||
|&emsp;&emsp;examQuestionIdsRadio||string||
|&emsp;&emsp;examScore||integer(int32)||
|&emsp;&emsp;examScoreCheck||integer(int32)||
|&emsp;&emsp;examScoreJudge||integer(int32)||
|&emsp;&emsp;examScoreRadio||integer(int32)||
|&emsp;&emsp;examStartDate||string(date-time)||
|&emsp;&emsp;examTimeLimit||integer(int32)||
|&emsp;&emsp;updateTime||string(date-time)||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"createTime": "",
		"examAvatar": "",
		"examCreatorId": "",
		"examDescription": "",
		"examEndDate": "",
		"examId": "",
		"examName": "",
		"examQuestionIds": "",
		"examQuestionIdsCheck": "",
		"examQuestionIdsJudge": "",
		"examQuestionIdsRadio": "",
		"examScore": 0,
		"examScoreCheck": 0,
		"examScoreJudge": 0,
		"examScoreRadio": 0,
		"examStartDate": "",
		"examTimeLimit": 0,
		"updateTime": ""
	},
	"msg": ""
}
```


# Upload And Download APIs


## 单文件上传,支持同时传入参数


**接口地址**:`/api/file/api/upload/singleAndparas`


**请求方式**:`POST`


**请求数据类型**:`multipart/form-data`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|dir|dir|query|true|string||
|file|file|formData|true|file||
|Access-Token|Rest接口权限认证token,无需鉴权可为空|header|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK||
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


暂无


**响应示例**:
```javascript

```


## Get下载文件


**接口地址**:`/api/file/download/get`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|filePath|filePath|query|true|string||
|Access-Token|Rest接口权限认证token,无需鉴权可为空|header|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|InputStreamResource|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|description||string||
|file||File|File|
|&emsp;&emsp;absolute||boolean||
|&emsp;&emsp;absoluteFile||File|File|
|&emsp;&emsp;absolutePath||string||
|&emsp;&emsp;canonicalFile||File|File|
|&emsp;&emsp;canonicalPath||string||
|&emsp;&emsp;directory||boolean||
|&emsp;&emsp;file||boolean||
|&emsp;&emsp;freeSpace||integer(int64)||
|&emsp;&emsp;hidden||boolean||
|&emsp;&emsp;name||string||
|&emsp;&emsp;parent||string||
|&emsp;&emsp;parentFile||File|File|
|&emsp;&emsp;path||string||
|&emsp;&emsp;totalSpace||integer(int64)||
|&emsp;&emsp;usableSpace||integer(int64)||
|filename||string||
|inputStream||InputStream|InputStream|
|open||boolean||
|readable||boolean||
|uri||URI|URI|
|&emsp;&emsp;absolute||boolean||
|&emsp;&emsp;authority||string||
|&emsp;&emsp;fragment||string||
|&emsp;&emsp;host||string||
|&emsp;&emsp;opaque||boolean||
|&emsp;&emsp;path||string||
|&emsp;&emsp;port||integer(int32)||
|&emsp;&emsp;query||string||
|&emsp;&emsp;rawAuthority||string||
|&emsp;&emsp;rawFragment||string||
|&emsp;&emsp;rawPath||string||
|&emsp;&emsp;rawQuery||string||
|&emsp;&emsp;rawSchemeSpecificPart||string||
|&emsp;&emsp;rawUserInfo||string||
|&emsp;&emsp;scheme||string||
|&emsp;&emsp;schemeSpecificPart||string||
|&emsp;&emsp;userInfo||string||
|url||URL|URL|
|&emsp;&emsp;authority||string||
|&emsp;&emsp;content||object||
|&emsp;&emsp;defaultPort||integer(int32)||
|&emsp;&emsp;file||string||
|&emsp;&emsp;host||string||
|&emsp;&emsp;path||string||
|&emsp;&emsp;port||integer(int32)||
|&emsp;&emsp;protocol||string||
|&emsp;&emsp;query||string||
|&emsp;&emsp;ref||string||
|&emsp;&emsp;userInfo||string||


**响应示例**:
```javascript
{
	"description": "",
	"file": {
		"absolute": true,
		"absoluteFile": {
			"absolute": true,
			"absoluteFile": {},
			"absolutePath": "",
			"canonicalFile": {},
			"canonicalPath": "",
			"directory": true,
			"file": true,
			"freeSpace": 0,
			"hidden": true,
			"name": "",
			"parent": "",
			"parentFile": {},
			"path": "",
			"totalSpace": 0,
			"usableSpace": 0
		},
		"absolutePath": "",
		"canonicalFile": {},
		"canonicalPath": "",
		"directory": true,
		"file": true,
		"freeSpace": 0,
		"hidden": true,
		"name": "",
		"parent": "",
		"parentFile": {},
		"path": "",
		"totalSpace": 0,
		"usableSpace": 0
	},
	"filename": "",
	"inputStream": {},
	"open": true,
	"readable": true,
	"uri": {
		"absolute": true,
		"authority": "",
		"fragment": "",
		"host": "",
		"opaque": true,
		"path": "",
		"port": 0,
		"query": "",
		"rawAuthority": "",
		"rawFragment": "",
		"rawPath": "",
		"rawQuery": "",
		"rawSchemeSpecificPart": "",
		"rawUserInfo": "",
		"scheme": "",
		"schemeSpecificPart": "",
		"userInfo": ""
	},
	"url": {
		"authority": "",
		"content": {},
		"defaultPort": 0,
		"file": "",
		"host": "",
		"path": "",
		"port": 0,
		"protocol": "",
		"query": "",
		"ref": "",
		"userInfo": ""
	}
}
```


## Post下载文件


**接口地址**:`/api/file/download/post`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "path": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|downloadQo|downloadQo|body|true|DownloadQo|DownloadQo|
|&emsp;&emsp;path|||false|string||
|Access-Token|Rest接口权限认证token,无需鉴权可为空|header|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|InputStreamResource|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|description||string||
|file||File|File|
|&emsp;&emsp;absolute||boolean||
|&emsp;&emsp;absoluteFile||File|File|
|&emsp;&emsp;absolutePath||string||
|&emsp;&emsp;canonicalFile||File|File|
|&emsp;&emsp;canonicalPath||string||
|&emsp;&emsp;directory||boolean||
|&emsp;&emsp;file||boolean||
|&emsp;&emsp;freeSpace||integer(int64)||
|&emsp;&emsp;hidden||boolean||
|&emsp;&emsp;name||string||
|&emsp;&emsp;parent||string||
|&emsp;&emsp;parentFile||File|File|
|&emsp;&emsp;path||string||
|&emsp;&emsp;totalSpace||integer(int64)||
|&emsp;&emsp;usableSpace||integer(int64)||
|filename||string||
|inputStream||InputStream|InputStream|
|open||boolean||
|readable||boolean||
|uri||URI|URI|
|&emsp;&emsp;absolute||boolean||
|&emsp;&emsp;authority||string||
|&emsp;&emsp;fragment||string||
|&emsp;&emsp;host||string||
|&emsp;&emsp;opaque||boolean||
|&emsp;&emsp;path||string||
|&emsp;&emsp;port||integer(int32)||
|&emsp;&emsp;query||string||
|&emsp;&emsp;rawAuthority||string||
|&emsp;&emsp;rawFragment||string||
|&emsp;&emsp;rawPath||string||
|&emsp;&emsp;rawQuery||string||
|&emsp;&emsp;rawSchemeSpecificPart||string||
|&emsp;&emsp;rawUserInfo||string||
|&emsp;&emsp;scheme||string||
|&emsp;&emsp;schemeSpecificPart||string||
|&emsp;&emsp;userInfo||string||
|url||URL|URL|
|&emsp;&emsp;authority||string||
|&emsp;&emsp;content||object||
|&emsp;&emsp;defaultPort||integer(int32)||
|&emsp;&emsp;file||string||
|&emsp;&emsp;host||string||
|&emsp;&emsp;path||string||
|&emsp;&emsp;port||integer(int32)||
|&emsp;&emsp;protocol||string||
|&emsp;&emsp;query||string||
|&emsp;&emsp;ref||string||
|&emsp;&emsp;userInfo||string||


**响应示例**:
```javascript
{
	"description": "",
	"file": {
		"absolute": true,
		"absoluteFile": {
			"absolute": true,
			"absoluteFile": {},
			"absolutePath": "",
			"canonicalFile": {},
			"canonicalPath": "",
			"directory": true,
			"file": true,
			"freeSpace": 0,
			"hidden": true,
			"name": "",
			"parent": "",
			"parentFile": {},
			"path": "",
			"totalSpace": 0,
			"usableSpace": 0
		},
		"absolutePath": "",
		"canonicalFile": {},
		"canonicalPath": "",
		"directory": true,
		"file": true,
		"freeSpace": 0,
		"hidden": true,
		"name": "",
		"parent": "",
		"parentFile": {},
		"path": "",
		"totalSpace": 0,
		"usableSpace": 0
	},
	"filename": "",
	"inputStream": {},
	"open": true,
	"readable": true,
	"uri": {
		"absolute": true,
		"authority": "",
		"fragment": "",
		"host": "",
		"opaque": true,
		"path": "",
		"port": 0,
		"query": "",
		"rawAuthority": "",
		"rawFragment": "",
		"rawPath": "",
		"rawQuery": "",
		"rawSchemeSpecificPart": "",
		"rawUserInfo": "",
		"scheme": "",
		"schemeSpecificPart": "",
		"userInfo": ""
	},
	"url": {
		"authority": "",
		"content": {},
		"defaultPort": 0,
		"file": "",
		"host": "",
		"path": "",
		"port": 0,
		"protocol": "",
		"query": "",
		"ref": "",
		"userInfo": ""
	}
}
```


## 多文件上传,支持同时传入参数


**接口地址**:`/api/file/upload/multi/model`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|Access-Token|Rest接口权限认证token,无需鉴权可为空|header|false|string||
|dir||query|false|string||
|files||query|false|array|file|


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK||
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


暂无


**响应示例**:
```javascript

```


## 多文件上传,支持同时传入参数


**接口地址**:`/api/file/upload/multiAndparas`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|dir|dir|query|true|string||
|files|files|formData|true|array|file|
|Access-Token|Rest接口权限认证token,无需鉴权可为空|header|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK||
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


暂无


**响应示例**:
```javascript

```


## 单文件上传,支持同时传入参数,Model


**接口地址**:`/api/file/upload/single/model`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|Access-Token|Rest接口权限认证token,无需鉴权可为空|header|false|string||
|dir||query|false|string||
|file||query|false|file||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK||
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


暂无


**响应示例**:
```javascript

```


# User APIs


## 获取用户的详细信息，包括个人信息页面和操作权限


**接口地址**:`/api/user/info`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|Access-Token|Rest接口权限认证token,无需鉴权可为空|header|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultVO«UserInfoVo»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||UserInfoVo|UserInfoVo|
|&emsp;&emsp;avatar||string||
|&emsp;&emsp;email||string||
|&emsp;&emsp;id||string||
|&emsp;&emsp;name||string||
|&emsp;&emsp;password||string||
|&emsp;&emsp;role||RoleVo|RoleVo|
|&emsp;&emsp;&emsp;&emsp;describe||string||
|&emsp;&emsp;&emsp;&emsp;id||string||
|&emsp;&emsp;&emsp;&emsp;name||string||
|&emsp;&emsp;&emsp;&emsp;permissions||array|PageVo|
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;actionEntitySet||array|ActionVo|
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;action||string||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;defaultCheck||boolean||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;describe||string||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;permissionId||string||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;permissionName||string||
|&emsp;&emsp;roleId||string||
|&emsp;&emsp;telephone||string||
|&emsp;&emsp;username||string||
|&emsp;&emsp;welcome||string||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"avatar": "",
		"email": "",
		"id": "",
		"name": "",
		"password": "",
		"role": {
			"describe": "",
			"id": "",
			"name": "",
			"permissions": [
				{
					"actionEntitySet": [
						{
							"action": "",
							"defaultCheck": true,
							"describe": ""
						}
					],
					"permissionId": "",
					"permissionName": ""
				}
			]
		},
		"roleId": "",
		"telephone": "",
		"username": "",
		"welcome": ""
	},
	"msg": ""
}
```


## 根据用户名或邮箱登录,登录成功返回token

**接口地址**:`/api/user/login`


**请求方式**:`POST`

**请求数据类型**:`application/json`

**响应数据类型**:`*/*`


**接口描述**:

**请求示例**:


```javascript
{
  "loginType": 0,
  "password": "",
  "userInfo": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|loginQo|loginQo|body|true|LoginQo|LoginQo|
|&emsp;&emsp;loginType|||false|integer(int32)||
|&emsp;&emsp;password|||false|string||
|&emsp;&emsp;userInfo|||false|string||
|Access-Token|Rest接口权限认证token,无需鉴权可为空|header|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultVO«string»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||string||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": "",
	"msg": ""
}
```


## 注册


**接口地址**:`/api/user/register`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "captcha": "",
  "email": "",
  "mobile": "",
  "password": "",
  "password2": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|registerDTO|registerDTO|body|true|RegisterDTO|RegisterDTO|
|&emsp;&emsp;captcha|||false|string||
|&emsp;&emsp;email|||false|string||
|&emsp;&emsp;mobile|||false|string||
|&emsp;&emsp;password|||false|string||
|&emsp;&emsp;password2|||false|string||
|Access-Token|Rest接口权限认证token,无需鉴权可为空|header|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultVO«User»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||User|User|
|&emsp;&emsp;createTime||string(date-time)||
|&emsp;&emsp;updateTime||string(date-time)||
|&emsp;&emsp;userAvatar||string||
|&emsp;&emsp;userDescription||string||
|&emsp;&emsp;userEmail||string||
|&emsp;&emsp;userId||string||
|&emsp;&emsp;userNickname||string||
|&emsp;&emsp;userPassword||string||
|&emsp;&emsp;userPhone||string||
|&emsp;&emsp;userRoleId||integer(int32)||
|&emsp;&emsp;userUsername||string||
|msg||string||


**响应示例**:	
```javascript
{
	"code": 0,
	"data": {
		"createTime": "",
		"updateTime": "",
		"userAvatar": "",
		"userDescription": "",
		"userEmail": "",
		"userId": "",
		"userNickname": "",
		"userPassword": "",
		"userPhone": "",
		"userRoleId": 0,
		"userUsername": ""
	},
	"msg": ""
}
```


## 测试接口


**接口地址**:`/api/user/test`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|Access-Token|Rest接口权限认证token,无需鉴权可为空|header|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


暂无


**响应示例**:
```javascript

```


## 获取用户信息


**接口地址**:`/api/user/user-info`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|Access-Token|Rest接口权限认证token,无需鉴权可为空|header|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultVO«UserVo»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code||integer(int32)|integer(int32)|
|data||UserVo|UserVo|
|&emsp;&emsp;avatar||string||
|&emsp;&emsp;description||string||
|&emsp;&emsp;email||string||
|&emsp;&emsp;id||string||
|&emsp;&emsp;nickname||string||
|&emsp;&emsp;phone||string||
|&emsp;&emsp;role||integer(int32)||
|&emsp;&emsp;username||string||
|msg||string||


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"avatar": "",
		"description": "",
		"email": "",
		"id": "",
		"nickname": "",
		"phone": "",
		"role": 0,
		"username": ""
	},
	"msg": ""
}
```