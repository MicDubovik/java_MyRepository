
SELECT cars.model,body.title,transmission.title,engine.title FROM cars,body,transmission,engine
WHERE cars.body =body.id  AND cars.transmission =transmission.id AND cars.engine=engine.id;