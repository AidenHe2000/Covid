import datetime

from faker import Faker
import random
import pandas as pd

if __name__ == '__main__':
    fake = Faker(locale='zh_CN')
    lst = []
    rolechoice=["doctor","user"]
    size = 1000000
    i = 1
    while i <= size:
        user_id = i
        if random.randint(0, 1) == 0:
            user_gender = '男'
            user_name = fake.name_male()
            role=rolechoice[0]
        else:
            user_gender = '女'
            user_name = fake.name_female()
        
        if random.randint(0, 1) == 0:
            role=rolechoice[0]
        else:
            role=rolechoice[1]
        password=fake.password(length=10, special_chars=True, digits=True, upper_case=True, lower_case=True)
        user_email=fake.ascii_free_email()
        registration_date= fake.date(pattern='%Y-%m-%d', end_datetime=datetime.date(1991, 1, 1))
        password_change_date=fake.date_between_dates(date_start=datetime.date(2020,2,1), date_end=datetime.date(2021,5,10)) 
        registration_ip=fake.ipv4(network=False, address_class=None, private=None)

        t = [user_id,user_name,password,user_email,registration_date,role,user_gender,password_change_date,registration_ip]
        lst.append(t)
        i = i + 1
    result = pd.DataFrame(data=lst)
    result.to_csv('user5.csv')
