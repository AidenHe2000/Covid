import datetime
from faker import Faker
import random
import pandas as pd

if __name__ == '__main__':
    fake = Faker(locale='zh_CN')
    lst = []
    statuschoice = ["死亡", "治疗中", "痊愈"]
    size = 600000
    i = 1
    while i <= size:
        patient_id = i
        hospital_id = random.randint(1, 10000)
        doctor_id = random.randint(1, 100000)
        if random.randint(0, 1) == 0:
            patient_gender = '男'
            patient_name = fake.name_male()
        else:
            patient_gender = '女'
            patient_name = fake.name_female()
        patient_birthday = fake.date(pattern='%Y-%m-%d', end_datetime=datetime.date(2019, 1, 1))
        onset_place = fake.city()
        onset_date = fake.date_between_dates(date_start=datetime.datetime.strptime(str(patient_birthday), '%Y-%m-%d'),
                                             date_end=datetime.date(2021, 5, 10))
        confirm_date = fake.date_between_dates(date_start=datetime.datetime.strptime(str(onset_date), '%Y-%m-%d'),
                                               date_end=datetime.date(2021, 5, 10))
        flag = random.randint(1, 3)
        if flag == 1:
            status = statuschoice[0]
        elif flag == 2:
            status = statuschoice[1]
        else:
            status = statuschoice[2]
        isdoctor = 0
        t = [patient_id, patient_name, doctor_id, hospital_id, patient_gender, patient_birthday, onset_place,
             onset_date, confirm_date, status, isdoctor]
        lst.append(t)
        i = i + 1
    result = pd.DataFrame(data=lst)
    result.to_csv('patient.csv')
