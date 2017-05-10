SELECT  *   FROM  body
  LEFT OUTER JOIN  cars   ON body.id = cars.body WHERE cars.body ISNULL ;

SELECT  *   FROM  transmission
  LEFT OUTER JOIN  cars   ON transmission.id = cars.body WHERE cars.transmission ISNULL ;

SELECT  *  FROM  engine
  LEFT OUTER JOIN  cars   ON engine.id = cars.body WHERE cars.engine ISNULL ;