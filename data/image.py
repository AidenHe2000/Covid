import datetime
from faker import Faker
import random
import pandas as pd

if __name__ == '__main__':
    fake = Faker(locale='zh_CN')
    lst = []
    situation=["良好","一般","糟糕","危险","病危"]
    action=["可以出院","仍需观察","多加关注","转入ICU","通知家属"]

    size = 2000000
    i = 1
    while i <= size:
        image_id=i
        patient_id = random.randint(1,1000000)
        doctor_id=random.randint(1,100000)
        
        image_picture="D:\Covid\pic\\"+str(i)+".jpg"
        
        idx=random.randint(0,len(situation)-1)

        conclusion="患者情况"+situation[idx]+","+action[idx]
        
        #get the combination of doctor_id
        res=random.sample(range(1,100001),3)
        scanning_doctor_id=str(res[0])
        for j in range(1,3):
            scanning_doctor_id=scanning_doctor_id+','+str(res[j])

        conclusion_doctor_id=random.choice(res)

        t = [image_id,patient_id,doctor_id,image_picture,conclusion,conclusion_doctor_id,scanning_doctor_id]
        lst.append(t)
        i = i + 1
    result = pd.DataFrame(data=lst)
    result.to_csv('image.csv')
