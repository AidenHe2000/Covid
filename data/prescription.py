import datetime
from faker import Faker
import random
import pandas as pd

if __name__ == '__main__':
    fake = Faker(locale='zh_CN')
    lst = []
    dosages = ["一天一次", "一天两次", "一天餐前三次", "一天餐后三次", "8小时一次"]

    size = 400000
    i = 1
    while i <= size:
        prescription_id = i
        patient_id = random.randint(1, 600000)
        medicine_id = random.randint(1, 84)
        doctor_id = random.randint(1, 100000)
        dosage = random.choice(dosages)
        prescription_date = fake.date_between_dates(date_start=datetime.date(2020, 1, 1),
                                                    date_end=datetime.date(2021, 5, 10))

        t = [prescription_id, patient_id, medicine_id, dosage, "口服", doctor_id, prescription_date]
        lst.append(t)
        i = i + 1
    result = pd.DataFrame(data=lst)
    result.to_csv('prescription.csv')
