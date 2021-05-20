import datetime
from faker import Faker
import random
import pandas as pd

if __name__ == '__main__':
    fake = Faker(locale='zh_CN')
    lst = []
    symptomchoice=["头晕","胸闷","发热","乏力","干咳","鼻塞","流涕","咽痛","腹泻","低氧血症","休克"]
    size = 100
    i = 1
    while i <= size:
        dignosis_id=i
        patient_id = random.randint(1,size)
        doctor_id=random.randint(1,size)
        
        #get date and time
        d=fake.date_between_dates(date_start=datetime.date(2020,1,1),date_end=datetime.date(2021,5,10))
        t=fake.time(pattern="%H:%M:%S", end_datetime=None)
        time=str(d)+' '+str(t)

        #get the combination of symptom
        res=random.sample(range(0,10),3)
        symptom=symptomchoice[res[0]]
        for j in range(1,3):
            symptom=symptom+','+symptomchoice[res[j]]
        
        temperature=random.uniform(36.0,42.0)
        temperature=('%.1f'%temperature)
        
        if(random.randint(0,1)==0):
            nucleic_acid="阳性"
        else:
            nucleic_acid="阴性"

        t = [dignosis_id,patient_id,doctor_id,time,symptom,temperature,nucleic_acid]
        lst.append(t)
        i = i + 1
    result = pd.DataFrame(data=lst)
    result.to_csv('diagnosis.csv')
