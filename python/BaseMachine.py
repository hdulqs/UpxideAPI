# Lee
# July 29, 2018

from abc import ABC, abstractmethod

class MachineImpl(ABC):
    @abstractmethod
    def get_filled_orders(self):
        pass

    @abstractmethod
    def get_ticker(self):
        pass

    @abstractmethod
    def get_wallet_status(self):
        pass

    @abstractmethod
    def get_token(self):
        pass

    @abstractmethod
    def set_token(self):
        pass

    @abstractmethod
    def get_username(self):
        pass

    @abstractmethod
    def buy_order(self):
        pass

    @abstractmethod
    def sell_order(self):
        pass

    @abstractmethod
    def cancel_order(self):
        pass

    @abstractmethod
    def get_my_order_status(self):
        pass
