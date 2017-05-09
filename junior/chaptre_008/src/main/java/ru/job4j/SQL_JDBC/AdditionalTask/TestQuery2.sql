SELECT company.name ,count(person.id) my_count FROM person,company WHERE person.company_id=company.id
GROUP BY company.id,company.name;