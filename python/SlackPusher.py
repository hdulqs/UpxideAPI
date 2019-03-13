# Lee
# July 29, 2018

import configparser
from slacker import Slacker
from BasePusher import PusherImpl

class SlackPuher(PusherImpl):
	def __init__(self):
		config = configparser.ConfigParser()
		config.read('conf/config.ini')
		token = config['SLACK']['TOKEN']		
		self.slack = Slacker(token)

	def sendMessage(self, thread=None, message=None):
		self.slack.chat.post_message(thread, message)

# if __name__ == '__main__':   
# 	app = SlackPuher()
# 	app.sendMessage("#general","this is the test message")