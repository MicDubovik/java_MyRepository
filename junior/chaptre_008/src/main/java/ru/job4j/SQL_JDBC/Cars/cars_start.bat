set PGPASSWORD=123
psql -U postgres -f user_create.sql
psql -U postgres -f create_cars_db.sql
psql -U postgres -f table_create.sql 
psql -U postgres -f fill_table.sql
psql -U postgres -f show_all.sql
psql -U postgres -f is_null_part_request.sql