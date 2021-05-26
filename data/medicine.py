import datetime
from faker import Faker
import random
import pandas as pd

if __name__ == '__main__':
    fake = Faker(locale='zh_CN')
    lst = []
    factory=["白云","葵花","徐氏","何氏","周氏","康泰克","泰诺"]
    func=["退热","清瘟","伪麻"]
    variety=["胶囊","颗粒","冲剂","片"]
    
    medicine_id=1
    introduction="用于退烧。孕妇慎用。"
    for i in factory:
        for j in func:
            for k in variety:
                if(i=="康泰克" or i== "泰诺"):
                    kind="西药"
                else:
                    kind="中药"
                t = [medicine_id,i+j+k,i,introduction,kind]
                lst.append(t)
                medicine_id+=1
    
    
    result = pd.DataFrame(data=lst)
    result.to_csv('medicine.csv')
