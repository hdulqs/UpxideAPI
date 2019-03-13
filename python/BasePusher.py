# Lee
# July 29, 2018

from abc import ABC, abstractmethod

class PusherImpl(ABC):
	@abstractmethod
	def sendMessage(self, thread, message):
		pass