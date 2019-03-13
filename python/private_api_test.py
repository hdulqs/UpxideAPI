# Lee
import secrets
import time
import hashlib
import binascii
import uuid
import hashlib
import operator
import json
import operator
import json
import requests
import uuid

#public api test
#https://www.upxide.com/trade/trade?symbol=BTC_ETH&brokerId=10003

NONCE_LEN = 106
BASE_API_URL = "https://dev.upxide.com"

API_SECRET = "n9JDYsQuatJtrf4LCQyqoCwHcPaPSZc4Qi2g1oS3BhicNG1t1r5wjEr3VJcpbCsV"
BUSINESS_NO = "100000100000000001"


# API_SECRET = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6ImlseWVvbmcifQ.Ktaq0V8JbRJXxBkZ9GhzmN2_5HrbCX9TGh4Hh6-51kE"
# BUSINESS_NO = "100000100000000002"


### 106
def getNonceStr(len):
    return secrets.randbits(len)

def getTimeStamp():
    return int(round(time.time()))

def md5Hash(message):
    return hashlib.md5(message.encode()).hexdigest().upper()

def generateOrderNo():
    return str(uuid.uuid4())

# implement sign generator.
# refer to api document,
def generateSign(data, timestamp, nonceStr, apiSecret):
    dataJson={}
    for key in data:
        if data[key] != None:
            dataJson[key] = data[key]    

    dataJson['nonceStr'] = nonceStr
    dataJson['timestamp'] = timestamp
    dataJson['apiSecret'] = apiSecret

    reqStr = ""
    dataJson = sorted(dataJson.items(), key=operator.itemgetter(0,1))
    dataJson = dict(dataJson)

    for key in dataJson:
        reqStr = reqStr + key + "=" + str(dataJson[key]) 
        reqStr = reqStr+ "&"
    return md5Hash(reqStr[:-1])



######### /api/asset
print("### Assets")
data = {}
nonceStr = str(getNonceStr(NONCE_LEN))
timestamp = getTimeStamp()
params={
    "businessNo":BUSINESS_NO,
    "data":{},
    "sign":generateSign(data, timestamp, nonceStr, API_SECRET),
    "nonceStr":nonceStr,
    "timestamp":timestamp
}

url_path = "https://www.upxide.com/exchangeApi/api/asset"
res = requests.post(url_path, data=json.dumps(params))
result = res.json()

print(result)



######## /api/matchOrder/process
print("### MatchOrder Process Result")
data = {
    "symbol":"BTC_ETH"
}

nonceStr = str(getNonceStr(NONCE_LEN))
timestamp = getTimeStamp()

params={
    "businessNo":BUSINESS_NO,
    "data":data,
    "sign":generateSign(data, timestamp, nonceStr, API_SECRET),
    "nonceStr":nonceStr,
    "timestamp":timestamp
}

url_path = "https://www.upxide.com/exchangeApi/api/matchOrder/process"
res = requests.post(url_path, data=json.dumps(params))
result = res.json()

print(result)


###### /api/matchOrder
print("### MatchOrder Result")
data = {
    "outOrderNo":generateOrderNo(),
    "symbol":"BTC_ETH",
    "tradeCoinFlag":"FIXED",
    "tradeCoinType":"SELL",
    "price":333,
    "amount":2
}

nonceStr = str(getNonceStr(NONCE_LEN))
timestamp = getTimeStamp()

params={
    "businessNo":BUSINESS_NO,
    "data":data,
    "sign":generateSign(data, timestamp, nonceStr, API_SECRET),
    "nonceStr":nonceStr,
    "timestamp":timestamp
}

url_path = "https://www.upxide.com/exchangeApi/api/matchOrder"
res = requests.post(url_path, data=json.dumps(params))
result = res.json()


print(result)



###### /api/cancel
print("### Cancel Order")
data = {
    "outOrderNo":generateOrderNo()
}

nonceStr = str(getNonceStr(NONCE_LEN))
timestamp = getTimeStamp()

params={
    "businessNo":BUSINESS_NO,
    "data":data,
    "sign":generateSign(data, timestamp, nonceStr, API_SECRET),
    "nonceStr":nonceStr,
    "timestamp":timestamp
}

url_path = "https://www.upxide.com/exchangeApi/api/cancel"
res = requests.post(url_path, data=json.dumps(params))
result = res.json()


print(result)



###### /api/orderquery
print("### Order Query")
data = {
    "outOrderNo":generateOrderNo()
}

nonceStr = str(getNonceStr(NONCE_LEN))
timestamp = getTimeStamp()

params={
    "businessNo":BUSINESS_NO,
    "data":data,
    "sign":generateSign(data, timestamp, nonceStr, API_SECRET),
    "nonceStr":nonceStr,
    "timestamp":timestamp
}

url_path = "https://www.upxide.com/exchangeApi/api/orderquery"
res = requests.post(url_path, data=json.dumps(params))
result = res.json()


print(result)





