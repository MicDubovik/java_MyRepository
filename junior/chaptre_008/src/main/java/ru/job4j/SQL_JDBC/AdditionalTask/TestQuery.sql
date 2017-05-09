SELECT person.name,company.name  FROM  person  LEFT JOIN company ON person.company_id = company.id
WHERE person.company_id<>5;