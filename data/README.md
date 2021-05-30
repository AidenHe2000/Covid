# Data generator

The codes used to generate data.

---

| file name       | description           | scale now |
| :-------------- | :-------------------- | ---------: |
| doctor.py       | generate doctors      | 100,000    |
| hospital.py     | generate hospitals    | 10,000     |
| user.py         | generate users        | 200,000   |
| diagnosis.py    | generate diagnosis    | 4,000,000   |
| image.py        | generate images       | 2,000,000   |
| patient.py      | generate patients     | 600,000   |
| medicine.py     | generate medicine     | 84        |
| prescription.py | generate prescription | 400,000   |

---

Data will be generated into a `csv` file.

---

- Use the `sql` file to create tables and indices.
  We use the `PostgreSQL` dialect.

- After import the `csv` files make sure to set the current serial of the table to the maximum of the current primary key.

  - e.g.

    ```sql
    select setval('medicine_medicine_id_seq',max(medicine_id)) from medicine;
    ```

    

---

> [Faker](https://github.com/joke2k/faker), [Pandas](https://pypi.org/project/pandas/)

