# Lee
# July 29, 2018

import requests
import time
import configparser
import secrets
import hashlib
import binascii
import uuid
import operator
import json
import operator
import uuid


from BaseMachine import MachineImpl

class UpxideMachine(MachineImpl):
    ### 106  
    def getNonceStr(self, len):
        return secrets.randbits(len)

    def getTimeStamp(self):
        return int(round(time.time()))

    def md5Hash(self, message):
        return hashlib.md5(message.encode()).hexdigest().upper()

    def generateOrderNo(self):
        return str(uuid.uuid4())

    # implement sign generator.
    # refer to api document,
    def generateSign(self, data, timestamp, nonceStr, apiSecret):
        reqStr = ""
        dataJson={}
        for key in data:
            if data[key] != "":
                dataJson[key] = data[key]    

        dataJson["nonceStr"] = nonceStr
        dataJson["timestamp"] = timestamp
        dataJson["apiSecret"] = apiSecret
        dataJson = dict(sorted(dataJson.items(), key=operator.itemgetter(0,1)))

        for key in dataJson:
            reqStr = reqStr + key + "=" + str(dataJson[key]) 
            reqStr = reqStr+ "&"
        return self.md5Hash(reqStr[:-1])

    def requestURI(self, uri, data):
        res = requests.post(uri, data=json.dumps(data))
        return res.json()

    def __init__(self):
        config = configparser.ConfigParser()
        config.read("conf/config.ini")
        self.BASE_PUBLIC_API_URL  = config["UPXIDE"]["BASE_PUBLIC_API_URL"]
        self.BASE_PRIVATE_API_URL = config["UPXIDE"]["BASE_PRIVATE_API_URL"]
        self.CLIENT_SECRET = config["UPXIDE"]["cilent_secret"]
        self.BUSINESS_NO = config["UPXIDE"]["BUSINESS_NO"]
        self.NONCE_LEN = int(config["UPXIDE"]["NONCE_LEN"])

        # print(self.BASE_PUBLIC_API_URL)
        # print(self.BASE_PRIVATE_API_URL)
        # print(self.CLIENT_SECRET)
        # print(self.BUSINESS_NO)
        # print(self.NONCE_LEN)

    def get_filled_orders(self, symbol):
        
        pass

    def get_ticker(self):
        pass

    def get_wallet_status(self):
        data = {}
        nonceStr = str(self.getNonceStr(self.NONCE_LEN))
        timestamp = self.getTimeStamp()
        
        params={
            "businessNo":self.BUSINESS_NO,
            "data":data,
            "sign":self.generateSign(data, timestamp, nonceStr, self.CLIENT_SECRET),
            "nonceStr":nonceStr,
            "timestamp":timestamp
        }
        print(params)

        url_path = self.BASE_PRIVATE_API_URL+"/api/asset"
        result = self.requestURI(url_path, params)
        ### 
        ### have to implement something 
        ### 
        print(result)

    ## 
    def get_token(self):
        if self.CLIENT_SECRET is not "":
            return self.CLIENT_SECRET
        else:
            raise Exception("Need to set_token")

    def set_token(self):
        ## have to implement sometehing on serverside
        pass

    def get_username(self):
        ## will be implemented
        pass


    def buy_order(self, currency_type, price, qty, order_type):
        time.sleep(1)
        if currency_type is "" or price is "" or qty is "":
            raise Exception("Need to param")

        data = {
            #"outOrderNo":self.generateOrderNo(),
            "outOrderNo":"5058e704-3878-46fb-ae54-f6a0eac64d0d",
            "symbol":currency_type,
            "tradeCoinFlag":order_type,
            "tradeCoinType":"BUY",
            "price":price,
            "amount":qty
        }

        nonceStr = str(self.getNonceStr(self.NONCE_LEN))
        timestamp = self.getTimeStamp()
        
        params={
            "businessNo":self.BUSINESS_NO,
            "data":data,
            "sign":self.generateSign(data, timestamp, nonceStr, self.CLIENT_SECRET),
            "nonceStr":nonceStr,
            "timestamp":timestamp
        }
        print(json.dumps(params));
        url_path = self.BASE_PRIVATE_API_URL + "/api/matchOrder"
        res = requests.post(url_path, data=json.dumps(params))
        result = res.json()
        print(result)
        ## have to impoement something...        

    def sell_order(self, currency_type, price, qty, order_type):
        time.sleep(1)
        if currency_type is "" or price is "" or qty is "":
            raise Exception("Need to param")

        data = {
            "outOrderNo":self.generateOrderNo(),
            "symbol":currency_type,
            "tradeCoinFlag":order_type,
            "tradeCoinType":"SELL",
            "price":price,
            "amount":qty
        }

        nonceStr = str(self.getNonceStr(self.NONCE_LEN))
        timestamp = self.getTimeStamp()
        
        params={
            "businessNo":self.BUSINESS_NO,
            "data":data,
            "sign":self.generateSign(data, timestamp, nonceStr, self.CLIENT_SECRET),
            "nonceStr":nonceStr,
            "timestamp":timestamp
        }

        url_path = self.BASE_PRIVATE_API_URL + "/api/matchOrder"
        res = requests.post(url_path, data=json.dumps(params))
        result = res.json()
        print(result)
        ## have to impoement something...        

    def cancel_order(self, outTradeNo):
        data = {
            "outTradeNo":outTradeNo
        }

        nonceStr = str(self.getNonceStr(self.NONCE_LEN))
        timestamp = self.getTimeStamp()
        
        params={
            "businessNo":self.BUSINESS_NO,
            "data":data,
            "sign":self.generateSign(data, timestamp, nonceStr, self.CLIENT_SECRET),
            "nonceStr":nonceStr,
            "timestamp":timestamp
        }

        url_path = self.BASE_PRIVATE_API_URL + "/api/cancel"
        res = requests.post(url_path, data=json.dumps(params))
        result = res.json()
        ## have to impoement something...

    def pairList(self):
        url_path = "https://www.upxide.com/exchangeApi/api/pairList"
        res = requests.post(url_path)
        result = res.json()
        print(result)

    def history(self, symbol):
        data = {"symbol": symbol}

        nonceStr = str(self.getNonceStr(self.NONCE_LEN))
        timestamp = self.getTimeStamp()
        
        params={
            "businessNo":self.BUSINESS_NO,
            "data":data,
            "sign":self.generateSign(data, timestamp, nonceStr, self.CLIENT_SECRET),
            "nonceStr":nonceStr,
            "timestamp":timestamp
        }

        url_path = self.BASE_PRIVATE_API_URL + "/api/matchOrder/history"
        res = requests.post(url_path, data=json.dumps(params))
        result = res.json()
        print(result)

    def get_my_order_status(self, symbol):
        data = {
            "symbol":symbol
        }
        nonceStr = str(self.getNonceStr(self.NONCE_LEN))
        timestamp = self.getTimeStamp()
        
        params={
            "businessNo":self.BUSINESS_NO,
            "data":data,
            "sign":self.generateSign(data, timestamp, nonceStr, self.CLIENT_SECRET),
            "nonceStr":nonceStr,
            "timestamp":timestamp
        }

        url_path = self.BASE_PRIVATE_API_URL+"/api/matchOrder/process"
        result = self.requestURI(url_path, params)
        ### 
        print(result)
        pass

if __name__ == "__main__":
    machine = UpxideMachine()
    #for x in range(100):
    #    time.sleep(0.002)
    #    machine.sell_order("KRW_ADA", 1, 500,"FIXED")
    #machine.sell_order("KRW_ADA", 60, 10,"FIXED")
    #machine.buy_order("KRW_ADA", 10, 100,"FIXED")
    #machine.buy_order("KRW_BTC", 7700000, 10,"FIXED");
    #machine.get_wallet_status()
    #machine.pairList();
    #machine.get_my_order_status("BTC_ETH");
    #machine.buy_order;
    machine.history("KRW_BTC")
    #machine.get_my_order_status("KRW_BTC")
