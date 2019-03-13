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

def makeData():
    businessNo = "100000100000000001"
    apiSecret  = "n9JDYsQuatJtrf4LCQyqoCwHcPaPSZc4Qi2g1oS3BhicNG1t1r5wjEr3VJcpbCsV"
    nonceStr = getNonceStr()
    return ""

def getNonceStr():
    return secrets.randbits(106)


def getRandomHEXString(string_length=32):
    random = str(uuid.uuid4()) # Convert UUID format to a Python string.
    random = random.upper() # Make all characters uppercase.
    random = random.replace("-","") # Remove the UUID '-'.
    return random[0:string_length] # Return the random string.



 def getTimeStamp():
    return int(round(time.time()))
    

def md5Hash(message):
    return hashlib.md5(message.encode()).hexdigest().upper()



def generateSign(data, timestamp, nonceStr, apiSecret):
    dataJson={}
    for key in data:
        if data != None:
            dataJson[key]=data[key]    
    dataJson['nonceStr'] = nonceStr
    dataJson['timestamp'] = timestamp
    dataJson['apiSecret'] = apiSecret
    dataJson = sorted(dataJson.items(), key=operator.itemgetter(0,1))
    dataJson = json.dumps(dataJson)
    sign = md5Hash(dataJson)



def generateSign(data, timestamp, nonceStr, apiSecret):
    dataJson={}
    for key in data:
        if data != None:
            dataJson[key]=data[key]    
    dataJson['nonceStr'] = nonceStr
    dataJson['timestamp'] = timestamp
    dataJson['apiSecret'] = apiSecret
    dataJson = sorted(dataJson.items(), key=operator.itemgetter(0,1))
    dataJson = json.dumps(dataJson)
    sign = md5Hash(dataJson)
#     print(sign)
    
    
    
generateSign({}, getTimeStamp(), getNonceStr(), 'n9JDYsQuatJtrf4LCQyqoCwHcPaPSZc4Qi2g1oS3BhicNG1t1r5wjEr3VJcpbCsV')   