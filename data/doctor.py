import datetime

from faker import Faker
import random
import pandas as pd

if __name__ == '__main__':
    fake = Faker(locale='zh_CN')
    lst = []
    dep = ['呼吸内科', '消化内科', '神经科', '心血管内科',
           '肾内科', '血液内科', '免疫科', '内分泌科',
           '心胸外科', '泌尿外科', '心血管外科', '肝胆外科',
           '儿科', '消化内科', '消化内科', '消化内科']
    size = 100
    i = 1
    while i <= size:
        doctor_id = i
        hospital_id = random.randint(1, 9999)
        if random.randint(0, 1) == 0:
            doctor_gender = '男'
            doctor_name = fake.name_male()
        else:
            doctor_gender = '女'
            doctor_name = fake.name_female()
        doctor_birthday = fake.date(pattern='%Y-%m-%d', end_datetime=datetime.date(1991, 1, 1))
        department = dep[random.randint(0, len(dep) - 1)]
        t = [doctor_id, doctor_name, doctor_gender, doctor_birthday, department, hospital_id]
        lst.append(t)
        i = i + 1
    result = pd.DataFrame(data=lst)
    result.to_csv('doctor.csv')
