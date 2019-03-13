# Lee
# July 29, 2018

from pymongo import MongoClient
from pymongo.cursor import CursorType
import configparser
from BaseDBHandler import DBHandler

class MongoDBHandler(DBHandler):
    def __init__(self, mode="local", db_name=None, collection_name=None):
        if db_name is None or collection_name is None:
            raise Exception("Need to db name and collection name")
        config = configparser.ConfigParser()
        config.read('conf/config.ini')
        self.db_config = {}
        self.db_config["local_ip"] = config['MONGODB']['local_ip']
        self.db_config["local_port"] = config['MONGODB']['local_port']
        self.db_config["remote_host"] = config['MONGODB']['remote_host']
        self.db_config["remote_port"] = config['MONGODB']['remote_port']
        self.db_config["user"] = config['MONGODB']['user']
        self.db_config["password"] = config['MONGODB']['password']

        if mode == "remote":
            self._client = MongoClient("mongodb://{user}:{password}@{remote_host}:{remote_port}".format(**self.db_config))
        elif mode == "local":
            self._client = MongoClient("mongodb://{local_ip}:{local_port}".format(**self.db_config))

        self._db = self._client[db_name]
        self._collection = self._db[collection_name]

    def set_db_collection(self, db_name=None, collection_name=None):
        if db_name is None:
            raise Exception("Need to dbname name")

        self._db = self._client[db_name]
        if collection_name is not None:
            self._collection = self._db[collection_name]
            
    def get_current_db_name(self):
        return self._db.name

    def get_current_collection_name(self):
        return self._collection.name

    def insert_item(self, data, db_name=None, collection_name=None):
        if db_name is not None:
            self._db = self._client[db_name]
        if collection_name is not None:
            self._collection = self._db[collection_name]
        return self._collection.insert_one(data).inserted_id

    def insert_items(self, datas, db_name=None, collection_name=None):
        if db_name is not None:
            self._db = self._client[db_name]
        if collection_name is not None:
            self._collection_name = self._db[collection_name]
        return self._collection.insert_many(datas).inserted_ids

    def find_items(self, condition=None, db_name=None, collection_name=None):
        if condition is None:
            condition = {}
        if db_name is not None:
            self._db = self._client[db_name]
        if collection_name is not None:
            self._collection = self._db[collection_name]
        return self._collection.find(condition, no_cursor_timeout=True, cursor_type=CursorType.EXHAUST)
    
    def find_item(self, condition=None, db_name=None, collection_name=None):
        if condition is None:
            condition = {}
        if db_name is not None:
            self._db = self._client[db_name]
        if collection_name is not None:
            self._collection = self._db[collection_name]
        return self._collection.find_one(condition)

    def delete_items(self, condition=None, db_name=None, collection_name=None):
        if condition is None:
            raise Exception("Need to condition")
        if db_name is not None:
            self._db = self._client[db_name]
        if collection_name is not None:
            self._collection = self._db[collection_name]
        return self._collection.delete_many(condition)

    def update_items(self, condition=None, update_value=None, db_name=None, collection_name=None):
        if condition is None:
            raise Exception("Need to condition")
        if update_value is None:
            raise Exception("Need to update value")
        if db_name is not None:
            self._db = self._client[db_name]
        if collection_name is not None:
            self._collection = self._db[collection_name]
        return self._collection.update_many(filter=condition, update=update_value)

    def aggregate(self, pipeline=None, db_name=None, collection_name=None):
        if pipeline is None:
            raise Exception("Need to pipeline") 
        if db_name is not None:
            self._db = self._client[db_name]
        if collection_name is not None:
            self._collection = self._db[collection_name]
        return self._collection.aggregate(pipeline)
    

if __name__ == '__main__':   
    db = MongoDBHandler("local", "coiner", "price_info")
    db.delete_items({})
    docs = [
        {"currency":"btc", "price":10000},
        {"currency":"eth", "price":1000},
        {"currency":"xrp", "price":100},
        {"currency":"btc", "price":20000},
        {"currency":"eth", "price":2000},
        {"currency":"xrp", "price":200}
    ]

    db.insert_items(docs)
    # print(db.get_current_db_name)
    # print(db.get_current_collection_name)

    res = db.find_items({'currency':'btc'})

    print(res)


