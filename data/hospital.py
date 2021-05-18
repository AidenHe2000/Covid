from faker import Faker
import pandas as pd

if __name__ == '__main__':
    fake = Faker(locale='zh_CN')
    lst = []
    size = 30000
    i = 1
    while i <= size:
        hospital_id = i
        hospital_name = fake.company_prefix()[0:2]
        hospital_address = fake.address()[:-7]
        t = [hospital_id, hospital_name, hospital_address]
        lst.append(t)
        i = i + 1
    result = pd.DataFrame(data=lst)
    result.to_csv('hospital.csv')
